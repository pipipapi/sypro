package liutf.log;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 按照对比文本的方式统计日志
 *
 * @author ltf
 * @create 2016-09-29 下午 5:28
 **/
public class OnLineLogFilesCarding {


    //对比文本数组
    public static final String[] COMP_STR_ARRAY = {
            "org.springframework.web.method.support.InvocableHandlerMethod.invoke"
    };

    //日志文件网络地址数组
    public static final String[] STR_URL_ARRAY = {
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.151/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.152/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.153/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.154/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.155/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.156/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.51/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.52/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.53/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.54/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.55/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.56/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.71/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.72/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.73/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.74/log.txt",
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.75/log.txt"
    };


    public static void main(String[] args) throws Exception {

        //输入文件目录
        String outFileUrl = "E:\\test\\" + System.currentTimeMillis() + ".txt";//输出文件目录

        //日志文件网络地址数组
        String[] strUrlArray = STR_URL_ARRAY;

        //读取，解析文件
        for (String strUrl : strUrlArray) {
            readLog(strUrl, outFileUrl);
        }

        System.out.println("输出目录：" + outFileUrl);

    }

    /**
     * 读取日志
     */
    public static void readLog(String strUrl, String outFileUrl) throws IOException {
        System.out.println("开始解析文件：" + strUrl);

        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream fis = conn.getInputStream();

        StringBuilder sb = new StringBuilder();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        String logFileText = sb.toString();

        analyzeLog(logFileText, new File(outFileUrl));

        fis.close();

        System.out.println("结束解析文件：" + strUrl);
    }


    /**
     * 解析日志
     */
    public static void analyzeLog(String logFileText, File outFile) throws IOException {

        int index = 0;

        //日期正则2016-09-29 05:20:50,038
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}\\s";
        int timeLength = 24;
        String[] timeLogArray = logFileText.split(regex);
        for (String timeLog : timeLogArray) {
            if (StringUtils.isNotBlank(timeLog)) {
                index = index + timeLength;

                String allTimeLog = logFileText.substring(index - timeLength, index + timeLog.length() > logFileText.length() ? logFileText.length() : index + timeLog.length());

                //需要解析出的日志内容
                if (comparisonStr(allTimeLog)) {

                    System.out.println("输出日志：");
                    System.out.println(allTimeLog);

                    //输出到指定文件
                    FileWriter fileWriter = new FileWriter(outFile, true);
                    fileWriter.write("\n");
                    fileWriter.write(allTimeLog);
                    fileWriter.close();
                }

                index = index + timeLog.length();
            }
        }
    }

    /**
     * 对比文本
     */
    public static boolean comparisonStr(String compStr) {
        for (String str : COMP_STR_ARRAY) {
            if (compStr.indexOf(str) > 0)
                return true;
        }
        return false;
    }

}
