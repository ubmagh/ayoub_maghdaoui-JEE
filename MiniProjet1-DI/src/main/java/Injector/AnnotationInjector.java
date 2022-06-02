package Injector;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Filter;


public class AnnotationInjector {

    HashMap<Class, Object> beans =new HashMap<Class, Object>();

    public AnnotationInjector(String... packages) throws IllegalArgumentException, InstantiationException,  SecurityException, IllegalAccessException, NoSuchMethodException,  InvocationTargetException {

        ArrayList<Class> classes=new ArrayList<Class>();
        String methodName=null;
        Set<Class<?>> subTypesOf=null;

        for(String apackage : packages) {
            Reflections reflections = new Reflections(
                    new ConfigurationBuilder().setScanners(new SubTypesScanner(false), new ResourcesScanner())
                    .addUrls(ClasspathHelper.forJavaClassPath())
                    .filterInputsBy( new FilterBuilder().include(FilterBuilder.prefix(apackage)))
            );

            subTypesOf = reflections.getSubTypesOf(Object.class);
            for( Class c :subTypesOf) {
                if(c.toString().contains("class")) {
                    Object o = c.newInstance();
                    beans.put(c.getInterfaces()[0], o);
                    classes.add(c);
                }
            }


        }

        for(Class c : classes) {
            if( c.getAnnotations()[0].toString().contains("UComponent") && c.getDeclaredFields().length>0 ) {
                Field[] fields =c.getDeclaredFields();
                for(Field f : fields) {
                    if(f.getAnnotations()[0].toString().contains("UAutowired")) {
                        methodName="set"+f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                        Method method=c.getMethod(methodName,f.getType());
                        method.invoke(beans.get(c.getInterfaces()[0]), beans.get(f.getType()));
                    }
                }
            }
        }


    }


    public HashMap<Class, Object> getBeanInstance( ){
        return beans;
    }


}
