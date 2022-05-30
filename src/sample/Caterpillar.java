package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Caterpillar extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersCaterpillar = new HashMap<>();

    public Caterpillar() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> CaterpillarParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC1B";
        this.weight = Double.parseDouble(CaterpillarParameters.get(18));
        this.numbers = Island.rnd(500, Integer.parseInt(CaterpillarParameters.get(19)));
//        this.speed = Island.rnd(Integer.parseInt(CaterpillarParameters.get(20)));
//        this.saturation = Double.parseDouble(CaterpillarParameters.get(21));
//        this.motion = Integer.parseInt(CaterpillarParameters.get(22));
        ArrayList<String> namesWithoutCaterpillar = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamCaterpillar = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutCaterpillar.size(); i++) {
            eatOthersCaterpillar.put(namesWithoutCaterpillar.get(i), Integer.valueOf(eatParamCaterpillar.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersCaterpillar.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersCaterpillar.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
