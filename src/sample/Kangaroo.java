package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Kangaroo extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersKangaroo = new HashMap<>();

    public Kangaroo() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> kangarooParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83E\uDD98";
        this.weight = Double.parseDouble(kangarooParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(kangarooParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(kangarooParameters.get(20)));
        this.saturation = Double.parseDouble(kangarooParameters.get(21));
        this.motion = Integer.parseInt(kangarooParameters.get(22));
        ArrayList<String> namesWithoutKangaroo = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamKangaroo = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutKangaroo.size(); i++) {
            eatOthersKangaroo.put(namesWithoutKangaroo.get(i), Integer.valueOf(eatParamKangaroo.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersKangaroo.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersKangaroo.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }

}
