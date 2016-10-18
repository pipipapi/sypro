package liutf.listTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-08-17 下午 3:07
 **/
public class ListTest {

    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<Integer>();
        iList.add(1);
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(9);
        System.out.println(iList.toString().trim().replace("[", "(").replace("]", ")"));
        //iList.remove(1);
        ////System.out.println(iList.toString());
        ////iList.remove(9);
        //
        //System.out.println(iList.remove((Object)9));
        //System.out.println(iList.toString());
        //System.out.println(iList.remove((Object)9));

        //Map<String, String> map = new HashMap<String, String>();
        //map.get("key1") == null ? map.put("key1","value1") : map.put("kye1",map.get("key1")+",value2");

        //Integer i = 1;
        //long l = new Long(i);
        //List<Test> specDetailList = new ArrayList<Test>();
        //Test test1 = new Test();
        //test1.setSurfaceType(null);
        //test1.setSpecCategoryId(new Long(1));
        //
        //Test test2 = new Test();
        //test2.setSurfaceType(true);
        //test2.setSpecCategoryId(new Long(2));
        //
        //Test test3 = new Test();
        //test3.setSurfaceType(false);
        //test3.setSpecCategoryId(new Long(3));
        //
        //specDetailList.add(test1);
        //specDetailList.add(test2);
        //specDetailList.add(test3);
        //
        //List<Integer> specIdList = specDetailList.stream().filter(p -> p.getSurfaceType() == true).map(p -> Integer.parseInt(p.getSpecCategoryId() + "")).distinct().collect(Collectors.toList());
        //System.out.println(specIdList.size());
        //System.out.println(specIdList.toString());

        //int a = 3;
        //int b = 5;
        //int newvalue = add(a, p->p + b);
        //System.out.println(newvalue);

    }


    public static int add(int a, Function<Integer,Integer> addParams){
        int newvalue = addParams.apply(a);
        return newvalue;
    }
}

class Test{
    private Boolean surfaceType;
    private Long SpecCategoryId;

    public Long getSpecCategoryId() {
        return SpecCategoryId;
    }

    public void setSpecCategoryId(Long specCategoryId) {
        SpecCategoryId = specCategoryId;
    }

    public Boolean getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(Boolean surfaceType) {
        this.surfaceType = surfaceType;
    }
}