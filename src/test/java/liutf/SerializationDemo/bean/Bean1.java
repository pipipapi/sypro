package liutf.SerializationDemo.bean;

import java.io.Serializable;

/**
 * Created by liutengfei on 16/6/14.
 */
public class Bean1 implements Serializable {

    private static final long serialVersionUID = -1L;

    private static String string = "testtest";

    private transient String name;
    private int age;
    //private boolean flag;

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

    //public boolean isFlag() {
    //    return flag;
    //}
    //
    //public void setFlag(boolean flag) {
    //    this.flag = flag;
    //}

    @Override
    public String toString() {
        return "Bean1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
