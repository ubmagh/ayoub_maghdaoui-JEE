package annotations_injection_app.Dao;

import Injector.AnnotationUtils.Component;

@Component("dao")
public class DaoClassAnnotated implements IDao {

    public double getData(){
        return Math.random()*Math.E;
    }

}
