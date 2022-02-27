package Presentation;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlInjectionApp {

    public static void main(String[] args) {

        /* The injection here depends on the configuration provided inside ; ApplicationContext.xml */

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IMetier metier = (IMetier) applicationContext.getBean("metier");
        System.out.println("\n Result With Spring ApplicationContext.xml file injection => "+ metier.calculate());

    }

}
