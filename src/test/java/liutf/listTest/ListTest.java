package liutf.listTest;

/**
 * ${DESCRIPTION}
 *
 * @author ltf
 * @create 2016-08-17 下午 3:07
 **/
public class ListTest {

    //private static String disposeSpecIds(String specIds) {
    //    if (StringUtils.isBlank(specIds))
    //        return "";
    //    List<Integer> specIdList = new ArrayList<>();
    //    JSONArray jsonArray = JSONArray.fromObject(specIds);
    //    for (int i = 0; i < jsonArray.size(); i++) {
    //        int specId = jsonArray.getInt(i);
    //        specIdList.add(specId);
    //    }
    //    specIdList.sort((o1, o2) -> (o1 < o2 ? -1 : 1));
    //    return specIdList.toString().trim().replace("[", "").replace("]", "");
    //}

    public static void main(String[] args) {
        //String result = disposeSpecIds("[\"306\",\"307\"]");
        //System.out.println(result);

        String ids = "11,22,33,44";
        System.out.println(ids.indexOf("66"));
    }
}
