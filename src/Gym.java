import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Gym implements Serializable {
    private final String name;
    private final ArrayList<Person> members = new ArrayList<>();

    public Gym(String name) {
        this.name = name;
    }

    public void train() {
        members.stream().forEach(member -> member.train());
        sortByFitness();
    }

    public void addMembers(Person person) {
        members.add(person);
        sortByFitness();
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    private void sortByFitness() {
        Collections.sort(members);
    }

    @Override
    public String toString() {
        return "Az edzőterem neve: " + getName();
    }
}
