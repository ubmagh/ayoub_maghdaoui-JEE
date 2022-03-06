package Metier;

import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metierAutowiredInjection")
public class MetierImpl4Autowired implements IMetier {


    // Directly in the property (uncomment following line)
    // @Autowired
    IDao dao;

    // or throught setter
    @Autowired
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        return dao.getData() * Math.random(); // 2nd :D
    }

}
