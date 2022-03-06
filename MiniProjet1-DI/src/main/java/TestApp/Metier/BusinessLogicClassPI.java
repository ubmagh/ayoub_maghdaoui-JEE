package TestApp.Metier;

import TestApp.Dao.IDao;

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
