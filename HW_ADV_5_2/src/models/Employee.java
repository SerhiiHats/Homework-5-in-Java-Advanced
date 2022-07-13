package models;

public class Employee  implements Comparable<Employee>{
    private String name;
    private String jobTitle;
    private int age;
    private int salary;

    public Employee(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String space1 = bildSpace(12 - name.length());
        String space2 = bildSpace(28 - jobTitle.length());
        String space3 = bildSpace( 6 - String.valueOf(salary).length());

        return "| " + name + space1 +
                "| должность | " +  jobTitle +
                space2 + "| возраст | " + age +
                " | оклад | " + salary + space3 + "|";
    }

    public static String bildSpace(int leghtString) {
        StringBuilder strBld = new StringBuilder();
        for (int i = 0; i < leghtString; i++) {
            strBld.append(" ");
        }
        return strBld.toString();
    }

    @Override
    public int compareTo(Employee o) {
        return this.salary - o.salary;
    }
}
