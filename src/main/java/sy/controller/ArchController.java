package sy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.transform.Rotate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/arch")
public class ArchController extends BaseController {


    @RequestMapping("/query")
    public String query(HttpServletRequest request){
        return "/arch/query";
    }

    @RequestMapping("/querydata")
    public JSONObject querydata(HttpServletRequest request){

        JSONObject root=new JSONObject();

        root.put("node2","c#");
        root.put("node3","nodejs");
        root.put("node4","sql");
        root.put("node5","javascript");

        JSONObject node1=new JSONObject();
        node1.put("node1-1","io");
        node1.put("node1-2","多线程");
        node1.put("node1-3","面向对象");

        root.put("node1",node1);
        request.setAttribute("data", root.toJSONString());
        return root;
    }
}
