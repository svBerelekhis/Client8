package object;

import java.io.Serializable;

/**
 * Энум, хранящий доступные значения Transport
 * @autor Svetlana Berelekhis
 * @version 1.0
 */

public enum Transport implements Serializable {
    FEW(3, "FEW"),
    NONE(0, "NONE"),
    LITTLE(1, "LITTLE"),
    ENOUGH(2, "ENOUGH");

    /** Int условное значение для сравнения*/
    private final int count;
    private final String description;

    /**
     * Конструктор - создание нового объекта
     * @param count - условное значение
     */
    Transport(int count, String description) {
        this.count = count;
        this.description = description;
    }

    /**
     * геттер условного значения
     * @return count - условное значение
     */
    public int getCount(){
        return this.count;
    }
    public String getDescription() {
        return description;
    }
}
