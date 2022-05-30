package sample;

import java.sql.SQLException;

public class Plants {

    DB db = new DB();

    public int getNumbers() {
        return numbers;
    }

    int numbers;
    String name;

    public String getName() {
        return name;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    Plants() throws SQLException {

        this.numbers = Island.rnd(5000, db.getPlants());
        this.name = "\uD83C\uDF3A";

    }

}
