package sy.util;

import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParseUtil {


    /**
     * 将list装换为元素类型为T的另一个list
     * @param list
     * @param clazz
     * @param <T>
     * @return
//     */
//    public static <T> List<T> parse(List list, Class<T> clazz){
//        List<T> newlist=new ArrayList<T>();
//        try {
//            for (Object object:list){
//
//                if(clazz == String.class) {
//                    T t = String.valueOf(object);
//                }
//                newlist.add();
//            }
//        }catch (Exception e){
//            throw new ClassCastException("list中不能的元素不能转换为类型"+clazz.getName());
//        }
//        return newlist;
//    }



}
