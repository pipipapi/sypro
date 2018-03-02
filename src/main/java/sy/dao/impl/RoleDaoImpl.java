
package sy.dao.impl;

import com.dap.dao.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sy.dao.IDaoService;
import sy.dao.RoleDao;
import sy.model.bean.TresourceBean;
import sy.model.bean.TroleBean;
import sy.model.po.TresourcePo;
import sy.model.po.TrolePo;
import sy.model.po.TuserPo;
import sy.pageModel.Role;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialException;
import java.util.*;

@Service
public class RoleDaoImpl extends BaseDaoServiceImpl implements IDaoService {

    @Resource(name ="userDaoImpl")
    private UserDaoImpl userDaoImpl;


    public List<Tree> tree(SessionInfo sessionInfo) {
        List<TrolePo> l = null;
        List<Tree> lt = new ArrayList<Tree>();

        Map<String, Object> params = new HashMap<String, Object>();
        if (sessionInfo != null) {
            params.put("userId", sessionInfo.getId());// 查自己有权限的角色
            l = this.selectList("selectMyRoles",params);
        } else {
            TroleBean troleBean = new TroleBean();
            troleBean.addOrderBy(Order.desc("seq"));
            l = this.queryListByBean(TrolePo.class,troleBean);
        }

        if (l != null && l.size() > 0) {
            for (TrolePo t : l) {
                Tree tree = new Tree();
                BeanUtils.copyProperties(t, tree);
                tree.setText(t.getName());
                tree.setIconCls("status_online");
                if (t.getRole() != null) {
                    tree.setPid(t.getRole().getId());
                }
                lt.add(tree);
            }
        }
        return lt;
    }



    public void add(Role role, SessionInfo sessionInfo) {
        TrolePo t = new TrolePo();
        BeanUtils.copyProperties(role, t);
        /*if (role.getPid() != null && !role.getPid().equalsIgnoreCase("")) {
            t.setTrole(roleDao.get(Trole.class, role.getPid()));
        }*/
        this.insert(t);

        // 刚刚添加的角色，赋予给当前的用户
/*
        TuserPo param=new TuserPo();
        param.setId(sessionInfo.getId());
        TuserPo user = this.selectOne(param);
        user.getTroles().add(t);
*/
    }

    public TrolePo get(String id) {
        //Role r = new Role();
        TrolePo param=new TrolePo();
        param.setId( id);
        List<TrolePo> t = this.selectList(param);
        if(t!=null && !t.isEmpty()){
            return t.get(0);
        }
        return null;
        /*if (t != null) {
            BeanUtils.copyProperties(t, r);
            if (t.getTrole() != null) {
                r.setPid(t.getTrole().getId());
                r.setPname(t.getTrole().getName());
            }
            Set<Tresource> s = t.getTresources();
            if (s != null && !s.isEmpty()) {
                boolean b = false;
                String ids = "";
                String names = "";
                for (Tresource tr : s) {
                    if (b) {
                        ids += ",";
                        names += ",";
                    } else {
                        b = true;
                    }
                    ids += tr.getId();
                    names += tr.getName();
                }
                r.setResourceIds(ids);
                r.setResourceNames(names);
            }
        }
        return r;
        */
    }

    public void edit(Role role) {
        TrolePo t = this.get(role.getId());
        if (t != null) {
            BeanUtils.copyProperties(role, t);
            /*if (role.getPid() != null && !role.getPid().equalsIgnoreCase("")) {
                t.setTrole(roleDao.get(Trole.class, role.getPid()));
            }
            if (role.getPid() != null && !role.getPid().equalsIgnoreCase("")) {// 说明前台选中了上级资源
                Trole pt = roleDao.get(Trole.class, role.getPid());
                isChildren(t, pt);// 说明要将当前资源修改到当前资源的子/孙子资源下
                t.setTrole(pt);
            } else {
                t.setTrole(null);// 前台没有选中上级资源，所以就置空
            }*/
            this.update(t);
        }
    }

    /**
     * 判断是否是将当前节点修改到当前节点的子节点
     *
     * @param t
     *            当前节点
     * @param pt
     *            要修改到的节点
     * @return
     */
    private boolean isChildren(TrolePo t, TrolePo pt) {
        if (pt != null && pt.getRole() != null) {
            if (pt.getRole().getId().equalsIgnoreCase(t.getId())) {
                pt.setRole(null);
                return true;
            } else {
                return isChildren(t, pt.getRole());
            }
        }
        return false;
    }





    public List<Role> treeGrid(SessionInfo sessionInfo) {
        List<Role> rl = new ArrayList<Role>();
        List<TrolePo> tl = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", sessionInfo.getId());// 查自己有权限的角色
        TuserPo currentUser = userDaoImpl.selectOne(TuserPo.class,"selectOneBringRole",params);
        if (sessionInfo != null) {
            tl = new ArrayList<>(currentUser.getRoles());
        } else {
            tl = this.selectList(new TrolePo());
        }
        if (tl != null && tl.size() > 0) {
            for (TrolePo t : tl) {
                Role r = new Role();
                BeanUtils.copyProperties(t, r);
                r.setIconCls("status_online");
                if (t.getRole() != null) {
                    r.setPid(t.getRole().getId());
                    r.setPname(t.getRole().getName());
                }
                Set<TresourcePo> s = t.getResources();
                if (s != null && !s.isEmpty()) {
                    boolean b = false;
                    String ids = "";
                    String names = "";
                    for (TresourcePo tr : s) {
                        if (b) {
                            ids += ",";
                            names += ",";
                        } else {
                            b = true;
                        }
                        ids += tr.getId();
                        names += tr.getName();
                    }
                    r.setResourceIds(ids);
                    r.setResourceNames(names);
                }
                rl.add(r);
            }
        }
        return rl;
    }




    public void delete(String id) {
        TrolePo param=new TrolePo();
        param.setId(id);
        TrolePo t = this.selectOne(param);
        del(t);
    }





    private void del(TrolePo t) {
        if (t.getRoles() != null && t.getRoles().size() > 0) {
            for (TrolePo r : t.getRoles()) {
                del(r);
            }
        }
        this.delete(t);
    }




    public List<Tree> allTree() {
        return this.tree(null);
    }





    public TrolePo grant(Role role) {
        TrolePo param=new TrolePo();
        param.setId(role.getId());
        TrolePo t = this.selectOne(param);
        if (role.getResourceIds() != null && !role.getResourceIds().equalsIgnoreCase("")) {
            TresourceBean bean=new TresourceBean();
            bean.setDistinct(true);
            TresourceBean.Criteria criteria=bean.createCriteria();
            criteria.andIdIn(Arrays.asList(role.getResourceIds().split(",")));
            t.setResources(new HashSet<TresourcePo>(this.queryListByBean(TresourcePo.class,bean)));
        } else {
            t.setResources(null);
        }
        return t;
    }
}

