import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;




public class zipcode

{

 public static void main( String[] madnix ) throws Exception

 {

  Class.forName( "oracle.jdbc.driver.OracleDriver" );




  Statement stmt = null;

  Connection conn = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin" );




  try

  {

   conn.setAutoCommit( true );

   stmt = conn.createStatement();




   BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream( "C:/JavaDevProject/Portfolilo/GameInfo/sql/mem_join/zipcode-04.sql" ), "UTF-8" ) );




   try

   {

    int totCnt = 0;

    int cnt = 0;

    String s;




    long start = System.nanoTime();

    while( ( s = reader.readLine() ) != null )

    {

     totCnt++;

     int charCnt = 0;

     int seq = totCnt;




     




     stmt.addBatch(s);

     cnt++;




     if( cnt == 10000 )

     {

      cnt = 0;

      stmt.executeBatch();

     }

    }




    if( cnt > 0 )

     stmt.executeBatch();




    long end = System.nanoTime();

    System.out.println( ( end - start ) + "(ns)" );

   }

   finally

   {

    reader.close();

   }




   conn.commit();

  }

  finally

  {

   if( stmt != null )

    try

    {

     stmt.close();

    }

    catch( Exception e )

    {

    }

   conn.close();

  }

 }

}
 




