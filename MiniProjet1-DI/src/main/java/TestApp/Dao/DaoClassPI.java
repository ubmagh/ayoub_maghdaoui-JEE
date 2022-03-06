package TestApp.Dao;

public class DaoClassPI implements IDao {

    public double getData(){
        return Math.random()*Math.E;
    }

}
