package sample;

public class Inhabitants {

    private int id;
    private String type;
    private String name;
    private String startNumber;
    private String numbersBorn;
    private String numbersDied;

    public Inhabitants(int id, String type, String name, String startNumber, String numbersBorn, String numbersDied) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.startNumber = startNumber;
        this.numbersBorn = numbersBorn;
        this.numbersDied = numbersDied;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartNumber(String startNumber) {
        this.startNumber = startNumber;
    }

    public void setNumbersBorn(String numbersBorn) {
        this.numbersBorn = numbersBorn;
    }

    public void setNumbersDied(String numbersDied) {
        this.numbersDied = numbersDied;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public String getNumbersBorn() {
        return numbersBorn;
    }

    public String getNumbersDied() {
        return numbersDied;
    }
}
