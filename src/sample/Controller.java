package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class Controller {

    private ObservableList<Inhabitants> inhabitants = FXCollections.observableArrayList();
    int index = 1;

    @FXML
    private TableView<Inhabitants> tableInhabitants;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private TableColumn<Inhabitants, String> id;

    @FXML
    private TableColumn<Inhabitants, String> type;

    @FXML
    private TableColumn<Inhabitants, String> name;

    @FXML
    private TableColumn<Inhabitants, String> startNumber;

    @FXML
    private TableColumn<Inhabitants, String> numbersBorn;

    @FXML
    private TableColumn<Inhabitants, String> numbersDied;

    @FXML
    void initialize() throws SQLException, IOException, ClassNotFoundException, InterruptedException {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        startNumber.setCellValueFactory(new PropertyValueFactory<>("startNumber"));
        numbersBorn.setCellValueFactory(new PropertyValueFactory<>("numbersBorn"));
        numbersDied.setCellValueFactory(new PropertyValueFactory<>("numbersDied"));

        DB db = new DB();

        Island island1 = new Island();

        MakeIsland makeIsland = new MakeIsland();
        Island[][] island = makeIsland.makeIsland();

        for (int i = 0; i < db.getRows() - 1; i++) {
            inhabitants.add(new Inhabitants(index, island1.animals.get(i).getClass().getSimpleName(),
                    island1.animals.get(i).getName(), String.valueOf(island1.animals.get(i).numbers),
                    "",""));
            index++;
        }
        inhabitants.add(new Inhabitants(index, island1.plants.get(0).getClass().getSimpleName(),
                island1.plants.get(0).getName(),String.valueOf(island1.plants.get(0).numbers),
                "", ""));
        tableInhabitants.setItems(inhabitants);
        tableInhabitants.setColumnResizePolicy((param) -> true );

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j].start();
//                System.out.println("Количество медведей: " + island1.animals.get(0).getNumbers());
            }
        }
    }
}

