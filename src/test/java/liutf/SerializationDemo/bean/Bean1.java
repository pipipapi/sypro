package liutf.SerializationDemo.bean;

import java.io.Serializable;

/**
 * Created by liutengfei on 16/6/14.
 */
public class Bean1 implements Serializable {


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
