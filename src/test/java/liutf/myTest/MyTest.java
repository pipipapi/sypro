package liutf.myTest;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by ltf on 2016-07-19.
 */
public class MyTest {

    public static void main(String[] args) {
        JSONObject jsonResult = new JSONObject();
        int PRODUCT_LIST_REDIS_COUNTER = 1000;


        int pageIndex = 3;
        int count = 500;


        //if ((1 == pageIndex && accessTimes% homeShowRedisCounter!=0) || (pageIndex > 1 && accessTimes %( homeShowRedisCounter / 2)!=0)) {
        //    System.out.println("不用更新！");
        //}else {
        //    System.out.println("需要更新！");
        //}

        //if (jsonResult == null || (jsonResult != null && count % (pageIndex > 1 ? (PRODUCT_LIST_REDIS_COUNTER / 2) : PRODUCT_LIST_REDIS_COUNTER) == 0)) {
        //    System.out.println("需要更新");
        //} else {
        //    System.out.println("不需更新");
        //}


        String id = "sf0104389904";
        System.out.println(id.replace("sf",""));
    }
}
