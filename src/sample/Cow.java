package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Cow extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersCow = new HashMap<>();

    public Cow() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> cowParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC2E";
        this.weight = Double.parseDouble(cowParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(cowParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(cowParameters.get(20)));
        this.saturation = Double.parseDouble(cowParameters.get(21));
        this.motion = Integer.parseInt(cowParameters.get(22));
        ArrayList<String> namesWithoutCow = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamCow = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutCow.size(); i++) {
            eatOthersCow.put(namesWithoutCow.get(i), Integer.valueOf(eatParamCow.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersCow.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersCow.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
