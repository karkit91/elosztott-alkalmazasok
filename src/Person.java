import java.io.Serializable;

abstract class Person implements Train, Serializable, Comparable<Person> {

    private final String name;
    private double fitness;

    public Person(String name, double fitness) {
        this.name = name;
        this.fitness = fitness;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public String getName() {
        return name;
    }

}
