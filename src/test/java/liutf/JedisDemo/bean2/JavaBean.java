package liutf.JedisDemo.bean2;

import java.io.Serializable;

/**
 * Created by ltf on 2016-06-14.
 */
public class JavaBean implements Serializable {

    private static final long serialVersionUID = -8209605509384874274L;

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
