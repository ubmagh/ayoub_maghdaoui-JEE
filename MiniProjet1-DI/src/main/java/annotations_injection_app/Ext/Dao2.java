package annotations_injection_app.Ext;

import Injector.AnnotationUtils.UComponent;

@UComponent("dao2")
public class Dao2{

    public double getData() {
        return Math.E;
    }
}
