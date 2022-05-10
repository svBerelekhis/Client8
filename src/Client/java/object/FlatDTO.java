package object;

import java.io.Serializable;
import java.util.Date;
/**
 * Класс для переноса пользовательских данных
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public class FlatDTO implements Serializable {
    /** имя - строка, должна быть не пустой*/
    String name; //Поле не может быть null, Строка не может быть пустой
    /** координаты*/
    Coordinates coordinates; //Поле не может быть null
    /** area - должно быть больше 0*/
    Long area; //Поле может быть null, Значение поля должно быть больше 0
    /** количество комнат - long, должно быть больше 0*/
    Long numberOfRooms; //Значение поля должно быть больше 0
    /** furnish - значение выбирается из энума и не может быть пустым*/
    Furnish furnish; //Поле не может быть null
    /** view - значение выбирается из энума и не может быть пустым*/
    View view; //Поле не может быть null
    /** transport - значение выбирается из энума и может быть пустым*/
    Transport transport; //Поле может быть null
    /** дом - может быть null*/
    House house; //Поле может быть null
    /** дата создания*/
    Date creationDate;

    /**
     * Конструктор со всеми параметрами
     * @param name - имя
     * @param coordinates - координаты
     * @param creationDate - дата создания
     * @param area - area
     * @param numberOfRooms - количество комнат
     * @param furnish - furnish
     * @param view - view
     * @param house - дом
     * @param transport - транспорт
     */
    public FlatDTO(String name, Coordinates coordinates, Date creationDate, Long area, Long numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.creationDate = creationDate;
        this.transport = transport;
        this.house = house;
        this.area = area;
    }

    public String getName() {
        return name;
    }
}