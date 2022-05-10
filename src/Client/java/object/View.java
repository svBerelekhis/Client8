package object;

import java.io.Serializable;

/**
 * Энум, хранящий доступные значения View
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public enum View implements Serializable {
    PARK("PARK"),
    GOOD("GOOD"),
    TERRIBLE("TERRIBLE");


    private final String description;

    View(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

