package liutf.jsonTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Json测试
 *
 * @author ltf
 * @create 2016-10-26 下午 5:32
 **/
public class JsonTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("test11");
        jsonArray.add("test22");
        jsonObject.put("jsonObject", jsonArray);
        System.out.println(jsonObject.toString());
    }
}
