package cn.yuan.executor;

/**
 * 默认实现 Executor
 *
 * @author yuan
 */
public class BaseExecutor implements Executor {
    @Override
    public <T> T query(String statement, Object param) {
        return null;
    }
}
