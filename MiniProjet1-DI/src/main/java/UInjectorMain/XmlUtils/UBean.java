package UInjectorMain.XmlUtils;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement( name = "ubean")
@XmlAccessorType(XmlAccessType.FIELD)
public class UBean implements Serializable {

    @XmlElement(name = "uproperty", required = false)
    private List<UProperty> properties = new ArrayList<UProperty>();

    @XmlElement(name = "uconstructor-arg", required = false)
    private List<UConstructorArg> constructorArgs = new ArrayList<UConstructorArg>();

    @XmlAttribute(name = "class", required = true)
    private String className;

    @XmlID
    @XmlAttribute(name = "id", required = true)
    private String key;

    private Object object;


    public void init( UBeans ubeans) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class classs = Class.forName(className);
        if( constructorArgs.size()>0 ){
            List<Class> argsTypes = new ArrayList<>();
            Object[] args = new Object[constructorArgs.size()];
            for ( int i=0; i<constructorArgs.size(); i++ ) {
                argsTypes.add( Arrays.stream(( (UBean) constructorArgs.get(i).getRef()).getObject().getClass().getInterfaces()).findFirst().orElseGet(null) );
                args[i] = ( (UBean) constructorArgs.get(i).getRef()).getObject();
            }
            Constructor<?> ct = classs.getConstructor( argsTypes.toArray( new Class[argsTypes.size()] ) );
            this.object= ct.newInstance( args );
        }
        else
            this.object = classs.newInstance();
        if( properties.size()>0){
            for ( UProperty uproperty: properties) {
                Method setter = classs.getMethod( "set"+ StringUtils.capitalize(uproperty.getName()), ( (UBean)uproperty.getRef() ).getObject().getClass().getInterfaces() );
                setter.invoke( this.object,  ( (UBean)uproperty.getRef() ).getObject() );
            }
        }

    }

    public String getClassName() {
        return className;
    }

    public String getKey() {
        return key;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "UBean{" +
                "className= '" + className + '\'' +
                ", object= " + object +
                '}';
    }
}
