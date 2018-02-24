package sy.dao;

import sy.pageModel.ResourceType;

import java.util.List;

public interface ResourceTypeDao extends  IDaoService{

    public List<ResourceType> getResourceTypeList();

}
