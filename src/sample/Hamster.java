package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Hamster extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersHamster = new HashMap<>();

    public Hamster() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> hamsterParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC39";
        this.weight = Double.parseDouble(hamsterParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(hamsterParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(hamsterParameters.get(20)));
        this.saturation = Double.parseDouble(hamsterParameters.get(21));
        this.motion = Integer.parseInt(hamsterParameters.get(22));
        ArrayList<String> namesWithoutHamster = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamHamster = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutHamster.size(); i++) {
            eatOthersHamster.put(namesWithoutHamster.get(i), Integer.valueOf(eatParamHamster.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersHamster.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersHamster.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
