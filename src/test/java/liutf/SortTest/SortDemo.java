package liutf.SortTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2017-02-20 下午 5:29
 **/
public class SortDemo {

    public static void main(String[] args) {
        List<Integer> sortList = new ArrayList<>();
        sortList.add(2);
        sortList.add(1);
        sortList.add(4);
        sortList.add(3);
        sortList.add(6);
        sortList.add(5);
        sortList.add(8);
        sortList.add(7);
        sortList.add(10);
        sortList.add(9);

        Collections.sort(sortList, (a, b) -> (a.intValue()) > b.intValue() ? -1 : 1);

        System.out.println(sortList.toString());

    }
}
