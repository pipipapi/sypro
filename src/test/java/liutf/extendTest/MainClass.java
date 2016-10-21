package liutf.extendTest;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-10-21 下午 2:57
 **/
public class MainClass {

    public static void doTest(BaseClass baseClass) {

        String name = baseClass.getName();
        System.out.println("name=" + name);

        SonClass1 sonClass1 = (SonClass1) baseClass;
        String name1 = sonClass1.getName1();
        System.out.println("name1=" + name1);

        SonClass2 sonClass2 = (SonClass2) baseClass;
        String name2 = sonClass2.getName2();
        System.out.println("name2=" + name2);
    }

    public static void main(String[] args) {
        SonClass1 sonClass1 = new SonClass1();
        sonClass1.setName1("name");
        sonClass1.setName("name1");

        doTest(sonClass1);
    }

    public static void doTest22(BaseClass baseClass) {

        boolean goOn = false;
        try {
            SonClass1 sonClass1 = (SonClass1) baseClass;
            // TODO  调用sonClass1的特有方法
        }catch (java.lang.ClassCastException e){
            goOn = true;
        }
        if(goOn){
            try {
                SonClass2 sonClass2 = (SonClass2) baseClass;
                // TODO  调用sonClass2的特有方法

            }catch (java.lang.ClassCastException e){

            }
        }


    }
}
