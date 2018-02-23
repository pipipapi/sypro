
package sy.dao.impl;

import com.dap.dao.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sy.dao.IDaoService;
import sy.model.bean.TroleBean;
import sy.model.po.TrolePo;
import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleDaoImpl extends BaseDaoServiceImpl implements IDaoService {



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

}

