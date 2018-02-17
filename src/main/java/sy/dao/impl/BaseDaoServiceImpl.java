package sy.dao.impl;

import com.dap.dao.BasePo;
import com.dap.dao.mybatis.DaoSupportImpl;
import org.springframework.stereotype.Service;
import sy.dao.IDaoService;
import sy.model.Tresource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseDaoServiceImpl extends DaoSupportImpl implements IDaoService{

    @Override
    public void saveOrUpdate(List<BasePo> basePoList) {
        // 扩展的方法

        //getSqlSession().update(statementPostfix, parameter);
    }

}
