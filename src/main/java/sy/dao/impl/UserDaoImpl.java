
package sy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sy.dao.IDaoService;
import sy.model.po.TresourcePo;
import sy.model.po.TrolePo;
import sy.model.po.TuserPo;

import java.util.*;

@Service
public class UserDaoImpl extends BaseDaoServiceImpl implements IDaoService {


    @Autowired
    private UserDaoImpl userDaoImpl;

    public List<String> resourceList(String id) throws Exception{
        if(ObjectUtils.isEmpty(id)){
            throw new Exception("用户ID不可为空");
        }
        List<String> resourceList = new ArrayList<String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        TuserPo t = userDaoImpl.selectOne(TuserPo.class,"selectOneBringRole", params);
        if (t != null) {
            Set<TrolePo> roles = t.getTroles();
            if (roles != null && !roles.isEmpty()) {
                for (TrolePo role : roles) {
                    Set<TresourcePo> resources = role.getTresources();
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

}

