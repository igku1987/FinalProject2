package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Fox extends Predators {

    DB db = new DB();

    HashMap<String, Integer> eatOthersFox = new HashMap<>();

    public Fox() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> foxParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83E\uDD8A";
        this.weight = Double.parseDouble(foxParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(foxParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(foxParameters.get(20)));
        this.saturation = Double.parseDouble(foxParameters.get(21));
        this.motion = Integer.parseInt(foxParameters.get(22));
        ArrayList<String> namesWithoutFox = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamFox = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutFox.size(); i++) {
            eatOthersFox.put(namesWithoutFox.get(i), Integer.valueOf(eatParamFox.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersFox.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersFox.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
