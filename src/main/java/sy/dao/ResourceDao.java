package sy.dao;

import sy.pageModel.SessionInfo;
import sy.pageModel.Tree;

import java.util.List;

public interface ResourceDao extends  IDaoService{

    public List<Tree> allTree(SessionInfo sessionInfo);

    public List<Tree> tree(SessionInfo sessionInfo);
}
