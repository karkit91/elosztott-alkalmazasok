import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void saveGyms(ArrayList<Gym> gyms) {
        try {
            FileOutputStream writeData = new FileOutputStream("output.dat");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            gyms.stream().forEach(gym -> {
                try {
                    writeStream.writeObject(gym);
                    writeStream.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            writeStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadGyms(ArrayList<Gym> gyms) {
        try {
            FileInputStream fstream = new FileInputStream("output.dat");
            ObjectInputStream ostream = new ObjectInputStream(fstream);
            while (true) {
                Gym obj;
                try {
                    obj = (Gym) ostream.readObject();
                    gyms.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
            fstream.close();
        } catch (Exception e) {
        }
    }
}
