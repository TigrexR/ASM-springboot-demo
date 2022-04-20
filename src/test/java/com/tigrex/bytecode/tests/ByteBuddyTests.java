package com.tigrex.bytecode.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

import org.assertj.core.internal.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.junit.jupiter.api.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType.Loaded;
import net.bytebuddy.dynamic.DynamicType.Unloaded;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

/**
 * @author linus
 */
public class ByteBuddyTests {

    @Test
    public void reloadClass() throws IOException, IllegalAccessException, InstantiationException {
        Unloaded<Object> make = new ByteBuddy().subclass(Object.class)
            .name("com.tigrex.bytecode.tests.template.Hello")
            .defineProperty("key", Integer.class)
            .defineProperty("value", String.class)
            .make();
            
        //        outputClazz(make.getBytes(), "Hello.class");
        Class<? extends Object> clazz = make.load(Thread.currentThread().getContextClassLoader()).getLoaded();
        Field[] declaredFields = clazz.getDeclaredFields();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("x");

        // GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        // String hello = "public class ScriptEntity {\n" +
        //         "    \n" +
        //         "    public String printEntity(Class<? extends Object> clazz) {\n" +
        //         // "        clazz.setKey(1);\n" +
        //         // "        clazz.setValue(\"123\");\n" +
        //         "        System.out.print(clazz.toString());\n" +
        //         "        return \"OK\";\n" +
        //         "    }\n" +
        //         "}";
        // Class helloClazz = groovyClassLoader.parseClass(hello);
        // GroovyObject object = (GroovyObject) helloClazz.newInstance();
        // Object[] args = {clazz};
        // Object o = object.invokeMethod("printEntity", args);
        // System.out.println(o);

        // GroovyShell shell = new GroovyShell();

        // groovyClassLoader.close();
    }

    @Test
    public void dir() {
        System.out.println(System.getProperty("user.dir") + "\\test\\java\\com\\tigrex\\bytecode\\tests\\template");
    }

    private void outputClazz(byte[] bytes, String className) {
        FileOutputStream out = null;
        try {
            String pathName = System.getProperty("user.dir") + "\\src\\test\\java\\com\\tigrex\\bytecode\\tests\\template\\" + className;
            out = new FileOutputStream(new File(pathName));
            System.out.println("类输出路径：" + pathName);
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
