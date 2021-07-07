package DAO;

import Bean.Userbean;
import JDBC.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    public static boolean registerValidate(Userbean userBean) throws SQLException {
        boolean samName = isExit(userBean.getUsername());

        if(samName == true){
            return false;
        }else{
            return insert(userBean);
        }
    }

    public static int loginValidate(Userbean userBean) throws SQLException {
        /**
         *  return 0 : success
         *  return 1 : can't find username
         *  return 2 : wrong password
         */

        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userbean where username = '" + userBean.getUsername() + "'");
        rs = dbc.getResultSet();
        if (rs == null){
            return 1;
        }
        boolean find = false;
        boolean succ = false;
        while(rs.next()){
            find = true;
            if(rs.getString(2).equals(userBean.getPassword())){
                succ = true;
            }
        }
        dbc.close();

        if(succ == true){
            return 0;
        }else if(find == true){
            return 1;
        }else {
            return 2;
        }
    }

    public static ArrayList<Userbean> getAll() throws SQLException {
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userbean");
        rs = dbc.getResultSet();
        ArrayList<Userbean> UB = new ArrayList<>();
        if (rs == null){
            return UB;
        }
        while(rs.next()){
            Userbean temp = new Userbean();
            temp.setUsername(rs.getString(1));
            temp.setPassword(rs.getString(2));
            temp.setAdmin(rs.getBoolean(3));
            UB.add(temp);
        }
        dbc.close();
        return UB;
    }

    public static Userbean find(String username) throws SQLException {
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        dbc.executeAndQuery("Select * from userbean where username = '" + username + "'");
        rs = dbc.getResultSet();
        Userbean user = new Userbean();
        if (rs == null){
            return user;
        }
        while(rs.next()){
            if(rs.getString(1).equals(username)){
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setAdmin(rs.getBoolean(3));
                break;
            }
        }
        return user;
    }

    public static boolean isExit(String username)throws SQLException{
        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();
        dbc.executeAndQuery("Select * from userbean where username = '" + username + "'");
        dbc.close();
        int count = dbc.getResultRows();
        return (count > 0);
    }

    public static boolean delete(String username) throws  SQLException{

        if(!isExit(username)){
            return false;
        }

        DBConnection dbc = new DBConnection();
        ResultSet rs;
        dbc.getConnection();

        String Str = "Delete from userbean where username = '" + username + "'";
        dbc.execute(Str);
        dbc.close();

        return true;
    }

    public static boolean insert(Userbean user) throws SQLException{
        if(isExit(user.getUsername())){
            return false;
        }
        DBConnection dbc = new DBConnection();
        dbc.getConnection();
        dbc.execute(getSQLInsertString(user));
        dbc.close();

        return true;
    }

    public static boolean update(String oriName,Userbean user) throws SQLException{
        if(!isExit(oriName)){
            return false;
        }
        if(isExit(user.getUsername())){
            return false;
        }
        delete(user.getUsername());
        insert(user);
        return true;
    }

    private static String getSQLInsertString(Userbean user){
        String res = "insert into userbean values ( '" + user.getUsername() + "',md5('" + user.getPassword() + "')," + user.isAdmin() + ")";
        return res;
    }

}
