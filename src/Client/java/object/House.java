package object;

import java.io.Serializable;

/**
 * Класс, хранящий информацию о доме
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public class House implements Serializable {
    /** имя - строка, должна быть не пустой*/
    private String name; //Поле не может быть null
    /** год - int, должен быть не пустым, больше 0*/
    private int year; //Значение поля должно быть больше 0
    /** год - количество этажей, должен быть не пустым, больше 0*/
    private Integer numberOfFloors; //Значение поля должно быть больше 0

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - String, имя
     * @param year - int, год
     * @param numberOfFloors - Integer, количество этажей
     */
    public House(String name, int year, Integer numberOfFloors) {
        this.name = name;
        this.year = year;
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * геттер имени (нужен для серилизации)
     * @return String, имя
     */
    public String getName() {
        return name;
    }

    /**
     * геттер года (нужен для серилизации)
     * @return int, год
     */
    public int getYear() {
        return year;
    }

    /**
     * геттер количества этажей (нужен для серилизации)
     * @return Integer, количество этажей
     */
    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * конструктор без параметров (нужен для серилизации)
     */
    public House() {
    }

    /**
     * переопределение метода toString
     * @return String, строковое представления класса
     */
    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
