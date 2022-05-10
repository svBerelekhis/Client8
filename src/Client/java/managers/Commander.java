package managers;

import com.google.gson.Gson;
import javafx.stage.FileChooser;
import controllers.AlertHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;
import command.*;

import object.*;
import org.apache.commons.codec.digest.DigestUtils;
import clinetSide.ClientSide;

public class Commander {

    private static Commander instance;
    static private String user;
    private Gson parser = new Gson();
    private List<Flat> incomingList;
    private Stage mainWindow;

    public static Commander getInstance() {
        if (instance == null) {
            instance = new Commander();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        String newPass =  DigestUtils.md5Hex(password);
        Command command = new Command(CommandNames.AUTHORIZATION, email, newPass);
        try {
            if (!"NO".equals(((Request)requestToServer(command)).getRequest())) {
                this.user = email;
                this.mainWindow = new Stage();
                this.mainWindow.setTitle("Main window");
                this.mainWindow.setResizable(false);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("main_form.fxml"));
                loader.setResources(ResourceBundle.getBundle("Locale", Locale.getDefault()));
                this.mainWindow.setScene(new Scene(loader.load()));
                this.mainWindow.show();
                return true;
            } else new AlertHelper(Alert.AlertType.ERROR, "ERROR", ClientSide.languageResource.getString("alert.loginErrorMessage")).show();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void removeLast() {
        requestToServer(new Command(CommandNames.REMOVE_AT, 1));
    }

    public void clear() {
        new AlertHelper(Alert.AlertType.INFORMATION, "ANSWER", requestToServer(new Command(CommandNames.CLEAR)).toString()).show();
    }

    public void add(String name, Long x, Integer y, Long area, Long numberOfRooms, Furnish furnish, View view) {
        Coordinates coordinates = new Coordinates(x, y);
        Transport transport = Transport.LITTLE;
        House house = null;
        FlatDTO flatDTO = new FlatDTO(name,coordinates,new Date(), area,numberOfRooms,furnish, view,transport,house);
        Object answer = requestToServer(new Command(CommandNames.ADD, flatDTO));
        load();
    }

    public void addIfMin(String name, Long x, Integer y, Long area, Long numberOfRooms, Furnish furnish, View view) {
        Coordinates coordinates = new Coordinates(x, y);
        Transport transport = Transport.LITTLE;
        House house = null;;
        FlatDTO flatDTO = new FlatDTO(name,coordinates,new Date(), area,numberOfRooms,furnish, view,transport,house);
        Object answer = requestToServer(new Command(CommandNames.ADD_IF_MIN, flatDTO));
        load();
    }

    public void register(String login, String password) {
        String newPass =  DigestUtils.md5Hex(password);
        Command command = new Command(CommandNames.NEW_USER, login, newPass);
        requestToServer(command);
    }


    public List<Flat> load() {
        Object answer = requestToServer(new Command(CommandNames.SHOW));
        System.out.println(answer.toString());
        ListOfFlat lof = (ListOfFlat) answer;
        ArrayList<Flat> list = new ArrayList<>();
        for (Flat flat : lof.getList()){
            list.add(flat);
        }
        incomingList = list;

        return incomingList;
    }

    public void remove(Flat s) {
        System.out.println(s.getId());
        new AlertHelper(Alert.AlertType.INFORMATION, "ANSWER", requestToServer(new Command(CommandNames.REMOVE_BY_ID, s.getId())).toString()).show();
    }

    public void save() {
        requestToServer(new Command(CommandNames.EXIT));
        load();
    }

    private Object requestToServer(Serializable request) {
        try (Socket outcoming = new Socket(InetAddress.getLocalHost(), 8080)) {
            outcoming.setSoTimeout(2500);
            try (ObjectOutputStream toServer = new ObjectOutputStream(outcoming.getOutputStream());
                 ObjectInputStream fromServer = new ObjectInputStream(outcoming.getInputStream())) {
                toServer.writeObject(request);
                Object o = fromServer.readObject();
                System.out.println(o.getClass());
                return o;
            }
        } catch (IOException | ClassNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }


    public String getUser() {
        return user;
    }
}