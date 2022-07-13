import color.Color;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Домашнее задание 5
 * Задание 2
 * Напишите программу, которая будет выводить всю информацию о классе,
 * пользователь сам выбирает, какой именно класс интересует.
 */

public class AllClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String userNameClass;
        while (true) {
            System.out.println(Color.GREEN + "Введите название класса. В названии используйте полный путь к пакетам где хранится класс");
            System.out.println(Color.BLUE + "\tНапример: java.util.ArrayList или: java.lang.Integer или: models.Employee или другое:" + Color.DEFAULT);
            userNameClass = scanner.next();
            try {
                if (userNameClass.length() > 0) {
                    Class.forName(userNameClass);
                    break;
                }
            } catch (ClassNotFoundException e) {
                System.out.println(Color.RED + userNameClass + Color.DEFAULT + " - Класс не найден, уточните путь и наличие класса!");
            }
        }

        Class<?> cl = Class.forName(userNameClass);
        Class<?> clSuper = cl.getSuperclass();
        System.out.print("1. Родителем класса " + Color.GREEN + userNameClass + Color.DEFAULT + " является: ");
        if (cl != Object.class && clSuper != null) {
            System.out.println(Color.GREEN + clSuper.getName() + Color.DEFAULT);
        } else if (clSuper == null && cl != Object.class) {
            System.out.println(" нет родителя! - " + Color.GREEN + "это interface" + Color.DEFAULT);
        } else {
            System.out.println(" нет родителя! Это суперкласс на вершине иерархии классов!");
        }
        System.out.println("  2. Доступ к классу - " + Color.GREEN + (Modifier.toString(cl.getModifiers()).equals("") ? "no mod." : Modifier.toString(cl.getModifiers())) + Color.DEFAULT + " сокращенное имя класса - " + Color.GREEN + cl.getSimpleName() + Color.DEFAULT);

        Field[] fields = cl.getDeclaredFields();
        System.out.print("\t3.1. Класс " + userNameClass + " имеет следующие поля: ");
        if (fields.length == 0) {
            System.out.println(Color.GREEN + "не имеет полей" + Color.DEFAULT);
        } else {
            System.out.println();
        }
        int count1 = 0;
        for (Field f : fields) {
            int modField = f.getModifiers();
            System.out.println("\t\t3.1." + (++count1) + ". мод.доступа - " + Color.GREEN + (Modifier.toString(modField).equals("") ? "no mod." : Modifier.toString(modField)) + Color.DEFAULT + ", тип - " + Color.GREEN + f.getType() + Color.DEFAULT + ", название - " + Color.GREEN + f.getName() + Color.DEFAULT);
        }

        System.out.print("\t3.2. Класс " + userNameClass + " имеет следующие конструкторы: ");
        Constructor[] clConst = cl.getDeclaredConstructors();
        if (clConst.length == 0) {
            System.out.println(Color.GREEN + "не имеет конструкторов" + Color.DEFAULT);
        } else {
            System.out.println();
        }
        int count2 = 0;
        for (Constructor c : clConst) {
            System.out.print("\t\t3.2." + (++count2) + ". мод.доступа - " + Color.GREEN + (Modifier.toString(c.getModifiers()).equals("") ? "no mod." : Modifier.toString(c.getModifiers())) + Color.DEFAULT + " " + c.getName().split("\\.")[c.getName().split("\\.").length - 1]);
            Class[] clClass = c.getParameterTypes();
            System.out.print(" ( ");
            for (Class cons : clClass) {
                System.out.print("тип- " + cons.getSimpleName() + ", ");
            }
            System.out.println(")");
        }

        Method[] methods = cl.getDeclaredMethods();
        System.out.print("\t3.3. Класс " + userNameClass + " имеет следующие методы: ");
        if (methods.length == 0) {
            System.out.println(Color.GREEN + " класс не имеет методов" + Color.DEFAULT);
        }
        System.out.println();
        int count3 = 0;
        for (Method m : methods) {
            int modMethod = m.getModifiers();
            System.out.print("\t\t3.3." + (++count3) + ". мод.доступа - " + Color.GREEN + (Modifier.toString(modMethod).equals("") ? "no mod." : Modifier.toString(modMethod)) + Color.DEFAULT + ", возвращаемый тип - " + Color.GREEN + m.getReturnType() + Color.DEFAULT + ", название - " + Color.GREEN + m.getName() + Color.DEFAULT);
            Class[] metParam = m.getParameterTypes();
            System.out.print(" ( ");
            for (Class mp : metParam) {
                System.out.print("тип- " + mp.getSimpleName() + ", ");
            }
            System.out.println(")");
        }

    }
}
