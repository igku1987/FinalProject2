package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Snake extends Predators {

    DB db = new DB();

    HashMap<String, Integer> eatOthersSnake = new HashMap<>();

    public Snake() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> snakeParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC0D";
        this.weight = Double.parseDouble(snakeParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(snakeParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(snakeParameters.get(20)));
        this.saturation = Double.parseDouble(snakeParameters.get(21));
        this.motion = Integer.parseInt(snakeParameters.get(22));
        ArrayList<String> namesWithoutSheep = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamSheep = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutSheep.size(); i++) {
            eatOthersSnake.put(namesWithoutSheep.get(i), Integer.valueOf(eatParamSheep.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersSnake.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersSnake.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
