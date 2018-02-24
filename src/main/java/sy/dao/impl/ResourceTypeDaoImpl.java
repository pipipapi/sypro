
package sy.dao.impl;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sy.dao.IDaoService;
import sy.dao.ResourceTypeDao;
import sy.model.po.TresourcePo;
import sy.model.po.TresourcetypePo;
import sy.pageModel.ResourceType;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceTypeDaoImpl  extends BaseDaoServiceImpl implements ResourceTypeDao {

	public TresourcePo getById(String id) {

	    return null;

	}

	@Override
	@Cacheable(value = "resourceTypeServiceCache", key = "'resourceTypeList'")
	public List<ResourceType> getResourceTypeList() {
		List<TresourcetypePo> l = this.queryListByBean(TresourcePo.class, (Object)null );
		List<ResourceType> rl = new ArrayList<ResourceType>();
		if (l != null && l.size() > 0) {
			for (TresourcetypePo t : l) {
				ResourceType rt = new ResourceType();
				BeanUtils.copyProperties(t, rt);
				rl.add(rt);
			}
		}
		return rl;
	}



}

