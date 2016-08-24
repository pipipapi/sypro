package liutf.DataBeforAfter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ltf on 2016-07-12.
 */
public class DateBeforAfter {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr1 = "20150-01-01 00:00:01";
        String dateStr2 = "20150-01-01 00:00:02";
        String dateStr3 = "20150-01-01";
        String dateStr4 = "20150-01-01";
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            date1 = sdf.parse(dateStr1);
            date2 = sdf.parse(dateStr2);

            date3 = sdf2.parse(dateStr3);
            date4 = sdf2.parse(dateStr4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean b1_1 = date2.after(date1);
        System.out.println("b1_1-->" + b1_1);
        boolean b1_2 = date2.before(date1);
        System.out.println("b1_2-->" + b1_2);
        boolean b1_3 = date2.equals(date1);
        System.out.println("b1_3-->" + b1_3);

        boolean b2_1 = date3.after(date4);
        System.out.println("b2_1-->" + b2_1);
        boolean b2_2 = date3.before(date4);
        System.out.println("b2_2-->" + b2_2);
        boolean b2_3 = date3.equals(date4);
        System.out.println("b2_3-->" + b2_3);

        boolean b3_1 = date1.after(date3);
        boolean b3_2 = date1.before(date3);
        boolean b3_3 = date1.equals(date3);
        System.out.println("b3_1-->"+b3_1+",b3_2-->"+b3_2+",b3_3-->"+b3_3);


    }
}
