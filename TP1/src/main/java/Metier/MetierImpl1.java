package Metier;

import Dao.IDao;

public class MetierImpl1 implements IMetier {

    IDao dao;

    @Override
    public double calculate() {
        return dao.getData() + Math.random(); // :D
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
