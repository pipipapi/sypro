
package sy.dao.impl;

import com.dap.dao.model.Order;
import com.dap.utils.DeepFieldCopy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sy.dao.IDaoService;
import sy.model.bean.TuserBean;
import sy.model.po.TresourcePo;
import sy.model.po.TrolePo;
import sy.model.po.TuserPo;
import sy.pageModel.DataGrid;
import sy.pageModel.PageHelper;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.util.MD5Util;

import javax.security.auth.login.CredentialException;
import java.util.*;

@Service
public class UserDaoImpl extends BaseDaoServiceImpl implements IDaoService {


    @Autowired
    private RoleDaoImpl roleDaoImpl;

    public List<String> resourceList(String id) throws Exception{
        if(ObjectUtils.isEmpty(id)){
            throw new Exception("用户ID不可为空");
        }
        List<String> resourceList = new ArrayList<String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        TuserPo t = this.selectOne(TuserPo.class,"selectOneBringRole", params);
        if (t != null) {
            Set<TrolePo> roles = t.getRoles();
            if (roles != null && !roles.isEmpty()) {
                for (TrolePo role : roles) {
                    Set<TresourcePo> resources = role.getResources();
                    if (resources != null && !resources.isEmpty()) {
                        for (TresourcePo resource : resources) {
                            if (resource != null && resource.getUrl() != null) {
                                resourceList.add(resource.getUrl());
                            }
                        }
                    }
                }
            }
        }
        return resourceList;
    }


    /**
     * 注册用户
     * @param user
     * @throws Exception
     */
    synchronized public void reg(User user) throws Exception {

        TuserPo param=new TuserPo();
        param.setName(user.getName());
        if (this.count(param) > 0) {
            throw new Exception("登录名已存在！");
        } else {
            TuserPo u = new TuserPo();
            u.setId(UUID.randomUUID().toString());
            u.setName(user.getName());
            u.setPwd(MD5Util.md5(user.getPwd()));
            u.setCreatedatetime(new Date());
            this.insert(u);
        }
    }


    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    synchronized public void add(User user) throws Exception {
        TuserPo param=new TuserPo();
        param.setName(user.getName());
        if (this.count(param) > 0) {
            throw new Exception("登录名已存在！");
        } else {
            TuserPo u = new TuserPo();
            BeanUtils.copyProperties(user, u);
            u.setCreatedatetime(new Date());
            u.setPwd(MD5Util.md5(user.getPwd()));
            this.insert(u);
        }
    }


    protected TuserBean diyOptions(User user, PageHelper ph){
        TuserBean bean=new TuserBean();
        if (user != null) {
            TuserBean.Criteria criteria = bean.createCriteria();
            //查询条件
            if (user.getName() != null) {
                criteria.andNameLike(user.getName());
            }
            if (user.getCreatedatetimeStart() != null) {
                criteria.andCreatedatetimeGreaterThanOrEqualTo(user.getCreatedatetimeStart());
            }
            if (user.getCreatedatetimeEnd() != null) {
                criteria.andCreatedatetimeLessThanOrEqualTo(user.getCreatedatetimeEnd());
            }
            if (user.getModifydatetimeStart() != null) {
                criteria.andModifydatetimeGreaterThan(user.getModifydatetimeStart());
            }
            if (user.getModifydatetimeEnd() != null) {
                criteria.andModifydatetimeLessThan(user.getModifydatetimeEnd());
            }
            //分页条件
            if (ph.getSort() != null && ph.getOrder() != null) {
                if(Order.OrderType.ASC.toString().equalsIgnoreCase(ph.getOrder())){
                    bean.addOrderBy(Order.asc(ph.getSort()));
                }else {
                    bean.addOrderBy(Order.desc(ph.getSort()));
                }
            }
        }
        return  bean;
    }


    public DataGrid dataGrid(User user, PageHelper ph) {
        DataGrid dg = new DataGrid();
        List<User> ul = new ArrayList<User>();

        TuserBean bean=this.diyOptions(user,ph);

        List<TuserPo> userlist = this.queryListByBean(TuserPo.class,bean);
        if (userlist != null && userlist.size() > 0) {
            for (TuserPo t : userlist) {
                User u = new User();
                BeanUtils.copyProperties(t, u);
                Set<TrolePo> roles = t.getRoles();
                if (roles != null && !roles.isEmpty()) {
                    String roleIds = "";
                    String roleNames = "";
                    boolean b = false;
                    for (TrolePo tr : roles) {
                        if (b) {
                            roleIds += ",";
                            roleNames += ",";
                        } else {
                            b = true;
                        }
                        roleIds += tr.getId();
                        roleNames += tr.getName();
                    }
                    u.setRoleIds(roleIds);
                    u.setRoleNames(roleNames);
                }
                ul.add(u);
            }
        }
        dg.setRows(ul);
        dg.setTotal(this.countByBean(TuserPo.class,bean));
        return dg;
    }


    synchronized public void edit(User user) throws Exception {

        if(ObjectUtils.isEmpty(user.getId())){
            throw new Exception("用户Id null");
        }
        TuserPo editpo= DeepFieldCopy.transform(user, TuserPo.class);

        TuserBean bean=new TuserBean();
        TuserBean.Criteria criteria=bean.createCriteria();
        criteria.andNameEqualTo(user.getName());
        criteria.andIdNotEqualTo(user.getId());

        if (this.countByBean(TuserPo.class,bean) > 0) {
            throw new Exception("登录名已存在！");
        } else {
            TuserPo u = this.selectOne(editpo);
            /**
             * public static void copyProperties(Object source, Object target, String... ignoreProperties) throws BeansException {
                copyProperties(source, target,
                (Class)null,
                ignoreProperties);
             }
             */
            BeanUtils.copyProperties(user, u, new String[] { "pwd", "createdatetime" });
            u.setModifydatetime(new Date());
        }
    }



    public User get(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        TuserPo t = this.selectOne(TuserPo.class,"selectOneBringRole",params);
        User u = new User();
        BeanUtils.copyProperties(t, u);
        if (t.getRoles() != null && !t.getRoles().isEmpty()) {
            String roleIds = "";
            String roleNames = "";
            boolean b = false;
            for (TrolePo role : t.getRoles()) {
                if (b) {
                    roleIds += ",";
                    roleNames += ",";
                } else {
                    b = true;
                }
                roleIds += role.getId();
                roleNames += role.getName();
            }
            u.setRoleIds(roleIds);
            u.setRoleNames(roleNames);
        }
        return u;
    }



    public DataGrid loginCombogrid(String q, PageHelper ph) {
        if (q == null) {
            q = "";
        }
        DataGrid dg = new DataGrid();
        List<User> ul = new ArrayList<User>();

        TuserBean bean=new TuserBean();
        TuserBean.Criteria criteria=bean.createCriteria();
        criteria.andNameLike(q.trim());
        //分页条件
        if (ph.getSort() != null && ph.getOrder() != null) {
            if(Order.OrderType.ASC.toString().equalsIgnoreCase(ph.getOrder())){
                bean.addOrderBy(Order.asc(ph.getSort()));
            }else {
                bean.addOrderBy(Order.desc(ph.getSort()));
            }
            bean.setPageSize(ph.getRows());
            bean.setPageIndex(ph.getPage());
        }

        List<TuserPo> userlist = this.queryListByBean(TuserPo.class,bean);

        if (userlist != null && userlist.size() > 0) {
            for (TuserPo t : userlist) {
                User u = new User();
                u.setName(t.getName());
                u.setCreatedatetime(t.getCreatedatetime());
                u.setModifydatetime(t.getModifydatetime());
                ul.add(u);
            }
        }
        dg.setRows(ul);
        dg.setTotal(this.countByBean(TuserPo.class,bean));
        return dg;
    }



    public void grant(String ids, User user) {
        if (ids != null && ids.length() > 0) {
            List<TrolePo> roles = new ArrayList<TrolePo>();
            if (user.getRoleIds() != null) {
                TrolePo param=new TrolePo();
                for (String roleId : user.getRoleIds().split(",")) {
                    param.setId(roleId);
                    roles.add(roleDaoImpl.selectOne(param));
                }
            }
            for (String id : ids.split(",")) {
                if (id != null && !id.equalsIgnoreCase("")) {
                    TuserPo param=new TuserPo();
                    param.setId(id);
                    TuserPo t = this.selectOne(param);
                    t.setRoles(new HashSet<TrolePo>(roles));
                }
            }
        }
    }


    public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd) {
        TuserPo param=new TuserPo();
        param.setId(sessionInfo.getId());
        TuserPo u = this.selectOne(param);
        if (u.getPwd().equalsIgnoreCase(MD5Util.md5(oldPwd))) {// 说明原密码输入正确
            u.setPwd(MD5Util.md5(pwd));
            u.setModifydatetime(new Date());
            return true;
        }
        return false;
    }


    public void editPwd(User user) throws Exception{
        if (user != null && user.getPwd() != null && !user.getPwd().trim().equalsIgnoreCase("")) {
            TuserPo param=new TuserPo();
            param.setId(user.getId());
            param.setPwd(MD5Util.md5(user.getPwd()));
            param.setModifydatetime(new Date());
            this.update(param);
        }
        else{
            throw new Exception("参数异常");
        }
    }

    public List<User> loginCombobox(String q) {
        if (q == null) {
            q = "";
        }

        TuserBean bean=new TuserBean();
        TuserBean.Criteria criteria=bean.createCriteria();
        criteria.andNameLike(q.trim());
        bean.addOrderBy(Order.desc("name"));
        bean.setPageSize(10);
        bean.setPageIndex(1);

        List<TuserPo> userlist = this.queryListByBean(TuserPo.class,bean);

        List<User> ul = new ArrayList<User>();
        if (userlist != null && userlist.size() > 0) {
            for (TuserPo t : userlist) {
                User u = new User();
                u.setName(t.getName());
                ul.add(u);
            }
        }
        return ul;
    }

    public User login(User user) {
        TuserPo tuserPo=new TuserPo();
        tuserPo.setName(user.getName());
        tuserPo.setPwd(MD5Util.md5(user.getPwd()));
        TuserPo t = this.selectOne(tuserPo);
        if (t != null) {
            BeanUtils.copyProperties(t, user);
            return user;
        }
        return null;
    }

}

