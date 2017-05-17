package liutf.doTest;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-03-03 下午 2:49
 **/
public class DoTest {

    private static String SF_SEND_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";//顺丰下单接口取件时间格式

    public static void main(String[] args) throws Exception {
        //String ss = ",ssss,ssss,sssss,ssss";
        //String[] ssArray = ss.substring(1).split(",");
        //System.out.println("---");

        //String ss = "{\"pupilDistance\":\"100.22\",\"leftGlass\":{\"axisal\":\"5\",\"axtigmia\":\"20\",\"degree\":\"180\",},\"rightGlass\":{\"axisal\":\"5\",\"axtigmia\":\"20\",\"degree\":\"180\",}}";
        //
        //Set set = new LinkedHashSet();
        //set.add(1);
        //set.add(2);
        //set.add(3);
        //
        //System.out.println(set.toString());


        //JSONArray jsonArray = new JSONArray();
        //for (int i = 0; i < 2; i++) {
        //    JSONObject jsonObject = new JSONObject();
        //    jsonObject.put("name", "name_" + i);
        //    jsonArray.add(jsonObject);
        //}
        //System.out.println(jsonArray.toString());
        //
        //JSONObject jsonObject1 = new JSONObject();
        //jsonObject1.put("name", "test33");
        //jsonArray.add(jsonObject1);
        //System.out.println(jsonArray.toString());
        //
        //JSONObject jsonObject2 = new JSONObject();
        //jsonObject2.put("name", "test11");
        //jsonArray.add(0,jsonObject2);
        //System.out.println(jsonArray.toString());

        //String param  = "2016-08-20 周六 15:00-16:00";
        //getSendTimeStr(getSendStartTime(param));

        //Map<Integer,Map<Long,>>



    }

    public static Date getSendStartTime(String param) {
        System.out.println(param);
        try {
            if (param == null) return null;
            String takeTime = param;
            String[] strs = takeTime.split(" ");
            String[] hourAndMin = strs[2].split("-");
            String sendTimeStr = strs[0] + " " + hourAndMin[0] + ":00";
            System.out.println(sendTimeStr);
            Date sendTime = null;
            try {
                sendTime = DateUtil.formatStringToDate(sendTimeStr, SF_SEND_TIME_FORMAT);
            } catch (ParseException e) {
                //logger.error("顺丰上门取件时间转换错误，传入时间串：" + takeTime + ",截取时间串：" + sendTimeStr, e);
            }
            return sendTime;
        } catch (Exception e) {
            //logger.error("顺丰上门取件时间解析错误，传入取件时间：" + param.getTakeTime());
            return null;
        }
    }

    public static String getSendTimeStr(Date returnTime){

        //转换时间格式       格式年-月-日空格周几空格xx:xx-xx:xx例：2016-08-20 周六 15:00-15:30
        String returnTimeStr = DateUtil.formatDateToString(returnTime, SF_SEND_TIME_FORMAT);
        //确定这天是周几
        String weekDay = DateUtil.getChineseWeekDay(returnTime);
        //加半小时确定上门取件的末尾时间
        Date returnTimeEnd = DateUtil.addDate(returnTime, Calendar.MINUTE, 60);
        String returnTimeEndStr = DateUtil.formatDateToString(returnTimeEnd, SF_SEND_TIME_FORMAT);
        //拼装上门取件时间
        StringBuilder sb = new StringBuilder();
        sb.append(returnTimeStr.substring(0, 10));
        sb.append(" ");
        sb.append(weekDay);
        sb.append(" ");
        sb.append(returnTimeStr.substring(11, 16));
        sb.append("-");
        sb.append(returnTimeEndStr.substring(11, 16));
        String takeTime = sb.toString();
        System.out.println(takeTime);
        return takeTime;
    }

}
