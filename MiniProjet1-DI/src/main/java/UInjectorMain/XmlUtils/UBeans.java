package UInjectorMain.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement( name = "ubeans")
@XmlAccessorType(XmlAccessType.FIELD)
public class UBeans implements Serializable {


    // @XmlJavaTypeAdapter(UBeanAdapter.class)
    @XmlElement(name = "ubean")
    private List<UBean> beansList = new ArrayList<UBean>();


    public void addUbean( UBean uBean){
        beansList.add( uBean);
    }

    public UBean getUBean( String key){
        for ( UBean ubean: beansList) {
            if( ubean.getKey().equals(key) )
                return ubean;
        }
        return null ;
    }

    public void initBeans() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        for ( UBean bean : beansList ) {
            bean.init(this);
        }
    }

    public List<UBean> getBeansList() {
        return beansList;
    }

    public void setBeansList(List<UBean> beansList) {
        this.beansList = beansList;
    }
}
