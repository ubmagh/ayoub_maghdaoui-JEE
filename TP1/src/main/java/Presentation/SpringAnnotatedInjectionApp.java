package Presentation;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotatedInjectionApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dao","metier");

        IMetier metier = (IMetier) applicationContext.getBean("metierAnotatedConstructorInjection");
        System.out.println("\n Annotated Constructor Injection result  => "+ metier.calculate());


    }
}
