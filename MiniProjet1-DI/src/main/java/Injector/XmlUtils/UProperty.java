package Injector.XmlUtils;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement( name = "uproperty")
@XmlAccessorType(XmlAccessType.FIELD)
public class UProperty implements Serializable {

    @XmlAttribute(name = "name", required = true)
    private String name;

    @XmlIDREF
    @XmlAttribute(name = "ref", required = true)
    private UBean ref;


    public String getName() {
        return name;
    }

    public UBean getRef() {
        return ref;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRef(UBean ref) {
        this.ref = ref;
    }
}
