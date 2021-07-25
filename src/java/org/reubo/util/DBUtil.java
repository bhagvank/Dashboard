/*
 * DBUtil.java
 *
 * Created on March 16, 2006, 5:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.util;

import java.sql.*;
/**
 *
 * @author bhagvank
 */
public class DBUtil {
    private final static String host ="10.3.1.113:5432/";
    private final static String database = "vbi_dashboard";
    private final static String username = "vbi";
    private final static String password = "vbi";
    /** Creates a new instance of DBUtil */
    public DBUtil() {
    }

    public static  Connection getConnection()
    {
        try
        {
          Class.forName("org.postgresql.Driver"); //load the driver
          Connection db = DriverManager.getConnection("jdbc:postgresql://"+host+database,
                                     username,
                                     password); //connect to the db
          DatabaseMetaData dbmd = db.getMetaData(); //get MetaData to confirm connection
          System.out.println("Connection to "+dbmd.getDatabaseProductName()+" "+
                       dbmd.getDatabaseProductVersion()+" successful.\n");
          //Statement statement sql = db.createStatement(); //create a statement that we can use later
          return db;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
            return null;
    }

    public static void main(String argv[]) throws Exception
    {
        Connection conn = DBUtil.getConnection();

        Statement statement = conn.createStatement();

        ResultSet resultset = statement.executeQuery("select source_account, sum(count) as count from mv_all_users_last_month where reviewer_name='Administrator'group by source_account order by count desc limit 10");
        while(resultset.next())
        {
            System.out.println("User :"+resultset.getString(1)+" Count"+resultset.getString(2));
        }
        conn.close();
    }
}
