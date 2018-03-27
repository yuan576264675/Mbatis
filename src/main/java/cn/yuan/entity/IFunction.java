package cn.yuan.entity;

/**
 * mapper中的方法对象
 * @author yuan
 */
public class IFunction {
    private String sqltype;
    private String funcName;
    private String sql;
    private Object resultType;
    private String parameterType;

    public String getSqltype() {
        return sqltype;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getSql() {
        return sql;
    }

    public Object getResultType() {
        return resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setSqltype(String sqltype) {
        this.sqltype = sqltype;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setResultType(Object resultType) {
        this.resultType = resultType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "IFunction{" +
                "sqltype='" + sqltype + '\'' +
                ", funcName='" + funcName + '\'' +
                ", sql='" + sql + '\'' +
                ", resultType=" + resultType +
                ", parameterType='" + parameterType + '\'' +
                '}';
    }
}
