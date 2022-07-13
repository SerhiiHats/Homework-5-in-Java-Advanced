import java.lang.reflect.Field;

/**
 * Домашнее задание 5
 * Задание 4
 * Создайте 2 класса, Animal и Cat.
 * В классе Animal инициализируйте 3 поля различных модификаторов.
 * В классе Cat используя рефлексию получите доступ к полям класса Animal и измените содержимое каждого из полей.
 */
public class Cat {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("Первоначальный класс: " + animal);
        Class<?> cl = Animal.class;
        Field[] field = cl.getDeclaredFields();

        for (Field field1 : field) {
            field1.setAccessible(true);
            if (field1.getType().getSimpleName().equals("String")) {
                try {
                    field1.set(animal, "hourse");
                } catch (IllegalAccessException e) {
                    System.out.println("что-то не так c аргументом №1");
                }
            }
            if (field1.getName().equals("weight")) {
                try {
                    field1.set(animal, 450.5);
                } catch (IllegalAccessException e) {
                    System.out.println("что-то не так c аргументом №2");
                }
            }
            if (field1.getType().getSimpleName().equals("int")) {
                try {
                    field1.set(animal, 7);
                } catch (IllegalAccessException e) {
                    System.out.println("что-то не так c аргументом №3");
                }
            }
        }
        System.out.println("Измененный класс    : " + animal);


    }
}
