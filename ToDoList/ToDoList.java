import java.util.ArrayList;
import java.util.

public class ToDoList {

  private ArrayList<toDo> toDoList;

  public ToDoList() {
    this.toDoList = new ArrayList<>();
  }

  public void addToDo(toDo toDo) {
    this.toDoList.add(toDo);
  }

  public void removeToDo(int toDo) {
    if (toDo > toDoList.size() || toDo < 1) {
      System.out.println("Incorrect number.");
    }
    this.toDoList.remove(toDo - 1);
  }

  public void printToDoList() {
    int i = 1;
    for (toDo task : toDoList) {
      System.out.println(i + ": " + task);
    }
  }



}
