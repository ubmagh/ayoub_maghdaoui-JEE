package xml_injection_app.Metier;

import xml_injection_app.Dao.IDao;

public class BusinessLogicClassPI implements IBusinessLogic {

    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
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
