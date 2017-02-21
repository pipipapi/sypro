package liutf.ForCircleTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-08-24 上午 10:35
 **/
public class ForCircleTest {

    public static void main(String[] args) {

        List<Long> suIds = new ArrayList<>();
        for(int i=0;i<200;i++){
            suIds.add(new Long(i + 1));
        }
        checkInventoryBySus(suIds);

    }

    public static List<Long> checkInventoryBySus(List<Long> suIds) {
        int maxNum = 99;// 库存server最大支持99个su同时校验
        StringBuffer nums = new StringBuffer();
        StringBuffer suIdBuffer = new StringBuffer();
        Map<Long, Integer> canBuyNum = new HashMap<Long, Integer>();
        Map<Long, Integer> result = null;
        for (int i = 0; i < suIds.size(); i++) {
            if (suIdBuffer.length() != 0) {
                nums.append(",");
                suIdBuffer.append(",");
            }
            if (i > 0 && i % maxNum == 0) {
                //result = SocketClient.checkStockLong(suIdBuffer.toString(), nums.toString());
                //if (result != null) {
                //    canBuyNum.putAll(result);
                //}

                System.out.println("-------------------1--------------------");
                System.out.println(suIdBuffer.toString());
                System.out.println(nums.toString().split(",").length);
                suIdBuffer = new StringBuffer();
                nums = new StringBuffer();

            }
            suIdBuffer.append(suIds.get(i));
            nums.append("1");
        }
        List<Long> canNotBuyList = new ArrayList<Long>();
        if (suIdBuffer.length() > 0) {
            //result = SocketClient.checkStockLong(suIdBuffer.toString(), nums.toString());
            //if (result != null) {
            //    canBuyNum.putAll(result);
            //}
            System.out.println("-------------------2--------------------");
            System.out.println(suIdBuffer.toString());
            System.out.println(nums.toString().split(",").length);
        }
        if (canBuyNum != null) {
            for (Long suId : canBuyNum.keySet()) {
                if (canBuyNum.get(suId) == 0) {
                    canNotBuyList.add(suId);
                }
            }
        }
        return canNotBuyList;
    }



}
