package cn.yuan.sqlsession;

import cn.yuan.entity.IFunction;
import cn.yuan.entity.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuan
 */
public class MyMapperProxy implements InvocationHandler {

    /**
     * sql执行器
     */
    private SqlSession sqlSession;

    /**
     * 配置解析器
     */
    private Configuration configuration;

    public MyMapperProxy(SqlSession sqlSession, Configuration configuration) {
        this.sqlSession = sqlSession;
        this.configuration = configuration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = configuration.readMapper("");
        String funcName = method.getName();
        IFunction function = mapperBean.getFunctions(funcName);
        return sqlSession.selectOne(function.getSql(),args);

    }
}
