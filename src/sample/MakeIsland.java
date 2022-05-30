package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MakeIsland {

    public Island[][] makeIsland() throws SQLException, IOException, ClassNotFoundException {
        Island[][] islands = new Island[Island.width][Island.height];
        for (int i = 0; i < islands.length; i++) {
            for (int j = 0; j < islands[i].length; j++) {
                Island island = new Island();

                islands[i][j] = island;
            }
        }
        return islands;
    }


    public List<Animal> firstLiveAnimal() throws SQLException, IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Bear());
        animals.add(new Caterpillar());
        animals.add(new Cow());
        animals.add(new Deer());
        animals.add(new Duck());
        animals.add(new Fox());
        animals.add(new Goat());
        animals.add(new Hamster());
        animals.add(new Hare());
        animals.add(new Hawk());
        animals.add(new Horse());
        animals.add(new Kangaroo());
        animals.add(new Sheep());
        animals.add(new Snake());
        animals.add(new Wolf());
        return animals;
    }

    public List<Plants> firstLivePlants() throws SQLException, IOException, ClassNotFoundException {
        List<Plants> plants = new ArrayList<>();
        plants.add(new Plants());
        return plants;
    }

}
