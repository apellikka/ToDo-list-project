import org.testng.annotations.Test;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ToDoListTest {
    @Test
    public void addToDo(){
        ToDoList todolist = new ToDoList();
        toDo todo = new toDo("Test");
        todolist.addToDo(todo);
        assertTrue(todolist.getList().contains(todo));
    }
    @Test
    public void removeToDo() {
        ToDoList todolist = new ToDoList();
        toDo todo = new toDo("Test");
        todolist.addToDo(todo);
        todolist.removeToDo(1);
        assertFalse(todolist.getList().contains(todo));
    }
    @Test
    public void listIsEmptyWhenCreated() {
        ToDoList todolist = new ToDoList();
        assertTrue(todolist.getList().isEmpty());
    }

    @Test
    public void getList() {
        ToDoList todolist = new ToDoList();
        ArrayList<toDo> list = new ArrayList<>();
        assertEquals(list, todolist.getList());
    }

    @Test
    public void printToDoList() {
        ToDoList todolist = new ToDoList();
        toDo todo = new toDo("Test");
        todolist.addToDo(todo);
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        todolist.printToDoList();
        System.setOut(oldOut);
        String output = baos.toString();
        assertTrue(output.contains("1: Test"));
    }

    @Test
    public void printEmptyToDoList() {
        ToDoList todolist = new ToDoList();
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        todolist.printToDoList();
        System.setOut(oldOut);
        String output = baos.toString();
        assertTrue(output.contains("List is empty."));
    }
}
