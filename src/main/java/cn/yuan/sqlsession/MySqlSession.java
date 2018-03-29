package cn.yuan.sqlsession;

import cn.yuan.executor.BaseExecutor;
import cn.yuan.executor.Executor;

import java.lang.reflect.Proxy;

/**
 * SqlSession的实现
 *  @author yuan
 */
public class MySqlSession implements SqlSession {

    /**
     * 执行单元
     */
    private Executor executor;

    /**
     * 配置解析器
     */
    private  Configuration configuration;

    /**
     * 默认的实现
     */
    public MySqlSession() {
        executor = new BaseExecutor();
        configuration = new Configuration();
    }

    /**
     * 自定义的实现
     * @param executor
     * @param configuration
     */
    public MySqlSession(Executor executor, Configuration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MyMapperProxy(this,configuration));
    }

    @Override
    public <T> T selectOne(String statement, Object param) {
        return executor.query(statement,param);
    }

}
