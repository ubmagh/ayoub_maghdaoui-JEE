package Presentation;

import Dao.IDao;
import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AutowiredInjectionApp {

    public static void main(String[] args) throws Exception{

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dao","metier");
        IMetier metier = (IMetier) applicationContext.getBean("metierAutowiredInjection");
        System.out.println( "\n Spring autowired injection result : "+ metier.calculate());

    }

}
