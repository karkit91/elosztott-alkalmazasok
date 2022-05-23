import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Gym> gyms = new ArrayList<>();

    public static void main(String[] args) {
        FileHandler.loadGyms(gyms);
        boolean isRun = true;
        int selectedMenu = -1;

        while (isRun) {
            System.out.println("\n");
            System.out.println("Válasszon az alábbi menü pontokból:");
            System.out.println("1. Személy hozzáadása az edzőteremhez");
            System.out.println("2. Edzőterem létrehozása");
            System.out.println("3. Edzőtermi edzés");
            System.out.println("4. Tagok listázása");
            System.out.println("5. Mentés");
            System.out.println("9. Kilépés");

            try {
                selectedMenu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Menüpont nem létezik");
                scanner = new Scanner(System.in);
            }
            switch (selectedMenu) {
                case 1: {
                    if (gyms.size() > 0) {
                        addPersonToGym();
                    } else {
                        System.out.println("\nNincs elérhető edzőterem");
                    }
                }
                break;
                case 2: {
                    createNewGym();
                    listGyms();
                }
                break;
                case 3: {
                    System.out.println("Adja meg az edzőterem számát ahol edzés történik");
                    listGyms();
                    try {
                        int gymNumber = scanner.nextInt();
                        gyms.get(gymNumber - 1).train();
                        listMembersOfGym(gymNumber - 1);
                    } catch (Exception e) {
                        System.out.println("Nincs ilyen edzőterem");
                    }
                }
                break;
                case 4: {
                    if (gyms.size() > 0) {
                        System.out.println("Adja meg a listázandó edzőterem számát");
                        listGyms();
                        try {
                            int gymNumber = scanner.nextInt();
                            System.out.println(gymNumber);
                            listMembersOfGym(gymNumber - 1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Nincs ilyen edzőterem");
                        }
                    } else {
                        System.out.println("Nincs még edzőterem létrehozva");
                    }
                }
                break;
                case 5:
                    FileHandler.saveGyms(gyms);
                    break;
                case 9:
                    isRun = false;
                    break;
                default:
                    // code block
            }


        }

        System.out.println("A program kilépett");
    }

    public static void addPersonToGym() {
        Person newPerson = null;
        scanner.nextLine();
        System.out.println("\nAz új tag neve neve:");
        String name = scanner.nextLine();
        System.out.println("Sportolo? I / N");
        String athlete = scanner.nextLine().toUpperCase();
        if (athlete.contains("I")) {
            newPerson = new Athlete(name);
        } else if (athlete.contains("N")) {
            newPerson = new NormalPerson(name);
        }

        if (newPerson != null) {
            listGyms();
            System.out.println("Add meg az edzőterem sorszámát:");
            int numberOfGym = scanner.nextInt();

            try {
                gyms.get(numberOfGym - 1).addMembers(newPerson);
            } catch (Exception e) {
                System.out.println("Nem létező edzőterem");
            }
        } else {
            System.out.println("Nem sikerült hozzáadni");
        }

    }

    public static void listGyms() {
        for (int i = 0; i < gyms.size(); i++) {
            System.out.println((i + 1) + ". " + gyms.get(i));
        }
    }

    public static void listMembersOfGym(int gymNumber) {
        gyms.get(gymNumber).getMembers().stream().forEach(member -> {
            System.out.println("Név: " + member.getName() + " - Edzettség: " + String.format("%.2f", member.getFitness()));
        });
    }

    public static void createNewGym() {
        scanner.nextLine();
        System.out.println("\n Az új edzőterem neve:");
        String name = scanner.nextLine();
        if (!(name == "")) {
            gyms.add(new Gym(name));
        } else {
            System.out.println("Név megadása kötelező");
        }
    }
}
