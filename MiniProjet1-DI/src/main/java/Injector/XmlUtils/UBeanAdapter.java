package Injector.XmlUtils;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// i used this, when i tried to store UBean objects as a HashMap inside of UBeans master object
public class UBeanAdapter extends XmlAdapter<UBeanAdapter.UBeanWrapper, Map<String, UBean>>{

    public static class UBeanWrapper
    {
        @XmlElement(name = "ubean")
        List<UBean> ubeans = new ArrayList<>();
    }

    @Override
    public Map<String, UBean> unmarshal(UBeanWrapper v) {
        Map<String, UBean> map = new HashMap< String, UBean>();
        for ( UBean ubean: v.ubeans) {
            map.put( ubean.getKey(), ubean);
        }
        return map;
    }

    @Override
    public UBeanWrapper marshal(Map<String, UBean> v) {
        // i won't need it
        return null;
    }


}
