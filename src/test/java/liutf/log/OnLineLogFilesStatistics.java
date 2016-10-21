package liutf.log;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计错误日志类型和出现频率
 *
 * @author ltf
 * @create 2016-09-29 下午 5:28
 **/
public class OnLineLogFilesStatistics {


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
        String outFileUrl = "E:\\test\\" + System.currentTimeMillis() + ".txt";


        //日志文件网络地址数组
        String[] strUrlArray = STR_URL_ARRAY;

        //统计map
        Map<String, Integer> statisticsMap = new HashMap<>();

        //读取，解析文件
        for (String strUrl : strUrlArray) {
            readLog(strUrl, statisticsMap);
        }

        //输出日志统计结果
        for (String key : statisticsMap.keySet()) {
            FileWriter fileWriter = new FileWriter(new File(outFileUrl), true);
            fileWriter.write("--------------------------------------------");
            fileWriter.write("\n");
            fileWriter.write("日志出现频率：" + statisticsMap.get(key));
            fileWriter.write("\n");
            fileWriter.write(key);
            fileWriter.write("\n");

            fileWriter.close();
        }

        System.out.println("输出目录：" + outFileUrl);

    }

    /**
     * 读取日志
     */
    public static void readLog(String strUrl, Map<String, Integer> statisticsMap) throws IOException {
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

        analyzeLog(logFileText, statisticsMap);

        fis.close();

        System.out.println("结束解析文件：" + strUrl);
    }


    /**
     * 统计日志
     */
    public static void analyzeLog(String logFileText, Map<String, Integer> statisticsMap) throws IOException {

        //日期正则2016-09-29 05:20:50,038
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}\\s";
        String[] timeLogArray = logFileText.split(regex);
        for (String timeLog : timeLogArray) {
            if (StringUtils.isNotBlank(timeLog)) {

                String timeLogHeader = timeLog.split("\\[ERROR\\]")[0] + "[ERROR]";

                if (statisticsMap.containsKey(timeLogHeader)) {
                    statisticsMap.put(timeLogHeader, statisticsMap.get(timeLogHeader) + 1);
                } else {
                    statisticsMap.put(timeLogHeader, 1);
                }
            }
        }
    }

}
