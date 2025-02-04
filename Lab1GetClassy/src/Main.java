import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Prince", "Zeln", "Garihim", 1021);
        Person p2 = new Person("Mr.", "Jensen", "Garihim", 1987);
        Person p3 = new Person("Ms.", "Jasmine", "Garihim", 2999);
        //Product i1 = new Product("Health Potion", "Restores 1d8 HP", 10.00);

        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person listed : people)
            {
                int len = listed.toString().length();
                writer.write(listed.toString(), 0, len);  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // person. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
