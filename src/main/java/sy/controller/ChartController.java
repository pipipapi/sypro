
package sy.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sy.dao.impl.UserDaoImpl;
import sy.model.po.TuserPo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图表控制器
 * 
 * @author 孙宇
 * 
 */

@Controller
@RequestMapping("/chartController")
public class ChartController extends BaseController {

	@Autowired
	private UserDaoImpl userDaoImpl;

	/**
	 * 用户创建时间图表
	 * 
	 * @return
	 */

	@RequestMapping("/userCreateDatetimeChart")
	public String userCreateDatetimeChart(HttpServletRequest request) {

		List<Integer> result = new ArrayList<Integer>();
		int k = 0;
		for (int i = 0; i < 12; i++) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("s", k);
			params.put("e", k + 2);
			k = k + 2;
			result.add(userDaoImpl.count(TuserPo.class,"countBetweenMonths", params));
		}

		request.setAttribute("userCreateDatetimeChart", JSON.toJSONString(result));
		return "/charts/userCreateDatetimeChart";
	}

}

