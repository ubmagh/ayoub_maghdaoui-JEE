package UInjectorMain;

import UInjectorMain.XmlUtils.UBean;
import UInjectorMain.XmlUtils.UBeans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class XMLInjector {

    private JAXBContext context;
    private UBeans beans;

    public XMLInjector( String filename) throws JAXBException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File xmlFile = new File(filename);
        context = JAXBContext.newInstance(UBeans.class);
        Unmarshaller unmarshaller = context.createUnmarshaller(); ;
        beans = (UBeans) unmarshaller.unmarshal(xmlFile);
        beans.initBeans();
    }

    public List<UBean> getAllUBeans(){
        return beans.getBeansList();
    }

    public Object getBean( String key){
        return beans.getUBean(key).getObject();
    }


}
