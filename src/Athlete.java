public class Athlete extends Person {

    public Athlete(String name) {
        super(name, 20);
    }

    @Override
    public void train() {
        setFitness(this.getFitness() * 1.05);
    }

    @Override
    public int compareTo(Person o) {
        if (this.getFitness() == o.getFitness()) return 0;
        if (this.getFitness() > o.getFitness()) return 1;
        return -1;
    }
}
