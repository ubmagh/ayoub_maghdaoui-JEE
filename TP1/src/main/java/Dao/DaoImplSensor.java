package Dao;

/*
    first implementation of IDao, supposing it gets data from some kind of sensors :/
*/
public class DaoImplSensor implements IDao{

    @Override
    public double getData() {
        return Math.random() + Math.PI + Math.E;
    }
}
