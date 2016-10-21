package liutf.log;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-09-29 下午 5:28
 **/
public class LogFilesCarding {


    public static void main(String[] args) throws Exception {

        File outFile = new File("E:\\test\\" + System.currentTimeMillis() + ".txt");//输出文件目录

        //1、获取目标文件夹下的所子目录
        File file = new File("E:\\test");
        File[] listFiles = file.listFiles();
        if (listFiles == null) return;
        for (File f : listFiles) {
            File[] logListfiles = f.listFiles();
            if (logListfiles == null) return;
            for (File logFile : logListfiles) {

                System.out.println("----开始解析日志文件：" + logFile + "----");

                FileInputStream fis = new FileInputStream(logFile);
                StringBuilder sb = new StringBuilder();

                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = fis.read(bytes)) != -1) {
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }

                String logFileText = sb.toString();
                int logFileTextLength = logFileText.length();

                int index = 0;

                //日期正则2016-09-29 05:20:50,038
                String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}";
                int timeLength = 23;
                String[] timeLogArray = logFileText.split(regex);
                for (String timeLog : timeLogArray) {
                    //System.out.println("---------------------------------------------------------");
                    //System.out.println(timeLog);
                    if (StringUtils.isNotBlank(timeLog)) {
                        index = index + timeLength;

                        String allTimeLog = logFileText.substring(index - timeLength, index + timeLog.length() > logFileTextLength ? logFileTextLength : index + timeLog.length());

                        //System.out.println(allTimeLog);
                        //System.out.println("---------------------------------------------------------");

                        //输出到指定文件
                        if (allTimeLog.indexOf("com.biyao.api.mvc.refund.RefundController") > 0 || allTimeLog.indexOf("com.biyao.api.refund.service.impl.RefundServiceImpl") > 0) {

                            //输出文件目录
                            FileWriter fileWriter = new FileWriter(outFile, true);
                            System.out.println("输出日志：");
                            System.out.println(allTimeLog);
                            fileWriter.write("\n");
                            fileWriter.write(allTimeLog);
                            fileWriter.close();
                        }

                        index = index + timeLog.length();
                    }
                }

                fis.close();

                System.out.println("----结束解析日志文件：" + logFile + "----");
                System.out.println();
            }
        }


    }
}
