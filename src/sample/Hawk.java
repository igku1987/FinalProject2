package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Hawk extends Predators {

    DB db = new DB();

    HashMap<String, Integer> eatOthersHawk = new HashMap<>();

    public Hawk() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> hawkParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83E\uDD85";
        this.weight = Double.parseDouble(hawkParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(hawkParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(hawkParameters.get(20)));
        this.saturation = Double.parseDouble(hawkParameters.get(21));
        this.motion = Integer.parseInt(hawkParameters.get(22));
        ArrayList<String> namesWithoutHawk = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamHawk = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutHawk.size(); i++) {
            eatOthersHawk.put(namesWithoutHawk.get(i), Integer.valueOf(eatParamHawk.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersHawk.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersHawk.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
