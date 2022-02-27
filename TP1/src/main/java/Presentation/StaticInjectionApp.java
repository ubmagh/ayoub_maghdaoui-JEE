package Presentation;

import Dao.DaoImplDB;
import Metier.MetierImpl1;

public class StaticInjectionApp {

    public static void main(String[] args) {

        DaoImplDB dao = new DaoImplDB();

        MetierImpl1 metierImpl1 = new MetierImpl1();

        metierImpl1.setDao(dao);

        System.out.println("\n Static injection result : "+ metierImpl1.calculate() );

    }

}
