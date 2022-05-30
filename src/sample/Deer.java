package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Deer extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersDeer = new HashMap<>();

    public Deer() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> deerParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83E\uDD8C";
        this.weight = Double.parseDouble(deerParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(deerParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(deerParameters.get(20)));
        this.saturation = Double.parseDouble(deerParameters.get(21));
        this.motion = Integer.parseInt(deerParameters.get(22));
        ArrayList<String> namesWithoutDeer = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamDeer = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutDeer.size(); i++) {
            eatOthersDeer.put(namesWithoutDeer.get(i), Integer.valueOf(eatParamDeer.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersDeer.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersDeer.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
