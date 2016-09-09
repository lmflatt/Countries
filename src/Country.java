/**
 * Created by lee on 9/9/16.
 */
public class Country {

    private String abbreviation;
    private String name;

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}
