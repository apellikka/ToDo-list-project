
import java.util.*;
import java.io.*;

public class toDo implements Serializable {

    private String name;

    public toDo(String name) {
        this.name = name;
    }

    public void setName(String setName) {
        this.name = setName;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
