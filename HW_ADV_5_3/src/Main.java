import storage.Car;
import storage.Color.Color;

import java.lang.reflect.*;

/**
 * Домашнее задание 5
 * Задание 3
 * Создайте класс, в нем определите 3 поля, к этим полям создайте конструкторы и методы.
 * Под средством рефлексии получите всю информацию о полях, методах, конструкторах, а также модификаторах доступа.
 */

public class Main {
    public static void main(String[] args) {
        String g$ = Color.GREEN;
        String d$ = Color.DEFAULT;
        String b$ = Color.BLUE;
        Car Obj = new Car();
        Class cl = Obj.getClass();
        System.out.println(b$ + "Создали объект класса Car, с помощью метода *.getClass() получили объект класса Class для иследования класса Car:" + d$);

        Field[] fields = cl.getDeclaredFields();
        System.out.println(b$ + "Поля класса: " + g$ + cl.getName() + d$);
        for (Field f : fields) {
            System.out.println("\tmodifier- " + g$ + Modifier.toString(f.getModifiers()) + d$ + ", type- " + g$ + f.getType().getSimpleName() + d$ + ", name- " + g$ + f.getName() + d$);
        }

        Method[] methods = cl.getDeclaredMethods();
        System.out.println(b$ + "Методы класса: " + g$ + cl.getName() + d$);
        for (Method m : methods) {
            System.out.print("\tmodifier- " + g$ + Modifier.toString(m.getModifiers()) + d$ + ", return type- " + g$ + m.getReturnType().getSimpleName() + d$ + ", name- " + g$ + m.getName() + d$ + " ( ");
            Parameter[] parametryMetod = m.getParameters();
            for (Parameter pm : parametryMetod) {
                System.out.print("type- " + pm.getType().getSimpleName() + ", name - " + pm.getName() + ", ");
            }
            System.out.println(")");
        }

        Constructor[] constructors = cl.getDeclaredConstructors();
        System.out.println(b$ + "Конструкторы класса: " + g$ + cl.getName() + d$);
        for (Constructor c : constructors) {
            System.out.print("\tmodifier- " + g$ + Modifier.toString(c.getModifiers()) + d$ + ", " + c.getName() + " ( ");
            Parameter[] parametryConstr = c.getParameters();
            for (Parameter pc : parametryConstr) {
                System.out.print("type- " + pc.getType().getSimpleName() + ", name - " + pc.getName() + "; ");
            }
            System.out.println(")");
        }


    }
}
