import java.io.*;
import java.util.*;

public class UI {

    private final Scanner reader;
    private ToDoList list;

    public UI() {
        this.reader = new Scanner(System.in);
        this.list = new ToDoList();
    }

    public void start() throws IOException, ClassNotFoundException {


        System.out.println("Current to-do's: ");
        loadFile("toDoList.ser");
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
                    saveFile("toDoList.ser");
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
    public void saveFile(String file) {
        try {
            FileOutputStream fos = new FileOutputStream("toDoList.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.list);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile(String file){
        try {
            FileInputStream fis = new FileInputStream("toDoList.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ToDoList) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

