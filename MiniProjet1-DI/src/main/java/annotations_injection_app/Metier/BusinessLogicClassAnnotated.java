package annotations_injection_app.Metier;

import Injector.AnnotationUtils.Component;
import annotations_injection_app.Dao.IDao;
import annotations_injection_app.Ext.Dao2;

@Component("metier")
public class BusinessLogicClassAnnotated implements IBusinessLogic {

    private IDao dao;

    private Dao2 dao2;

    public BusinessLogicClassAnnotated(Dao2 dao2, IDao dao) {
        this.dao = dao;
        this.dao2 = dao2;
    }

    @Override
    public double calculate() {
        return dao.getData()/Math.PI;
    }


    @Override
    public String toString() {
        return " [ string returned from object :  'Hi there !' ]";
    }
}
