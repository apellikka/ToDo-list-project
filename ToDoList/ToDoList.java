import java.util.*;

public class ToDoList  {

  private ArrayList<toDo> toDoList;

  public ToDoList() {
    this.toDoList = new ArrayList<>();
  }

  public void addToDo(toDo toDo) {
    this.toDoList.add(toDo);
  }

  public void removeToDo(int toDo) {
    if (toDo > toDoList.size() || toDo < 1) {
      System.out.println("Incorrect number");
    }
    this.toDoList.remove(toDo - 1);
  }

  public void printToDoList() {
    //Printing the list with the most urgent tasks on top of the list
    Comparator<toDo> urgencyComparator = Comparator.comparing(toDo :: getUrgency);
    Collections.sort(toDoList, urgencyComparator.reversed());

    int i = 1;
    for (toDo item : toDoList) {
      System.out.println(i + ": " + item);
      i++;
    }
    }

  public ArrayList<toDo> getList() {
    return this.toDoList;
}
}
