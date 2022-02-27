package Dao;

/*
    first implementation of IDao, supposing it gets data from a DataBase :/
*/
public class IDaoImplDB implements IDao{

    @Override
    public double getData() {
        return Math.random() * Math.PI * Math.E;
    }
}
