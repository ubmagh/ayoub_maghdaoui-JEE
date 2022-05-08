package xml_injection_app.Dao;

public class DaoClassPI implements IDao {

    public double getData(){
        return Math.random()*Math.E;
    }

}
