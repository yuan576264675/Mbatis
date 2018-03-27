package cn.yuan.sqlsession;

import cn.yuan.entity.IFunction;
import cn.yuan.entity.MapperBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取与解析配置信息，并返回处理后的
 */
public class Configuration {

    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    /**
     * 读取xml文件
     *
     * @param resource
     * @return
     */
    public Connection build(String resource) {
        try {
            InputStream stream = loader.getResourceAsStream(resource);
            //创建解析器
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            return evalDataSource(root);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error occured while evaling xml " + resource);
        }
    }

    private Connection evalDataSource(Element node) {

        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;

        for (Object item : node.elements("property")) {
            Element element = (Element) item;
            String value = element.hasContent() ? element.getText() : element.attributeValue("value");
            String name = element.attributeValue("name");

            switch (name) {
                case "url":
                    url = value;
                    break;
                case "username":
                    username = value;
                    break;
                case "password":
                    password = value;
                    break;
                case "driverClassName":
                    driverClassName = value;
                    break;
                default:
                    throw new RuntimeException("[database]:property unknowm name");
            }
        }

        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 用于解析mapperxml文件
     * @return
     */
    public MapperBean readMapper(String path) {
        try {
            MapperBean mapper = new MapperBean();
            InputStream stream = loader.getResourceAsStream(path);
            //创建解析器
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();

            mapper.setInterfaceName(root.attributeValue("nameSpace"));

            Map<String,IFunction> functionMap = new HashMap<>();

            return mapper;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
