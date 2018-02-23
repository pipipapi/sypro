
package sy.dao.impl;

import com.dap.dao.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sy.dao.IDaoService;
import sy.model.bean.TresourceBean;
import sy.model.po.TresourcePo;
import sy.model.po.TrolePo;
import sy.model.po.TuserPo;
import sy.pageModel.Resource;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

import java.util.*;

@Service
public class ResourceDaoImpl  extends BaseDaoServiceImpl implements IDaoService {


    public List<Tree> allTree(SessionInfo sessionInfo) {
        List<TresourcePo> l = null;
        List<Tree> lt = new ArrayList<Tree>();

        Map<String, Object> params = new HashMap<String, Object>();
        if (sessionInfo != null) {
            params.put("userId", sessionInfo.getId());// 查自己有权限的资源
            l = this.selectList("selectMyResource", params);
        } else {
            TresourceBean bean=new TresourceBean();
            bean.addOrderBy(Order.desc("seq"));
            l = this.queryListByBean(TresourcePo.class, bean);
        }

        if (l != null && l.size() > 0) {
            for (TresourcePo r : l) {
                Tree tree = new Tree();
                BeanUtils.copyProperties(r, tree);
                if (r.getParent() != null) {
                    tree.setPid(r.getParent().getId());
                }
                tree.setText(r.getName());
                tree.setIconCls(r.getIcon());
                Map<String, Object> attr = new HashMap<String, Object>();
                attr.put("url", r.getUrl());
                tree.setAttributes(attr);
                lt.add(tree);
            }
        }
        return lt;
    }


    public List<Tree> tree(SessionInfo sessionInfo) {
        List<TresourcePo> l = null;
        List<Tree> lt = new ArrayList<Tree>();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("resourceTypeId", "0");// 菜单类型的资源

        if (sessionInfo != null) {
            params.put("userId", sessionInfo.getId());// 查自己有权限的资源
            l = this.selectList("selectMyResource", params);
        } else {
            TresourceBean bean=new TresourceBean();
            bean.addOrderBy(Order.desc("seq"));
            l = this.queryListByBean(TresourcePo.class, bean);
        }

        if (l != null && l.size() > 0) {
            for (TresourcePo r : l) {
                Tree tree = new Tree();
                BeanUtils.copyProperties(r, tree);
                if (r.getParent() != null) {
                    tree.setPid(r.getParent().getId());
                }
                tree.setText(r.getName());
                tree.setIconCls(r.getIcon());
                Map<String, Object> attr = new HashMap<String, Object>();
                attr.put("url", r.getUrl());
                tree.setAttributes(attr);
                lt.add(tree);
            }
        }
        return lt;
    }



    public void add(Resource resource, SessionInfo sessionInfo) {
        TresourcePo t = new TresourcePo();
        BeanUtils.copyProperties(resource, t);
        if (resource.getPid() != null && !resource.getPid().equalsIgnoreCase("")) {
            t.setParent(this.selectOne(t));
        }
        if (resource.getIconCls() != null && !resource.getIconCls().equalsIgnoreCase("")) {
            t.setIcon(resource.getIconCls());
        }
        this.insert(t);

        // 由于当前用户所属的角色，没有访问新添加的资源权限，所以在新添加资源的时候，将当前资源授权给当前用户的所有角色，以便添加资源后在资源列表中能够找到
//        TuserPo param = new TuserPo();
//        param.setId(sessionInfo.getId());
//        TuserPo user = this.selectOne(param);
//        Set<TrolePo> roles = user.getTroles();
//        for (TrolePo r : roles) {
//            r.getTresources().add(t);
//        }
    }



    public void edit(Resource resource) throws Exception {

        if(ObjectUtils.isEmpty(resource.getId())){
            throw new Exception("资源ID不可为空");
        }
        TresourcePo param=new TresourcePo();
        param.setId(resource.getId());
        TresourcePo t = this.selectOne(param);
        if (t != null) {
            BeanUtils.copyProperties(resource, t);
            if (resource.getIconCls() != null && !resource.getIconCls().equalsIgnoreCase("")) {
                t.setIcon(resource.getIconCls());
            }
            if (resource.getPid() != null && !resource.getPid().equalsIgnoreCase("")) {// 说明前台选中了上级资源
                param.setId(resource.getPid());
                TresourcePo pt = this.selectOne(param);
                isChildren(t, pt);// 说明要将当前资源修改到当前资源的子/孙子资源下
                t.setParent(pt);
            } else {
                t.setParent(null);// 前台没有选中上级资源，所以就置空
            }
        }
    }



    public Resource get(String id) {
        TresourcePo param=new TresourcePo();
        param.setId(id);
        TresourcePo t = this.selectOne(param);

        Resource r = new Resource();
        BeanUtils.copyProperties(t, r);
        if (t.getParent() != null) {
            r.setPid(t.getParent().getId());
            r.setPname(t.getParent().getName());
        }
//        r.setTypeId(t.getTresourcetype().getId());
//        r.setTypeName(t.getTresourcetype().getName());
        if (t.getIcon() != null && !t.getIcon().equalsIgnoreCase("")) {
            r.setIconCls(t.getIcon());
        }
        return r;
    }



    public List<Resource> treeGrid(SessionInfo sessionInfo) {
        List<TresourcePo> l = null;
        List<Resource> lr = new ArrayList<Resource>();

        Map<String, Object> params = new HashMap<String, Object>();
        if (sessionInfo != null) {
            params.put("userId", sessionInfo.getId());// 查自己有权限的资源
            l = this.selectList("selectMyResource", params);
        } else {
            TresourceBean bean=new TresourceBean();
            bean.addOrderBy(Order.desc("seq"));
            l = this.queryListByBean(TresourcePo.class, bean);
        }

        if (l != null && l.size() > 0) {
            for (TresourcePo t : l) {
                Resource r = new Resource();
                BeanUtils.copyProperties(t, r);
                if (t.getParent() != null) {
                    r.setPid(t.getParent().getId());
                    r.setPname(t.getParent().getName());
                }
//                r.setTypeId(t.getTresourcetype().getId());
//                r.setTypeName(t.getTresourcetype().getName());
                if (t.getIcon() != null && !t.getIcon().equalsIgnoreCase("")) {
                    r.setIconCls(t.getIcon());
                }
                lr.add(r);
            }
        }

        return lr;
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
    private boolean isChildren(TresourcePo t, TresourcePo pt) {
        if (pt != null && pt.getParent() != null) {
            if (pt.getParent().getId().equalsIgnoreCase(t.getId())) {
                pt.setParent(null);
                return true;
            } else {
                return isChildren(t, pt.getParent());
            }
        }
        return false;
    }


}
