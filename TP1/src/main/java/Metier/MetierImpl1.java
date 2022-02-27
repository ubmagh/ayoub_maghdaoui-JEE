package Metier;

import Dao.IDao;

public class MetierImpl1 implements IMetier {

    IDao dao;

    @Override
    public double calculate() {
        return dao.getData() + Math.random(); // :D
    }
}
