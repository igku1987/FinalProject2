package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Goat extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersGoat = new HashMap<>();

    public Goat() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> goatParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC10";
        this.weight = Double.parseDouble(goatParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(goatParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(goatParameters.get(20)));
        this.saturation = Double.parseDouble(goatParameters.get(21));
        this.motion = Integer.parseInt(goatParameters.get(22));
        ArrayList<String> namesWithoutGoat = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamGoat = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutGoat.size(); i++) {
            eatOthersGoat.put(namesWithoutGoat.get(i), Integer.valueOf(eatParamGoat.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersGoat.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersGoat.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
