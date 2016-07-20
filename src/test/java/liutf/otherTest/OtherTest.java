package liutf.otherTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liutengfei on 16/7/19.
 */
public class OtherTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String datestr = sdf.format(date);
        System.out.println(datestr);
        System.out.println(date.getTime());
    }
}
