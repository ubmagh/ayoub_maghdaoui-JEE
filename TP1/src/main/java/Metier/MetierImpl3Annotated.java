package Metier;

import Dao.IDao;
import org.springframework.stereotype.Component;

@Component("metierAnotatedConstructorInjection")
public class MetierImpl3Annotated implements IMetier {

    IDao dao;

    public MetierImpl3Annotated(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        return dao.getData() * Math.random(); // 2nd :D
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
