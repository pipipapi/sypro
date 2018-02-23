
package sy.dao.impl;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sy.dao.IDaoService;
import sy.model.po.TresourcePo;
import sy.model.po.TresourcetypePo;
import sy.pageModel.ResourceType;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceTypeDaoImpl  extends BaseDaoServiceImpl implements IDaoService {


	@Autowired
	private ResourceTypeDaoImpl resourceTypeDao;

	public TresourcePo getById(String id) {

	    return null;

	}


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

