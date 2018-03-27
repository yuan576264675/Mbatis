package cn.yuan.entity;

import java.util.Map;

public class MapperBean {
    /**
     * 接口名
     */
    private String interfaceName;

    /**
     * 方法集合
     * key为方法名，value值为方法体
     */
    private Map<String,IFunction> functions;

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void setFunctions(Map<String, IFunction> functions) {
        this.functions = functions;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public Map<String, IFunction> getFunctions() {
        return functions;
    }

    public IFunction getFunctions(String functionName){
        return functions.get(functionName);
    }
}
