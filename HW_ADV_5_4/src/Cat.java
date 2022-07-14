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
        System.out.println("Первоначальный класс  : " + animal);
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
        System.out.println("Измененный класс 1-раз: " + animal);
        try {
            Field fl1 = cl.getDeclaredField("name");
            fl1.setAccessible(true);
            fl1.set(animal, "dog");
            Field fl2 = cl.getDeclaredField("weight");
            fl2.setAccessible(true);
            fl2.set(animal, 7.350);
            Field fl3 = cl.getDeclaredField("age");
            fl3.setAccessible(true);
            fl3.set(animal, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Что не так с аргументом или поле не было найдено");
        }
        System.out.println("Измененный класс 2-раз: " + animal);
    }
}
