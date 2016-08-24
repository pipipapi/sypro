package liutf.stream.test;

import java.io.*;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-08-08 下午 4:09
 **/
public class FileInputStreamTest {


    /**
     * 字符流读取和写入
     */
    public static void readerAndWriter() {
        //File file = null;
        Reader reader = null;
        Writer writer = null;
        try {
            //输入流
            File file = new File("D:\\java_tools\\workspace_all\\idea_workspace\\sypro-master\\src\\test\\java\\liutf\\stream\\test\\readme.txt");
            File file2 = new File("D:\\java_tools\\workspace_all\\idea_workspace\\sypro-master\\src\\test\\java\\liutf\\stream\\test\\writeme.txt");

            reader = new FileReader(file);

            //输出流
            writer = new FileWriter(file2);

            char[] buffer = new char[1024];
            int len = 0;
            while ((len = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
                writer.write(buffer, 0, len);
            }

            reader.close();
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流读取和写入
     */
    public static void InputStreamAndOutPutStream() {
        InputStream is = null;
        OutputStream os = null;

        File file = new File("D:\\java_tools\\workspace_all\\idea_workspace\\sypro-master\\src\\test\\java\\liutf\\stream\\test\\readme.txt");
        File file2 = new File("D:\\java_tools\\workspace_all\\idea_workspace\\sypro-master\\src\\test\\java\\liutf\\stream\\test\\writeme.txt");

        try {
            is = new FileInputStream(file);
            os = new FileOutputStream(file2);
            StringBuffer sbf = new StringBuffer();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                //System.out.println(new String(bytes, 0, len));
                os.write(bytes, 0, len);
                sbf.append(new String(bytes, 0, len));
            }

            System.out.println(sbf.toString());

            is.close();
            os.flush();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件末尾追加（FileWriter方式）
     */
    public static void fileWrite(){
        File file2 = new File("D:\\java_tools\\workspace_all\\idea_workspace\\sypro-master\\src\\test\\java\\liutf\\stream\\test\\writeme.txt");
        try {
            FileWriter fileWriter = new FileWriter(file2,true);
            String str = "\n追加的文字";
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //readerAndWriter();
        //InputStreamAndOutPutStream();
        //fileWrite();
    }
}
