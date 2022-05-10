package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import managers.FieldsChecker;
import managers.Commander;
import object.*;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import clinetSide.ClientSide;

public class MainFormController implements FieldsChecker, Initializable {

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<Flat> shortysTable;

    @FXML
    private TextField nameField;

    @FXML
    private TextField xCoordField;

    @FXML
    private TextField yCoordField;

    @FXML
    private TextField areaField;

    @FXML
    private TextField furnishField;

    @FXML
    private TextField viewField;

    @FXML
    private TextField numberOfRoomsField;


    private Transport transport; //Поле может быть null
    /** дом - может быть null*/
    private House house; //Поле может быть null

    @FXML
    private Tab mapTab;

    private Group group = new Group();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statusLabel.setText(Commander.getInstance().getUser());
        initTable();
        handleUpdateButtonAction();
    }

    @FXML
    private void initTable() {
        shortysTable.setEditable(true);
        TableColumn<Flat, String> shortysNameCol = new TableColumn("Name");
        shortysNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        shortysNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        shortysNameCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
        });
        TableColumn<Flat, Long> coordXCol = new TableColumn("X");
        coordXCol.setCellValueFactory(new PropertyValueFactory<>("X"));
        coordXCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        coordXCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setX(event.getNewValue());
        });
        TableColumn<Flat, Integer> coordYCol = new TableColumn<>("Y");
        coordYCol.setCellValueFactory(new PropertyValueFactory<>("Y"));
        coordYCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        coordYCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setY(event.getNewValue());
        });
        TableColumn<Flat, Long> areaCol = new TableColumn("area");
        areaCol.setCellValueFactory(new PropertyValueFactory<>("area"));
        areaCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        areaCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setArea(event.getNewValue());
        });
        TableColumn<Flat, Long> numberOfRoomsCol = new TableColumn("numberOfRooms");
        numberOfRoomsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
        numberOfRoomsCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        numberOfRoomsCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setNumberOfRooms(Long.valueOf(event.getNewValue()));
        });
        TableColumn<Flat, String> masterIDCol = new TableColumn("Master Name");
        masterIDCol.setCellValueFactory(new PropertyValueFactory<>("masterName"));
        masterIDCol.setCellFactory(TextFieldTableCell.forTableColumn());
        masterIDCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
        });
        TableColumn<Flat, Long> IDCol = new TableColumn("ID");
        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        IDCol.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        IDCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setId(event.getNewValue());
        });
        TableColumn<Flat, String> FurnishCol = new TableColumn("Furnish");
        FurnishCol.setCellValueFactory(new PropertyValueFactory<>("furnish"));
        FurnishCol.setCellFactory(TextFieldTableCell.forTableColumn());
        FurnishCol.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setFurnish(Furnish.value(event.getNewValue()));
        });
        shortysTable.getColumns().addAll(IDCol, shortysNameCol, masterIDCol, areaCol, numberOfRoomsCol);
        fillTable();
    }

    @FXML
    private void fillMap() {
        group.getChildren().clear();
        List<Flat> shorties = Commander.getInstance().load();
        for (Flat s: shorties) {
            Circle circle = new Circle(s.getCoordinates().getX(), s.getCoordinates().getY(), s.getArea()/5, Color.valueOf(colorByID(s.getMasterName().hashCode())));
            circle.setOnMouseClicked(event -> new AlertHelper(Alert.AlertType.INFORMATION, "INFO", s.toString()).show());
            group.getChildren().add(circle);
        }
        mapTab.setContent(group);
    }

    @FXML
    private void fillTable() {
        shortysTable.setItems(FXCollections.observableArrayList(Commander.getInstance().load()));
        shortysTable.refresh();
    }

    @FXML
    private void handleAddButtonAction() {
        try {
            if (dataIsEntered()) {
                Commander.getInstance().add(nameField.getText(), Long.parseLong(xCoordField.getText()),
                        Integer.parseInt(yCoordField.getText()), Long.parseLong(areaField.getText()), Long.parseLong(numberOfRoomsField.getText()),
                        Furnish.valueOf(furnishField.getText()), View.valueOf(viewField.getText()));
                handleUpdateButtonAction();
            }
        } catch (NumberFormatException e) {
            notNumberAlert(e);
        }
    }

    @FXML
    private void handleAddIfMinButtonAction() {
        try {
            if (dataIsEntered()) {
                Commander.getInstance().addIfMin(nameField.getText(), Long.parseLong(xCoordField.getText()),
                        Integer.parseInt(yCoordField.getText()), Long.parseLong(areaField.getText()), Long.parseLong(numberOfRoomsField.getText()),
                        Furnish.valueOf(furnishField.getText()), View.valueOf(viewField.getText()));
                handleUpdateButtonAction();
            }
        } catch (NumberFormatException e) {
            notNumberAlert(e);
        }
    }

    @FXML
    private void notNumberAlert(Exception e) {
        new AlertHelper(Alert.AlertType.ERROR, e.getLocalizedMessage(), ClientSide.languageResource.
                getString("alert.CoordsIllegalMessage")).show();
    }

    @FXML
    private void handleSaveButtonAction() {
        Commander.getInstance().save();
        handleUpdateButtonAction();
    }

    @FXML
    private void handleRemoveLastButtonAction() {
        Commander.getInstance().removeLast();
        handleUpdateButtonAction();
    }

    @FXML
    private void handleUpdateButtonAction() {
        fillTable();
        fillMap();
    }

    @FXML
    private void handleDeleteButtonAction() {
        Commander.getInstance().remove(shortysTable.getSelectionModel().getSelectedItem());
        handleUpdateButtonAction();
    }

    @FXML
    private void handleClearButtonAction() {
        Commander.getInstance().clear();
        handleUpdateButtonAction();
    }


    public void dataEditProhibition() {
        new AlertHelper(Alert.AlertType.ERROR, "ACCESS_DENIED", ClientSide.languageResource.
                getString("alert.dataEditErrorMessage")).show();
        shortysTable.refresh();
    }

    private String colorByID(int ID) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            byte[] hash = mDigest.digest(Integer.toString(ID).getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            return hex.toString().substring(0, 6);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "#babbbc";
        }
    }

    @FXML
    @Override
    public boolean dataIsEntered() {
        if (nameField.getText().isEmpty() || xCoordField.getText().isEmpty() || yCoordField.getText().isEmpty()) {
            new AlertHelper(Alert.AlertType.ERROR, "ERROR", ClientSide.languageResource.getString("alert.dataInputErrorMessage")).show();
            return false;
        } else return true;
    }
}