package sy.dao.impl;

import com.dap.dao.BasePo;
import com.dap.dao.mybatis.DaoSupportImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.IDaoService;

import java.util.List;

@Service
public class BaseDaoServiceImpl extends DaoSupportImpl implements IDaoService{


    /**
     * 需要注入一个sqlSessionFactory来帮助初始化DataSource
     * @param sqlSessionFactory
     */
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void saveOrUpdate(List<BasePo> basePoList) {
        // 扩展的方法

        //getSqlSession().update(statementPostfix, parameter);
    }

}
