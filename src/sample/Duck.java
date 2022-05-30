package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Duck extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersDuck = new HashMap<>();

    public Duck() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> duckParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83E\uDD86";
        this.weight = Double.parseDouble(duckParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(duckParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(duckParameters.get(20)));
        this.saturation = Double.parseDouble(duckParameters.get(21));
        this.motion = Integer.parseInt(duckParameters.get(22));
        ArrayList<String> namesWithoutDuck = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamDuck = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutDuck.size(); i++) {
            eatOthersDuck.put(namesWithoutDuck.get(i), Integer.valueOf(eatParamDuck.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersDuck.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersDuck.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
