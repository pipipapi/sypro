package sy.dao;

import com.dap.dao.BasePo;
import com.dap.dao.DaoSupport;

import java.util.List;

public interface IDaoService extends DaoSupport {
    public void saveOrUpdate(List<BasePo> basePoList);
}
