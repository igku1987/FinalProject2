package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Wolf extends Predators{

    DB db = new DB();

    HashMap<String, Integer> eatOthersWolf = new HashMap<>();

    public Wolf() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> wolfParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC3A";
        this.weight = Double.parseDouble(wolfParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(wolfParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(wolfParameters.get(20)));
        this.saturation = Double.parseDouble(wolfParameters.get(21));
        this.motion = Integer.parseInt(wolfParameters.get(22));
        ArrayList<String> namesWithoutWolf = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamWolf = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutWolf.size(); i++) {
            eatOthersWolf.put(namesWithoutWolf.get(i), Integer.valueOf(eatParamWolf.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersWolf.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersWolf.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
