public class NormalPerson extends Person {

    public NormalPerson(String name) {
        super(name, 10);
    }

    @Override
    public void train() {
        setFitness(this.getFitness() * 1.03);
    }

    @Override
    public int compareTo(Person o) {
        if (this.getFitness() == o.getFitness()) return 0;
        if (this.getFitness() > o.getFitness()) return 1;
        return -1;
    }
}
