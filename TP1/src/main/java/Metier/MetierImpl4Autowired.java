package Metier;

import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metierAutowiredInjection")
public class MetierImpl4Autowired implements IMetier {

    @Autowired
    IDao dao;

    @Override
    public double calculate() {
        return dao.getData() * Math.random(); // 2nd :D
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
