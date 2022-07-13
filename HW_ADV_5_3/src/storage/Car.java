package storage;

public class Car {
    private String model;
    private int yearOfBuild;
    private double cena;

    public Car(String model, int yearOfBuild, double cena) {
        this.model = model;
        this.yearOfBuild = yearOfBuild;
        this.cena = cena;
    }
    public Car(String model, double cena) {
        this.model = model;
        this.cena = cena;
    }
    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }

    public void setYearOfBuild(int yearOfBuild) {
        this.yearOfBuild = yearOfBuild;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "model= " + model + ", yearOfBuild=" + yearOfBuild + ", cena=" + cena;
    }
}
