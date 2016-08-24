package liutf.serializationTest;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-08-02 下午 6:03
 **/
public class SerializationTest {


}

class Demo implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
