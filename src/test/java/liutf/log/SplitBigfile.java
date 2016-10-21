package liutf.log;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 按照特定的规则拆分大文件
 *
 * @author ltf
 * @create 2016-10-18 下午 2:12
 **/
public class SplitBigfile {


    //大文件地址数组
    public static final String[] STR_URL_ARRAY = {
            "http://123.59.36.200/biyaolog/online/BiYaolog/appapi.biyao.com/100.151/bigfile.txt"
    };


    public static void main(String[] args) throws Exception {

        //输入文件目录
        String outFileUrl = "E:\\test\\";


        //大文件地址数组
        String[] strUrlArray = STR_URL_ARRAY;


        //读取，解析文件
        for (String strUrl : strUrlArray) {
            readFile(strUrl);
        }

        System.out.println("输出目录：" + outFileUrl);

    }

    /**
     * 读取文件
     */
    public static void readFile(String file) throws IOException {
        System.out.println("开始解析文件：" + file);

        FileInputStream fism = new FileInputStream(new File(file));

        StringBuilder sb = new StringBuilder();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fism.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        String fileText = sb.toString();

        String regex = "BFH";//拆分方式
        String[] fileArray = fileText.split(regex);
        for (String f : fileArray) {
            if (StringUtils.isNotBlank(f)) {

            }
        }

        fism.close();

        System.out.println("结束解析文件：" + file);
    }


}
