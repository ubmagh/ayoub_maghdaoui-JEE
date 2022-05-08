package xml_injection_app.Presentation;

import Injector.XMLInjector;
import xml_injection_app.Metier.IBusinessLogic;

public class XmlInjectionTestApp {

    public static void main(String[] args) throws Exception {


        // using Setter injection ; XMLInjector injector = new XMLInjector("./src/main/resources/PropertyInjectionContext.xml");
        // using Constructor Injection :
        XMLInjector injector = new XMLInjector("./src/main/resources/ConstructorInjectionContext.xml");

        IBusinessLogic blogicObject = (IBusinessLogic) injector.getBean("metier");
        System.out.println(" XmlDInjection calculate() result ;) : "+blogicObject.calculate() );
    }

}
