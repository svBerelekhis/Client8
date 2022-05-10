package object;

import java.io.Serializable;

/**
 * Энум, хранящий доступные значения Furnish
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public enum Furnish implements Serializable {
    DESIGNER("DESIGNER"),
    FINE("FINE"),
    BAD("BAD"),
    LITTLE("LITTLE");

    private final String description;

    Furnish(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static String value(String s){
        if (s.equals("DESIGNER")){
            return Furnish.DESIGNER.getDescription();
        }else if (s.equals("FINE")){
            return Furnish.FINE.getDescription();
        }else if (s.equals("BAD")){
            return Furnish.BAD.getDescription();
        }else return Furnish.LITTLE.getDescription();
    }
}

