public class Animal {
    private String name = "sheep";
    double weight = 25.5;
    public int age = 5;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
