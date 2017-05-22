package liutf.serializeTest;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-05-17 下午 6:10
 **/
public class Test {


    private static final RuntimeSchema<TestBean> schema = RuntimeSchema.createFrom(TestBean.class);

    public static void main(String[] args) {

        TestBean testBean = new TestBean();
        testBean.setAge(9);
        testBean.setName("name");
        testBean.setSex(true);

        //long startTime = System.currentTimeMillis();
        //for (int i = 0; i < 10000; i++) {
        byte[] bytes = serialize(testBean);
        //}
        //long endTime = System.currentTimeMillis();
        //System.out.println(endTime-startTime);
        //System.out.println(bytes.length);


        //long startTime = System.currentTimeMillis();
        //for (int i = 0; i < 10000; i++) {
        TestBean testBean1 = unSerialize(bytes);
        //}
        //long endTime = System.currentTimeMillis();
        ////System.out.println(testBean1);
        //System.out.println(endTime-startTime);


        //TestBean1 testBean = new TestBean1();
        //testBean.setAge(9);
        //testBean.setName("name");
        //testBean.setSex(true);
        //
        //byte[] bytes = SerializationUtils.serialize(testBean);
        //
        //long startTime = System.currentTimeMillis();
        //for (int i = 0; i < 10000; i++) {
        //    SerializationUtils.deserialize(bytes);
        //}
        //long endTime = System.currentTimeMillis();
        //System.out.println(endTime-startTime);
        //System.out.println(bytes.length);

    }

    public static byte[] serialize(TestBean obj) {
        byte[] bytes = ProtostuffIOUtil.toByteArray(obj, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        return bytes;
    }

    public static TestBean unSerialize(byte[] bytes) {
        TestBean testBean = schema.newMessage();
        // 使用ProtoStuff从缓存中反序列化对象.
        ProtostuffIOUtil.mergeFrom(bytes, testBean, schema);
        return testBean;
    }
}
