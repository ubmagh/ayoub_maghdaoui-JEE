package TestApp.Metier;

import TestApp.Dao.IDao;

public class BusinessLogicClassCI implements IBusinessLogic {

    private IDao dao;

    public BusinessLogicClassCI(IDao dao) {
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
