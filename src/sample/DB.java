package sample;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DB {

    private Connection dbConn = null;

    private Connection getDbConnection() throws SQLException {
        String url = "jdbc:sqlite:src//animals";
        dbConn = DriverManager.getConnection(url);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public int getCount() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM animals";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = res.getMetaData();
        return resultSetMetaData.getColumnCount();
    }

    public int getRows() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT * FROM animals";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        int index = 0;
        while (res.next()) {
            index++;
        }
        return index;
    }

    public ArrayList<String> getAnimal(String type) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM `animals` WHERE type = " + "'" + type + "'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        int columns = res.getMetaData().getColumnCount();
        while (res.next()) {
            for (int i = 1; i < columns + 1; i++) {
                arrayList.add(res.getString(i));
            }
        }
        return arrayList;
    }

    public ArrayList<String> getCountNames(String name) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT name FROM PRAGMA_TABLE_INFO('animals');";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        int columns = res.getMetaData().getColumnCount();
        while (res.next()) {
            for (int i = 1; i < columns + 1; i++) {
                arrayList.add(res.getString(i));
            }
        }
        arrayList.remove(0);
        arrayList.remove(0);
        for (int i = 0; i < 5; i++) {
            arrayList.remove(16);
        }
        arrayList.remove(name);
        return arrayList;
    }

    public ArrayList<String> getEatParams(String type) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM `animals` WHERE type = " + "'" + type + "'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        int columns = res.getMetaData().getColumnCount();
        while (res.next()) {
            for (int i = 1; i < columns + 1; i++) {
                arrayList.add(res.getString(i));
            }
        }
        arrayList.remove(0);
        arrayList.remove(0);
        for (int i = 0; i < 5; i++) {
            arrayList.remove(16);
        }
        arrayList.remove(null);
        return arrayList;
    }

    public int getPlants() throws SQLException {
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM `animals` WHERE type = 'plants'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        int numbersPlants = Integer.parseInt(res.getString("numbers"));
        return numbersPlants;
    }

//    public void getInhabitants(ObservableList<Inhabitants> inhabitants) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT * FROM `animals`";
//        int index = 0;
//        Statement statement = getDbConnection().createStatement();
//        ResultSet res = statement.executeQuery(sql);
//        while (res.next()) {
//            inhabitants.add(new Inhabitants(++index, res.getString(2), res.getString(3),
//                    res.getString(4), res.getString(5), res.getString(6)));
//        }
//    }





}
