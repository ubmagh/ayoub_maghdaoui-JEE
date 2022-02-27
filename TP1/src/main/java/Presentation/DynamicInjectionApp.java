package Presentation;

import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicInjectionApp {

    public static void main(String[] args) throws Exception{

        Scanner scanner=new Scanner(new File("config"));
        String daoClass =scanner.nextLine();
        Class cDao= Class.forName(daoClass);
        IDao dao= (IDao) cDao.newInstance();

        String metierClass=scanner.nextLine();
        Class cMetier=Class.forName(metierClass);
        IMetier metier= (IMetier) cMetier.newInstance();

        Method m= cMetier.getMethod("setDao",IDao.class);
        m.invoke(metier,dao);

        System.out.println( "\n Dynamic injection result : "+ metier.calculate());

    }

}
