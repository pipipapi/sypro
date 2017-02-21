package liutf.jsonTest;

/**
 * Json测试
 *
 * @author ltf
 * @create 2016-10-26 下午 5:32
 **/
public class JsonTest {


    public static void main(String[] args) {
        //JsonObject
    }
}

/**
 * The type Test bean.
 */
class TestBean {
    private String name;

    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
