package JDBC;
import java.sql.*;

public class DBConnection {
    private static Connection conn = null;
    private static PreparedStatement stt = null;
    private static ResultSet rs = null;
    private static int count = 0;
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/RacoonBlog?&useSSL=false&serverTimezone=UTC";
    private static final String DBNAME = "root";
    private static final String DBPASS = "root";
    public static void getConnection() throws SQLException {
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBNAME,DBPASS);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void close() throws SQLException {
        rs.close();
        stt.close();
        conn.close();
    }
    public static void execute(String statement) throws SQLException {
        if(conn == null)return;
        stt = conn.prepareStatement(statement);
        stt.execute();
    }
    public static void executeAndQuery(String statement) throws SQLException {
        if(conn == null)return;
        stt = conn.prepareStatement(statement);
        rs = stt.executeQuery();
        count = 0;
        while(rs.next()){
            count++;
        }
        stt = conn.prepareStatement(statement);
        rs = stt.executeQuery();
    }
    public static int getResultRows() throws SQLException {
        return count;
    }
    public static ResultSet getResultSet() {
        return rs;
    }
    public static void printResultSet() throws SQLException {
        ResultSet R = rs;
        while(R.next()) {
            System.out.println("");
            for(int i = 1;i <= count;++i) {
                System.out.println(R.getString(i));
            }
            System.out.println("");
        }
    }
}