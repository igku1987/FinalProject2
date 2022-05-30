package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Hare extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersHare = new HashMap<>();

    public Hare() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> hareParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC07";
        this.weight = Double.parseDouble(hareParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(hareParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(hareParameters.get(20)));
        this.saturation = Double.parseDouble(hareParameters.get(21));
        this.motion = Integer.parseInt(hareParameters.get(22));
        ArrayList<String> namesWithoutHare = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamHare = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutHare.size(); i++) {
            eatOthersHare.put(namesWithoutHare.get(i), Integer.valueOf(eatParamHare.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersHare.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersHare.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
