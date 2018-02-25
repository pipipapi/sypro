//package sy.pageModel;
//
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public abstract class TreeUtil {
//    public TreeUtil() {
//    }
//
//    public static List<? extends Tree> generateTree(List<? extends Tree> treeNodeList) {
//        Map<String, Object> childrenMap = Maps.newHashMap();
//
//        Iterator var2;
//        Tree treeNode;
//        Object cl;
//        for(var2 = treeNodeList.iterator(); var2.hasNext(); ((List)cl).add(treeNode)) {
//            treeNode = (Tree)var2.next();
//            String pid = treeNode.getPid();
//            cl = (List)childrenMap.get(pid);
//            if (null == cl) {
//                cl = Lists.newArrayList();
//                childrenMap.put(pid, cl);
//            }
//        }
//
//        var2 = treeNodeList.iterator();
//
//        while(var2.hasNext()) {
//            treeNode = (Tree)var2.next();
//            treeNode.setChildren((List)childrenMap.get(treeNode.getId()));
//        }
//
//        return (List)childrenMap.get(0L);
//    }
//}
//
//
