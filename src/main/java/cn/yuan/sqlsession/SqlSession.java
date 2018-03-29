package cn.yuan.sqlsession;

/**
 * 发出数据库的增删改查操作
 *
 * @author yuan
 */
public interface SqlSession {

    /**
     *  通过动态代理获得dao接口的实现类
     * @param clazz 接口类型
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> clazz);

    /**
     * 执行select查询语句
     * @param statement
     * @param param
     * @param <T>
     * @return 结果集
     */
    <T> T selectOne(String statement,Object param);



}
