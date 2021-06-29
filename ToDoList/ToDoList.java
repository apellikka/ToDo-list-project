
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;


public class ToDoList implements Serializable {

    private ArrayList<toDo> toDoList;

    public ToDoList() {
        this.toDoList = new ArrayList<>();
    }

    public void addToDo(toDo toDo) {
        this.toDoList.add(toDo);
    }

    public void removeToDo(int toDo) {
        this.toDoList.remove(toDo - 1);
    }

    public void printToDoList() {
        if (toDoList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            int i = 1;
            for (toDo todo : toDoList) {
                System.out.println(i + ": " + todo);
                i++;
            }
        }
    }
    public ArrayList<toDo> getList() {
        return this.toDoList;
    }
}



