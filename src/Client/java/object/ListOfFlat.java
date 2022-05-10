package object;

import java.io.Serializable;
import java.util.ArrayList;

public class ListOfFlat implements Serializable {
    private ArrayList<Flat> list;

    public ListOfFlat() {
        this.list = new ArrayList<>();
    }

    public void addFlat(Flat flat){
        this.list.add(flat);
    }

    public ArrayList<Flat> getList() {
        return list;
    }
}
