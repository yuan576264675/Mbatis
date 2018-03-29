package cn.yuan.executor;

/**
 * 执行器接口
 *
 * @author yuan
 */
public interface Executor {
    public <T> T query(String statement, Object param);
}
