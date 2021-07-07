package Tool;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTime {
    public static String Date2String(Date date,int opt){
        SimpleDateFormat sdf = getSDF(opt);
        return sdf.format(date);
    }

    public static Date String2Date(String str,int opt) throws SQLException {
        SimpleDateFormat sdf = getSDF(opt);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date Formation
     * @param opt
     */
    private static SimpleDateFormat getSDF(int opt){
        SimpleDateFormat sdf;
        switch (opt){
            case 1:
                sdf = new SimpleDateFormat("yyyyMMdd");
                break;
            case 2:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            default:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
        }
        return sdf;
    }

}
