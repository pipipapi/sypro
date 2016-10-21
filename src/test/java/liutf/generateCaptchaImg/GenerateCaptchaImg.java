package liutf.generateCaptchaImg;

/**
 * 测试验证码的使用
 *
 * @author ltf
 * @create 2016-09-27 下午 2:15
 **/
public class GenerateCaptchaImg {

    public static final String uri = "http://192.168.96.88:8080/auth-soa-web/rest/generateCaptchaImg?uuid=asdfasdfasdfasdf12312434123";

    //public static void main(String[] args) {
    //
    //    URL url = new URL(uri);
    //
    //    InputStream in = null;
    //    try {
    //        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    //        conn.setRequestMethod("POST");
    //        conn.setDoOutput(true);
    //        //超时3秒，返回“timeout”
    //        conn.setConnectTimeout(1500);
    //        conn.setReadTimeout(1500);
    //        OutputStream os = conn.getOutputStream();
    //        os.write(("xml=" + xmlReq + "&verifyCode=" + verifyCode)
    //                .getBytes("utf8"));
    //        os.close();
    //        in = conn.getInputStream();
    //    } catch (SocketTimeoutException e) {
    //        logger.error("顺丰接口访问超时");
    //        return "timeout";
    //    }
    //
    //
    //}


}
