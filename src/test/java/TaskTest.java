import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void doNotShouldMatchesSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void doNotShouldMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Масло");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchesMeetingTopic() {
        Meeting task = new Meeting(55, "Выкатка новой версии приложения", "Приложение Нетобанка", "Во вторник после обеда");

        boolean actual = task.matches("Выкатка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldMatchesMeetingProject() {
        Meeting task = new Meeting(55, "Выкатка новой версии приложения", "Приложение Нетобанка", "Во вторник после обеда");

        boolean actual = task.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void doNotShouldMatchesMeetingAndStart() {
        Meeting task = new Meeting(55, "Выкатка новой версии приложения", "Приложение Нетобанка", "Во вторник после обеда");

        boolean actual = task.matches("Вторник");

        Assertions.assertFalse(actual);
    }
}
