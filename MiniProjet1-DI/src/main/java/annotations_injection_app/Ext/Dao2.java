package annotations_injection_app.Ext;

import Injector.AnnotationUtils.Component;

@Component("dao2")
public class Dao2{

    public double getData() {
        return Math.E;
    }
}
