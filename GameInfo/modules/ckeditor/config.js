/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	config.language = 'ko';
	config.uiColor = '#F0F0F0';
	config.removePlugins = 'elementspath,save,font';
	config.filebrowserBrowseUrl = '/GameInfo/modules/ckfinder/ckfinder.html';
    config.filebrowserImageBrowseUrl = '/GameInfo/modules/ckfinder/ckfinder.html?type=Images';
    config.filebrowserFlashBrowseUrl = '/GameInfo/modules/ckfinder/ckfinder.html?type=Flash';
    config.filebrowserUploadUrl = '/GameInfo/modules/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = '/GameInfo/modules/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = '/GameInfo/modules/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
};
