package object;

import java.io.Serializable;
import java.util.Date;
/**
 * Класс квартира
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public class Flat implements Comparable<Flat>, Serializable {
    /** id - int, задаётся автоматически с помощью рандома*/
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /** имя - строка, должна быть не пустой*/
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** координаты*/
    private Coordinates coordinates; //Поле не может быть null
    /** дата создания*/
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /** area - должно быть больше 0*/
    private Long area; //Поле может быть null, Значение поля должно быть больше 0
    /** количество комнат - long, должно быть больше 0*/
    private Long numberOfRooms; //Значение поля должно быть больше 0
    /** furnish - значение выбирается из энума и не может быть пустым*/
    private Furnish furnish; //Поле не может быть null
    /** view - значение выбирается из энума и не может быть пустым*/
    private View view; //Поле не может быть null
    /** transport - значение выбирается из энума и может быть пустым*/
    private Transport transport; //Поле может быть null
    /** дом - может быть null*/
    private House house; //Поле может быть null
    private String masterName;

    /**
     * геттер для количества комнат
     * @return long, количество комнат
     */
    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * геттер для транспорта
     * @return transport, транспорт
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * геттер имени
     * @return String, name
     */
    public String getName() {
        return name;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - long, сгенерированное id
     * @param creationDate - дата создания
     */
    public Flat(long id, Date creationDate, String masterName) {
        this.id = id;
        this.creationDate = creationDate;
        this.masterName = masterName;

    }
    /**
     * Конструктор без параметров (нужен для сериализации)
     */
    public Flat() {
    }

    /**
     * Конструктор со всеми параметрами (нужен для сериализации)
     */
    public Flat(long id, String name, Coordinates coordinates, Date creationDate, Long area, Long numberOfRooms, Furnish furnish, View view, Transport transport, House house, String masterName) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.transport = transport;
        this.house = house;
        this.masterName = masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterName() {
        return masterName;
    }

    /**
     * Функция для получения данных из FlatDTO
     * @param flatDTO - объект с данными
     */
    public void fromDTO(FlatDTO flatDTO){
        this.name = flatDTO.name;
        this.coordinates = flatDTO.coordinates;
        this.area = flatDTO.area;
        this.numberOfRooms = flatDTO.numberOfRooms;
        this.furnish = flatDTO.furnish;
        this.view = flatDTO.view;
        this.transport = flatDTO.transport;
        this.house = flatDTO.house;
    }

    /**
     * переопределение метода toString
     * @return класс в стоковом представлении
     */
    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", furnish=" + furnish +
                ", view=" + view +
                ", transport=" + transport +
                ", house=" + house +
                '}';
    }

    /**
     * геттер id
     * @return long, id
     */
    public long getId() {
        return id;
    }

    /**
     * переопределение метода compareTo
     * @param o - Flat, объект с которым сравниваем
     */
    @Override
    public int compareTo(Flat o) {
        return this.name.length() - o.name.length();
    }

    /**
     * геттер координат (нужен для серилизации)
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * геттер даты (нужен для серилизации)
     * @return Date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * геттер area (нужен для серилизации)
     * @return long
     */
    public Long getArea() {
        return area;
    }

    /**
     * геттер furnish (нужен для серилизации)
     * @return Furnish
     */
    public Furnish getFurnish() {
        return furnish;
    }

    /**
     * геттер view (нужен для серилизации)
     * @return View
     */
    public View getView() {
        return view;
    }

    /**
     * геттер дома (нужен для серилизации)
     * @return House
     */
    public House getHouse() {
        return house;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public void setNumberOfRooms(Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setFurnish(String S) {
        this.furnish = Furnish.valueOf(S);
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    public void setX(Long x){
        Integer y = this.coordinates.getY();
        Coordinates coordinates = new Coordinates(x, y);
        this.coordinates = coordinates;
    }
    public void setY(Integer y){
        Long x = this.coordinates.getX();
        Coordinates coordinates = new Coordinates(x, y);
        this.coordinates = coordinates;

    }

    public String toDBSaveForm() {
        if (this.house == null){
            String start = "(name, coordinates_x, coordinates_y, birthDate, area, numberOfRooms, furnish, view, transport, masterName) VALUES (";
            String res = "\'" + this.name + "\', " + coordinates.getX() + ", " + coordinates.getY() + ", \'" + creationDate.toString() + "\' ,"+
            this.area + ", " + this.numberOfRooms + ", \'" + this.furnish.getDescription() + "\' , \'" + this.view.getDescription() + "\', \'" + this.transport + "\', \'" + this.masterName + "\')";
            return start + res;
        }else {
            String start = "(name, coordinates_x, coordinates_y, birthDate, area, numberOfRooms, furnish, view, transport, masterName, house_name, house_year, house_numberOfFloors) VALUES (";
            String res = "\'" + this.name + "\', " + coordinates.getX() + ", " + coordinates.getY() + ", \'" + creationDate.toString() + "\' ,"+
                    this.area + ", " + this.numberOfRooms + ", \'" + this.furnish.getDescription() + "\' , \'" + this.view.getDescription() + "\', \'" + this.transport + "\', \'" + this.masterName + "\', \'" +
                    this.house.getName() + "\', " + this.house.getYear() + ", " + this.house.getNumberOfFloors() + ")";
            return start + res;
        }
    }

    public String toDBUpdateFrom() {
        if (this.house == null){
            String start = "(name, coordinates_x, coordinates_y, birthDate, area, numberOfRooms, furnish, view, transport, masterName) VALUES (";
            String res = "\'" + this.name + "\', " + coordinates.getX() + ", " + coordinates.getY() + ", \'" + creationDate.toString() + "\' ,"+
                    this.area + ", " + this.numberOfRooms + ", \'" + this.furnish.getDescription() + "\' , \'" + this.view.getDescription() + "\', \'" + this.transport + "\', \'" + this.masterName + "\')";
            return start + res;
        }else {
            String start = "(name, coordinates_x, coordinates_y, birthDate, area, numberOfRooms, furnish, view, transport, masterName, house_name, house_year, house_numberOfFloors) VALUES (";
            String res = "\'" + this.name + "\', " + coordinates.getX() + ", " + coordinates.getY() + ", \'" + creationDate.toString() + "\' ,"+
                    this.area + ", " + this.numberOfRooms + ", \'" + this.furnish.getDescription() + "\' , \'" + this.view.getDescription() + "\', \'" + this.transport + "\', \'" + this.masterName + "\', \'" +
                    this.house.getName() + "\', " + this.house.getYear() + ", " + this.house.getNumberOfFloors() + ")";
            return start + res;
        }
    }
}