
package sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sy.dao.ResourceTypeDao;
import sy.dao.impl.ResourceDaoImpl;
import sy.dao.impl.ResourceTypeDaoImpl;
import sy.model.po.TresourcePo;
import sy.pageModel.Json;
import sy.pageModel.Resource;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;
import sy.util.ConfigUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;


/**
 * 资源控制器
 * 
 * @author 孙宇
 * 
 */

@Controller
@RequestMapping("/resourceController")
public class ResourceController extends BaseController {

	@Autowired
	private ResourceDaoImpl resourceDao;

	@Autowired
	private ResourceTypeDao resourceTypeDao;

	/**
	 * 获得资源树(资源类型为菜单类型)
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @param session
	 * @return
	 */

	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return resourceDao.tree(sessionInfo);
	}


	/**
	 * 获得资源树(包括所有资源类型)
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @param session
	 * @return
	 */

	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return resourceDao.allTree(sessionInfo);
	}


	/**
	 * 跳转到资源管理页面
	 * 
	 * @return
	 */

	@RequestMapping("/manager")
	public String manager() {
		return "/admin/resource";
	}


	/**
	 * 跳转到资源添加页面
	 * 
	 * @return
	 */

	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		request.setAttribute("resourceTypeList", resourceTypeDao.getResourceTypeList());
		Resource r = new Resource();
		r.setId(UUID.randomUUID().toString());
		request.setAttribute("resource", r);
		return "/admin/resourceAdd";
	}


	/**
	 * 添加资源
	 * 
	 * @return
	 */

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Resource resource, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		resourceDao.add(resource, sessionInfo);
		j.setSuccess(true);
		j.setMsg("添加成功！");
		return j;
	}

	/**
	 * 跳转到资源编辑页面
	 * 
	 * @return
	 */

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		request.setAttribute("resourceTypeList", resourceTypeDao.getResourceTypeList());
		Resource r = resourceDao.get(id);
		request.setAttribute("resource", r);
		return "/admin/resourceEdit";
	}

	/**
	 * 编辑资源
	 * 
	 * @param resource
	 * @return
	 */

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Resource resource) {
		Json j = new Json();
		try {
			resourceDao.edit(resource);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		}catch (Exception e){
			j.setSuccess(false);
			j.setMsg("编辑失败！");
		}
		return j;
	}

/**
	 * 获得资源列表
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @return
	 */

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<Resource> treeGrid(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return resourceDao.treeGrid(sessionInfo);
	}

	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		TresourcePo param=new TresourcePo();
		param.setId(id);
		resourceDao.delete(param);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
