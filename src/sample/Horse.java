package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Horse extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersHorse = new HashMap<>();

    public Horse() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> horseParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC0E";
        this.weight = Double.parseDouble(horseParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(horseParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(horseParameters.get(20)));
        this.saturation = Double.parseDouble(horseParameters.get(21));
        this.motion = Integer.parseInt(horseParameters.get(22));
        ArrayList<String> namesWithoutHorse = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamHorse = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutHorse.size(); i++) {
            eatOthersHorse.put(namesWithoutHorse.get(i), Integer.valueOf(eatParamHorse.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersHorse.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersHorse.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
