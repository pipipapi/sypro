package liutf.debangwuliu;

import com.alibaba.druid.util.Base64;
import sy.util.MD5Util;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-09-06 下午 4:00
 **/
public class DebangwuliuDemo {


    public static void main(String[] args) {

        String companyCode = "DIANSHANG";

        String params = "{\"backSignBill\":\"0\",\"businessNetworkNo\":\"W011302020515\",\"cargoName\":\"干果\",\"codType\":\"1\",\"codValue\":200,\"customerID\":\"chanelUserA\",\"deliveryType\":\"0\",\"insuranceValue\":3000,\"logisticCompanyID\":\"DEPPON\",\"orderSource\":\"ALIBABA\",\"logisticID\":\"AL353453253\",\"serviceType\":\"1\",\"payType\":\"0\",\"gmtCommit\":\" 2012-11-27 18:44:19\",\"receiver\":{\"address\":\"明珠路1018号\",\"city\":\"上海市\",\"county\":\"青浦区\",\"mobile\":\"15800000000\",\"name\":\"宝某某\",\"phone\":\"\",\"province\":\"上海\"},\"sender\":{\"address\":\"北京中路100号\",\"city\":\"贵阳市\",\"county\":\"花溪区\",\"mobile\":\"15800000001\",\"name\":\"淘某某\",\"phone\":\"\",\"province\":\"贵州省\"},\"smsNotify\":true,\"toNetworkNo\":\"W01061502\",\"totalNumber\":500,\"totalVolume\":400,\"totalWeight\":300,\"transportType\":\"QC_JZKH\",\"vistReceive\":\"Y\"}";
        long timestamp = System.currentTimeMillis();
        String apikey = "cba123";
        String digest = Base64.byteArrayToBase64(MD5Util.md5(params + apikey + timestamp).getBytes());






    }

}
