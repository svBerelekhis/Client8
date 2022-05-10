package object;

import java.io.Serializable;

/**
 * Класс координаты
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public class Coordinates implements Serializable {
    /** Первая координата*/
    private Long x; //Поле не может быть null

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /**Вторая коодрината*/
    private Integer y; //Максимальное значение поля: 942, Поле не может быть null

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param x - первая координата
     * @param y - вторая координата
     */
    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * переопределение метода toString
     * @return класс в стоковом представлении
     */
    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }

    /**
     * геттер для первой координаты (нужен для сериализации)
     * @return первую координату
     */
    public Long getX() {
        return x;
    }

    /**
     * геттер для второй координаты (нужен для сериализации)
     * @return вторую координату
     */
    public Integer getY() {
        return y;
    }

    /**
     * Конструктор без параметров (нужен для сериализации)
     */
    public Coordinates() {
    }
}
