package command;

import object.FlatDTO;
import object.Transport;
import object.User;

import java.io.File;
import java.io.Serializable;

public class Command implements Serializable {
    private CommandNames commandName;
    private long id;
    private FlatDTO flatDTO;
    private int i;
    private Transport transport;
    private File file;
    private String user;
    private String str;
    private String pass;


    public Command(CommandNames commandName) {
        this.commandName = commandName;
    }

    public Command(CommandNames commandName, FlatDTO flatDTO) {
        this.commandName = commandName;
        this.flatDTO = flatDTO;
    }

    public Command(CommandNames commandName, long id) {
        this.commandName = commandName;
        this.id = id;
    }
    public Command(CommandNames commandName, String user, String pass){
        this.commandName = commandName;
        this.user = user;
        this.pass = pass;
    }

    public Command(CommandNames commandName, int i) {
        this.commandName = commandName;
        this.i = i;
    }

    public Command(CommandNames commandName, long id, FlatDTO flatDTO) {
        this.commandName = commandName;
        this.id = id;
        this.flatDTO = flatDTO;
    }

    public Command(CommandNames commandName, Transport transport) {
        this.commandName = commandName;
        this.transport = transport;
    }

    public Command(CommandNames commandName, File file) {
        this.commandName = commandName;
        this.file = file;
    }
    public Command(CommandNames commandName, String str){
        this.commandName = commandName;
        this.str = str;
        this.pass = str;
    }

    public CommandNames getCommandName() {
        return commandName;
    }

    public long getId() {
        return id;
    }

    public FlatDTO getFlatDTO() {
        return flatDTO;
    }

    public int getI() {
        return i;
    }

    public Transport getTransport() {
        return transport;
    }

    public String getUser() {
        return user;
    }
    public String getPass(){
        return this.pass;
    }

    public String getStr() {
        return str;
    }

    public File getFile() {
        return file;
    }
}
