package annotations_injection_app.Presentation;

import Injector.AnnotationInjector;
import xml_injection_app.Metier.IBusinessLogic;

public class AnnotationInjectionTestApp {

    public static void main(String[] args) throws Exception {

        AnnotationInjector injector = new AnnotationInjector("annotations_injection_app.Dao","annotations_injection_app.Metier");

        IBusinessLogic businessLogic = (IBusinessLogic) injector.getBeanInstance().get(IBusinessLogic.class);

        System.out.println(" data from blogic.calculate( ) : "+businessLogic.calculate());


    }

}
