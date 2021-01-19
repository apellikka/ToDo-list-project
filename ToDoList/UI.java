
import java.util.*;

public class UI {

  private Scanner reader;
  private ToDoList list;

  public UI() {
    this.reader = new Scanner(System.in);
    this.list = new ToDoList();
  }

  public void start() {

    while (true) {
      System.out.println("");
      System.out.println("1: Add a to-do item.");
      System.out.println("2. Remove a to-do item.");
      System.out.println("3. Print a list of my to-do items.");
      System.out.println("4. Quit");
      System.out.print("Type the number of desired action: ");

      String input = reader.nextLine();

      if (input.equals("4")) {
        System.out.println("Quitting!");
        break;
      }

      else if (input.equals("1")) {
        System.out.println("What would you like to add?");
        String add = reader.nextLine();
        toDo item = new toDo(add);
        System.out.println("Is this task urgent? Y/N?");
        String urgency = reader.nextLine();
        //Setting urgency for the task in order to have it on top of the list.
            if (urgency.equals("y") || urgency.equals("Y")) {
                item.setUrgency(true);
        }
        list.addToDo(item);
  }

    else if (input.equals("2")) {
      list.printToDoList();
      System.out.print("Type the index of the item you wish to remove: ");
      int remove = Integer.valueOf(reader.nextLine());
      list.removeToDo(remove);
    }

    else if(input.equals("3")) {
      System.out.println("");
      list.printToDoList();
    }
  }
}
}
