
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;


public class ToDoList {

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

    public void saveFile(String file) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream("toDoList.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.toDoList);
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

                ArrayList<toDo> toDoList2 = (ArrayList<toDo>) ois.readObject();
                ois.close();
                toDoList = toDoList2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



