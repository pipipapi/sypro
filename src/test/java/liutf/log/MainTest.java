package liutf.log;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-09-29 下午 6:16
 **/
public class MainTest {

    public static void main(String[] args) {

        //int index = 0;
        //
        //String str = ",1,2,3,4,5,6";
        //String[] strArray = str.split(",");
        //for (String s : strArray) {
        //    if (StringUtils.isNotBlank(s)) {
        //        index = index + 1;
        //
        //        String ss = str.substring(index - 1, index + s.length());
        //        System.out.println("ss-->" + ss);
        //
        //        index = index + s.length();
        //
        //    }
        //
        //
        //}

        String str = "[RedisShopCarLoginDaoImp.java:142][ERROR]:确认订单接口|缓存中获取到的购物车数量为：null|数据库查询到的购物车数量为：8|用户idcard=3657242";
        System.out.println(str.split("[ERROR]")[0]);
    }
}
