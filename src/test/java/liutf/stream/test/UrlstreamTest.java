package liutf.stream.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-02-21 下午 4:01
 **/
public class UrlstreamTest {

    public static void main(String[] args) {
        try {
            File file = new File("D:" + File.separator + "test.jpg");
            FileOutputStream outputStream = new FileOutputStream(file);

            String urlStr = "http://mmbiz.qpic.cn/mmbiz_jpg/VxCE0fAE8QBRiarBKcPgeMmk9lchWD1vnwZYyH5aZNLbeRbpGxUrjibGxmrG7uJodb0Ocxy6I2dic3myX0WSAt0Ng/0";
            URL url = new URL(urlStr);
            DataInputStream inputStream = new DataInputStream(url.openStream());

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {

                outputStream.write(bytes, 0, len);

            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
