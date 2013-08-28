// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA., or visit one 
// of the links here:
//  http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt
//  http://www.acscdg.com/LICENSE.txt

//////////////////////////////////////////////////////////////////

// This application implements drawing tools on top of Google maps 
//  using JavaScript.

// Web site with this code running: http://www.acscdg.com/


//
//////
// Global variables:
var _fullyLoaded = false;  // This is needed because IE calls the onResize
                           //  call back many times during initialization.

// Application state variables:
var _circleMode = false;
var _wayPointsListManager = null; // The current way point List.
var _currentCircle = null;
var _tempWayPoint = null;

// Filled in at load time:
var _changeUnitsBoxElement;
var _currentDistanceUnits = NAUTICAL_MILES_UNITS;

// Element cache:
var _mapElement;   // The html div element that holds the map,
                   //   used during window resize.
var _tableElement; // The html div element that holds the points table,
                   //  used during window resize. 
var _innerElement; // The html div element that wraps the points table and the map,
                   //   used during window resize. 
var _map;  // Points to the map object, needs to be global for resize.

// Objects created once and shared:
var _wayPointIcon; // The blueX icon at each way point and the center of the circle.
var _adsManager;   // Google maps ad manager. 
var _optsNotClickable = {clickable:false};  // Set all lines as not clickable.
                                            //   Otherwise, the redraw on mouse move doesn't work.

// The map control objects.
var startControl = null;
var wayPointsInProgressControl = null;
var circleInProgressControl = null;
////
//


//
///////////////////////////////////////////////////////


//
//// Called when the "start course" button is pushed.
function startCourse(map)
{
  removeTempWayPoint(map);

  map.removeControl(startControl);
  map.addControl(wayPointsInProgressControl);

  _wayPointsListManager = _tableManager.addWayPointList();
}



//
//// called when either of the "end course" buttons are pushed.
function endCourse(map)
{
  removeTempWayPoint(map);

  map.removeControl(wayPointsInProgressControl);
  map.addControl(startControl);

  _wayPointsListManager = null;
}


//
//// Called when the "end course at last point" button is pushed.
function endCourseAtLast(map)
{
  endCourse(map);
}


//
//// Called when the "end course at first point" button is pushed.
function endCourseAtFirst(map)
{
  if (_wayPointsListManager == null)
    return;

  var firstWayPoint = null;
  if ((firstWayPoint = _wayPointsListManager.getFirstWayPoint()) != null)
  {
    var lastWayPoint = createWayPoint(map, firstWayPoint.point);
    // No need to add another marker.  Although it would be nice to change
    //   the label on the reused marker to 0, [last]

    _wayPointsListManager.pushWayPoint(lastWayPoint);  // make point permanent.
  }
  endCourse(map);
}


//
//// Called when the "remove last point" button is pushed.
function removeLastCoursePoint(map)
{
  removeTempWayPoint(map);

  if (_wayPointsListManager == null)
    return;

  var lastWayPoint;
  if ((lastWayPoint = _wayPointsListManager.removeLastWayPoint()) != null)
  {
    _tempWayPoint = lastWayPoint;

    // Leave the courseLine, because it is now the temp course line.
    map.removeOverlay(lastWayPoint.marker);
    lastWayPoint.marker = null;

    if (_wayPointsListManager.numberOfPoints() == 0)
    {
      // If no points are left, remove the temp way point, too.
      removeTempWayPoint(map);
    }
    else
    {
      ; // there are still points left.
    }
  }
}

//
//// Make the temporary way point permanent.
function chooseWayPoint(map, marker, point)
{
  // Redraw everything in case the mouse moved between the last move event and the button event.
  drawTempWayPoint(map, point);
  var wayPoint = _tempWayPoint;
  _tempWayPoint = null;

  // Leave a marker behind.
  var marker = new GMarker(point, {title: wayPoint.name, icon: _wayPointIcon });
  map.addOverlay(marker);
  wayPoint.marker = marker;

  _wayPointsListManager.pushWayPoint(wayPoint);  // make point permenant.
}



//
//// Called when mouse moves and also after mouse down, via its handler.
function createWayPoint(map, point)
{
  if (_wayPointsListManager == null)
    return null;

  var lastWayPoint = _wayPointsListManager.getLastWayPoint();   // if lastWayPoint is null,
                                                                //  then this is the first point.
  var pointNumber = _wayPointsListManager.numberOfPoints();

  var wayPoint = new WayPoint(map, _wayPointsListManager.courseNumber,
                               pointNumber, point, lastWayPoint, _currentDistanceUnits);

  _wayPointsListManager.addWayPointTableElement(wayPoint);
  
  return(wayPoint);
}


//
//// Removes the overlays, objects, and elements of the temp way point.
function removeTempWayPoint(map)
{
  if (_tempWayPoint != null)
  {
    if (_tempWayPoint.courseLine != null)
      map.removeOverlay(_tempWayPoint.courseLine);

    _wayPointsListManager.removeWayPointTableElement(_tempWayPoint);

    _tempWayPoint = null;
  }
}



//
//// Called when the mouse moves.
function drawTempWayPoint(map, endPoint)
{
  if (_tempWayPoint != null)
    _tempWayPoint.update(map, endPoint, _currentDistanceUnits);
  else
    _tempWayPoint = createWayPoint(map, endPoint);
}


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


//
//// Called from choosePoint
function startCircle(map, centerPoint)
{
  _currentCircle = _tableManager.addCircle(map, centerPoint, _currentDistanceUnits);
}


//
//// Called from choosePoint
function finishCircle(map, edgePoint)
{
  drawTempCircle(map, edgePoint, true);
  _currentCircle = null;
  leaveCircleMode(map);
}


//
//// Called when the "remove last circle" button is pushed.
function eraseLastCircle(map)
{
  _currentCircle = null;

  var lastCircle = _tableManager.removeLastCircle();
  if (lastCircle != null)
    lastCircle.removeOverlays(map);
}


//
//// Called when the mouse button is clicked.
function chooseCirclePoint(map, marker, point)
{
  if (_currentCircle == null)
    startCircle(map, point);  // If this is the first point of a circle,
                              //  then it is the center.
  else
    finishCircle(map, point);  // If it is the second point, then it is a point
                               //  on the edge, and finishes the circle
}


//
//// Called when the mouse moves.
function drawTempCircle(map, edgePoint, finalP)
{
  if (_currentCircle != null)
    _currentCircle.update(map, edgePoint, finalP, _currentDistanceUnits);
}


//////////////////////////////////////////////////////////////////////////////////
//


//
//// Called when the distance units pull down box is changed.
function changeUnits()
{
  _currentDistanceUnits = _changeUnitsBoxElement[_changeUnitsBoxElement.selectedIndex].value;
  _tableManager.redrawPointsTable(_currentDistanceUnits);
  if (_tempWayPoint != null)
  {
    _tempWayPoint.updateElement(_currentDistanceUnits);
  }
}


//
//// Loads the way point icon from a file into memory.
////   only needs to be called once.
function createWayPointIcon()
{
  _wayPointIcon = new GIcon();
  _wayPointIcon.image = "blueX40.png";
  _wayPointIcon.iconSize = new GSize(40, 40);
  _wayPointIcon.iconAnchor = new GPoint(20, 20);
  _wayPointIcon.infoWindowAnchor = new GPoint(24, 16);
}



//
//// Called when the "Clear" button is pushed.
function clearAll(map)
{
  map.clearOverlays();

  _tableManager.clearTable();

  _currentCircle = null;
  _wayPointsListManager = null;
}



//
////
function enterCircleMode(map)
{
  map.removeControl(startControl);
  map.addControl(circleInProgressControl);

  removeTempWayPoint(map);
  _wayPointsListManager = null;
  _circleMode = true;
}


//
////
function leaveCircleMode(map)
{
  map.removeControl(circleInProgressControl);
  map.addControl(startControl);

  if (_currentCircle != null)
    _currentCircle.removeOverlays();
  _currentCircle = null;
  _circleMode = false;
}


//
//// Called when the mouse button is clicked.
function choosePoint(map, marker, point)
{
  if (marker && marker instanceof GMarker)
  {
    // Get the coords of the marker if one was clicked.
    point = marker.getLatLng();
  }

  if (point == null) // if still null, this is a call on the polyline, not the map or a marker.
                     //  remove this after Google improves the API.
    return;

// TODO: It would be great to read back the name of the icon if it was a geo-coded location,
//  to then set the name of the point or circle to the name of the location.

  if (_circleMode)
    chooseCirclePoint(map, marker, point);
  else if (_wayPointsListManager != null)
    chooseWayPoint(map, marker, point);
}


//
//// Called when the mouse moves.
function drawTempPoint(map, point)
{
  if (_circleMode)
    drawTempCircle(map, point, false);
  else
    drawTempWayPoint(map, point);
}



//////////////////////////////////////////////////////////////

//
////
function load()
{
   var isCompatible = false;
   if (GBrowserIsCompatible())
      isCompatible = true;

    if (!isCompatible)
    {
      window.location.replace("notCompatible.html");
      return;
    }

    _tableManager = new TableManager(); // Singleton class.

    _mapElement = document.getElementById("map");
    _tableElement = document.getElementById("pointsTableDiv");
    _innerElement = document.getElementById("inner");

    // Called here to set the global variable from the html default.
    _changeUnitsBoxElement = document.getElementById("changeUnitsBox");
    changeUnits();  

    _map = new GMap2(_mapElement);

    _map.setCenter(new GLatLng(41.3, -95.89), 3); // The center of North America and the Carabean Sea.
                                                  //  Also a runway at OMA airport.

    // Add the Google controls to the map:
    _map.addControl(new GLargeMapControl());
    _map.addControl(new GMapTypeControl());

    // Create and add custom controls to the map:
    startControl = new StartControl();
    wayPointsInProgressControl = new WayPointsInProgressControl();
    circleInProgressControl = new CircleInProgressControl();

    // Set event listeners.  
    GEvent.addListener(_map, "click", function(marker, point)  { choosePoint(_map, marker, point) } );
    GEvent.addListener(_map, "mousemove", function(point)  { drawTempPoint(_map, point) } );

    // Start in non-drawing.
    _map.addControl(startControl);

    // Call one-time functions:
    createWayPointIcon();
    initGeoCoder();

    adsManager = new GAdsManager(_map, "insert_your_google_publisher_id_here"); 
    adsManager.enable();

    _fullyLoaded = true;
    resizeBody(); // Now that everything is set up, set the map size.
}
