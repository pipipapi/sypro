package liutf.fileTest;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-07-29 下午 4:20
 **/
public class FileTest {

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("..//readme.txt");
        //System.out.println(file.getAbsolutePath());

        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter("readme.txt");
            int [] a=new int[]{11112,222,333,444,555,666};
            for (int i = 0; i < a.length; i++) {
                fileWriter.write(String.valueOf(a[i])+" ");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
