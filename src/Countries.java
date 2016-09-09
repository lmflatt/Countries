import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Countries {
    public static Map<String, List<Country>> alphabeticalCountries = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File f = new File("countries.txt");
        Scanner s = new Scanner(f);
        String keyLetter = "#";
        List<Country> countries = new ArrayList<>();

        while (s.hasNext()) {
            String line = s.nextLine();
            String[] column = line.split("\\|");
            Country country = new Country(column[0], column[1]);
            if (country.getName().startsWith(keyLetter)){
                countries.add(country);
                alphabeticalCountries.put(keyLetter, countries);
            }
            else {
                keyLetter = country.getName().substring(0, 1);
                countries = new ArrayList<>();
                countries.add(country);
                alphabeticalCountries.put(keyLetter, countries);
            }
        }
        s.close();

        System.out.println("Please type a single letter to generate a list of countries that begin with that letter.");
        writeFile(scanner.nextLine());
    }

    static void writeFile(String keyInput) throws IOException {

        List<Country> listCountries = new ArrayList<>();

        if(alphabeticalCountries.get(keyInput) != null) {
            listCountries = alphabeticalCountries.get(keyInput);
            File f = new File(keyInput + "_countries.txt");
            FileWriter fw = new FileWriter(f);

            for (Country country : listCountries) {
                String fileContent = String.format("%s|%s\n", country.getAbbreviation(), country.getName());
                fw.write(fileContent);
            }
            fw.close();
        }
        else {
            System.out.println("Entry was not a valid single letter or there are no countries beginning with that letter.");
        }

    }
}
