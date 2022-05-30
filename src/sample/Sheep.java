package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Sheep extends Herbivores {

    DB db = new DB();

    HashMap<String, Integer> eatOthersSheep = new HashMap<>();

    public Sheep() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> sheepParameters = db.getAnimal(super.getClass().getSimpleName().toLowerCase());
        this.name = "\uD83D\uDC11";
        this.weight = Double.parseDouble(sheepParameters.get(18));
        this.numbers = Island.rnd(1, Integer.parseInt(sheepParameters.get(19)));
        this.speed = Island.rnd(1, Integer.parseInt(sheepParameters.get(20)));
        this.saturation = Double.parseDouble(sheepParameters.get(21));
        this.motion = Integer.parseInt(sheepParameters.get(22));
        ArrayList<String> namesWithoutSheep = db.getCountNames(super.getClass().getSimpleName().toLowerCase());
        ArrayList<String> eatParamSheep = db.getEatParams(super.getClass().getSimpleName().toLowerCase());
        for (int i = 0; i < namesWithoutSheep.size(); i++) {
            eatOthersSheep.put(namesWithoutSheep.get(i), Integer.valueOf(eatParamSheep.get(i)));
        }
    }

    @Override
    public String toEat() {
        int rnd = Island.rnd(1, Collections.max(eatOthersSheep.values()));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : eatOthersSheep.entrySet()) {
            if (rnd <= entry.getValue()) {
                arrayList.add(entry.getKey());
            }
        }
        int index = Island.rnd(0, arrayList.size() - 1);
        return arrayList.get(index);
    }
}
