package DAO;

import Bean.Blogbean;
import JDBC.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BlogDAO {

    public static boolean isExit(String blogID) throws SQLException{
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userblog where blogID = '" + blogID + "'");
        rs = dbc.getResultSet();

        boolean isExit = false;
        if (rs == null){
            return false;
        }
        while(rs.next()){
            isExit = true;
        }
        dbc.close();
        return isExit;
    }

    public static String getUsername(String blogID) throws SQLException{
        String username = null;
        if(!isExit(blogID)){
            /**
             * Can't Find blogID !
             */
            return username;

        }

        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userblog where blogID = '" + blogID + "'");
        rs = dbc.getResultSet();

        while(rs.next()){
            username = rs.getString(1);
            break;
        }

        dbc.close();

        return username;
    }

    public static Blogbean getBlogbeanByID(String blogID) throws SQLException{
        System.out.println("ID:" + blogID);
        Blogbean blogbean = new Blogbean();

        if(!isExit(blogID)){
            System.out.println("NO EXIST");
            return blogbean;

        }

        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from blogbean where blogID = '" + blogID + "'");
        rs = dbc.getResultSet();

        while(rs.next()){
            blogbean.setWritter(rs.getString(1));
            blogbean.setBlogID(rs.getString(2));
            blogbean.setWrittenTime(rs.getString(3));
            blogbean.setLastTime(rs.getString(4));
            blogbean.setPrivate(rs.getBoolean(5));
            blogbean.setContents(rs.getString(6));
            break;
        }

        dbc.close();
        System.out.println(blogbean.getContents());
        return blogbean;
    }

    public static ArrayList<Blogbean> getBlogbeansByUsername(String username) throws SQLException{
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userblog where username = '" + username + "'");
        rs = dbc.getResultSet();
        ArrayList<Blogbean> BB = new ArrayList<>();
        if (rs == null){
            return BB;
        }
        while(rs.next()){
            Blogbean tmp = new Blogbean();
            tmp = getBlogbeanByID(rs.getString(2));
            BB.add(tmp);
        }
        dbc.close();
        return BB;
    }

    public static ArrayList<Blogbean> getAll() throws SQLException{
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from blogbean");
        rs = dbc.getResultSet();
        ArrayList<Blogbean> BB = new ArrayList<>();
        if (rs == null){
            return BB;
        }
        while(rs.next()){
            boolean prv = rs.getBoolean(5);
            if(prv == false){
                Blogbean tmp = new Blogbean();
                tmp.setWritter(rs.getString(1));
                tmp.setBlogID(rs.getString(2));
                tmp.setWrittenTime(rs.getString(3));
                tmp.setLastTime(rs.getString(4));
                tmp.setPrivate(rs.getBoolean(5));
                tmp.setContents(rs.getString(6));
                BB.add(tmp);
            }
        }
        dbc.close();
        return BB;
    }

    public static boolean insert(Blogbean blogbean) throws SQLException{
        if(isExit(blogbean.getBlogID())){
            return false;
        }
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();
        dbc.execute(getSQLInsertString2Userblog(blogbean));
        dbc.execute(getSQLInsertString2Blogbean(blogbean));
        dbc.close();

        return true;
    }

    public static boolean delete(String blogID) throws SQLException{
        if(!isExit(blogID))return false;

        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("delete from userblog where blogID = '" + blogID + "'");
        rs = dbc.getResultSet();

        return true;
    }

    public static boolean update(String oriBlogID,Blogbean blogbean) throws SQLException{
        if(!isExit(oriBlogID)){
            return false;
        }
        delete(oriBlogID);
        insert(blogbean);
        return true;
    }

    public static int getNextBlogID() throws SQLException{
        int num = 0;
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();
        String Str = "select * from blogs";
        dbc.executeAndQuery(Str);
        rs = dbc.getResultSet();
        while(rs.next()){
            num = rs.getInt(1) + 1;
        }
        dbc.execute("delete from blogs");
        dbc.execute("insert into blogs values(" + num + ")");
        dbc.close();

        return num;
    }

    private static String getSQLInsertString2Userblog(Blogbean blogbean){
        String res = "insert into userblog values ( '" + blogbean.getWritter() + "','" + blogbean.getBlogID() + "')";
        return res;
    }

    private static String getSQLInsertString2Blogbean(Blogbean blogbean){
        String res = "insert into Blogbean values ( '" + blogbean.getWritter() + "','" + blogbean.getBlogID() + "','" + blogbean.getWrittenTime() + "','" + blogbean.getLastTime() + "'," + blogbean.isPrivate() + " ,' " + blogbean.getContents() + "')";
        return res;
    }

}
