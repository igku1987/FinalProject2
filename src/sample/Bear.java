package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Bear extends Predators {

    DB db = new DB();

    HashMap<String, Integer> eatOthersBear = new HashMap<>();

    public Bear() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> bearParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC3B";
        this.weight = Double.parseDouble(bearParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(bearParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(bearParameters.get(20)));
        this.saturation = Double.parseDouble(bearParameters.get(21));
        this.motion = Integer.parseInt(bearParameters.get(22));
        ArrayList<String> namesWithoutBear = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamBear = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutBear.size(); i++) {
            eatOthersBear.put(namesWithoutBear.get(i), Integer.valueOf(eatParamBear.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersBear.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersBear.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
            else arrayList.add("");
        }

        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
