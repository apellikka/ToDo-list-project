import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UI {

    private final Scanner reader;
    private final ToDoList list;

    public UI() {
        this.reader = new Scanner(System.in);
        this.list = new ToDoList();
    }

    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Current to-do's: ");
        list.loadFile("toDoList.ser");
        list.printToDoList();


        while (true) {
            System.out.println("");
            System.out.println("1: Add a to-do item.");
            System.out.println("2. Remove a to-do item.");
            System.out.println("3. Print a list of my to-do items.");
            System.out.println("4. Quit");
            System.out.print("Type the number of desired action: ");

            String input = reader.nextLine();

            if (input.equals("4")) {
                System.out.println("Save changes? Y/N?");
                String saveOrNot = reader.nextLine();
                if (saveOrNot.matches(("[yY]"))) {
                    list.saveFile("toDoList.ser");
                    System.out.println("Save successful!");
                }
                System.out.println("Quitting!");
                break;
            } else if (input.equals("1")) {
                System.out.println("What would you like to add?");
                String add = reader.nextLine();
                toDo item = new toDo(add);
                list.addToDo(item);
            } else if (input.equals("2")) {
                if (this.list.getList().isEmpty()) {
                    System.out.println("List is empty.");
                   continue;
                }
                System.out.println("");
                list.printToDoList();
                System.out.print("Type the index of the item you wish to remove: ");
                int remove = Integer.parseInt(reader.nextLine());
                list.removeToDo(remove);
            } else if (input.equals("3")) {
                System.out.println("");
                list.printToDoList();
            }
        }
    }
}

