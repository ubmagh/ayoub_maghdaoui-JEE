package Metier;

import Dao.IDao;

public class MetierImpl2 implements IMetier {

    IDao dao;

    @Override
    public double calculate() {
        return dao.getData() * Math.random(); // 2nd :D
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
