package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Island extends Thread {

    public Island() throws SQLException, IOException, ClassNotFoundException {
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;

    }

    public static int height = 1;
    public static int width = 6;

    static MakeIsland makeIsland = new MakeIsland();
    static List<Animal> animals;
    static List<Plants> plants;

    static {
        try {
            animals = makeIsland.firstLiveAnimal();
            plants = makeIsland.firstLivePlants();
//            System.out.println("Начальное количество коров: " + animals.get(2).getNumbers());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // вся логика жизни острова здесь в методе run!!!

    public void run() {

        for (int i = 0; i < animals.size(); i++) {


            ArrayList<Animal> animal = new ArrayList<>();
            int numbers = animals.get(i).getNumbers();
            for (int k = 0; k < numbers; k++) {
                animal.add(animals.get(i));
            }
            for (int k = 0; k < animal.size(); k++) {
                for (int j = 0; j < animals.size(); j++) {
                    if (animals.get(i) instanceof Predators) {
                        if (animal.get(k).toEat().equals(animals.get(j).getClass().getSimpleName().toLowerCase())) {
                            animals.get(j).setNumbers(animals.get(j).getNumbers() - 1);
                            break;
                        }

                    }
                }
                animal.get(k).moveTo();
            }
            if ((animals.get(i) instanceof Herbivores)) {
                plants.get(0).setNumbers(plants.get(0).getNumbers() - animal.size());
//                System.out.println("Количество растений: " + plants.get(0).getNumbers());
                if (plants.get(0).getNumbers() <= 0) {
                    plants.get(0).setNumbers(0);

                }
            }
            animals.get(i).setNumbers(animals.get(i).getNumbers() + animals.get(i).getNumbers() / 2);
        }





    }
}
