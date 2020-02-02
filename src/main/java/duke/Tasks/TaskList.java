package duke.Tasks;

import duke.Exceptions.DukeBadIndexException;
import duke.util.Ui;
import java.util.ArrayList;


/**
 * Represents task list that keeps track of tasks.
 */
public class TaskList {
    protected ArrayList<Task> list;

    /**
     * Constructor for empty TaskList.
     */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Constructor to instantiate TaskList with an array list of tasks.
     * @param list containing tasks.
     */
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public int numTasks() {
        return list.size();
    }

    /**
     * Method to get index of a task in the task list.
     * @param task to query index.
     * @return index of task.
     */
    public int getTaskIndex(Task task) {
        return getList().indexOf(task) + 1;
    }

    /**
     * Method to add a task to the task list.
     * @param task to be added to task list.
     */
    public void addTask(Task task) {
        getList().add(task);
        String toPrint = Ui.setBorder("ADDED : " + task + "\n" +
                "\tYou now have " + numTasks() + " item(s) on your list.");
        System.out.println(toPrint);
    }

    /**
     * Method to mark as task as done in the task list.
     * @param n index of task to be marked as done.
     * @throws DukeBadIndexException to handle indices that are out of range or negative.
     */
    public void setDone(int n) throws DukeBadIndexException {
        if (n > numTasks()) {
            throw new DukeBadIndexException(n);
        }
        getList().get(n - 1).setDone();
        String toPrint = Ui.setBorder("I've marked (" + n + ") as done!\n" +
                "\t(" + n + ") " + getList().get(n - 1));
        System.out.println(toPrint);
    }

    /**
     * Method to delete task from task list.
     * @param n index of task to be deleted from task list.
     * @throws DukeBadIndexException to handle indices that are out of range or negative.
     */
    public void deleteTask(int n) throws DukeBadIndexException {
        if (n > numTasks()) {
            throw new DukeBadIndexException(n);
        }
        Task t = getList().get(n -1);
        getList().remove(n - 1);
        String toPrint = Ui.setBorder("OK, I've removed the task:\n\t\t" + t + "\n"
                        + "\tYou now have " + (getList().size()) + " task(s) on your list.");
        System.out.println(toPrint);
    }


    /**
     * Method to convert task list into a string.
     * @return string containing comprehensive list of tasks in task list.
     */
    @Override
    public String toString() {
        String toPrint = "";
        if (numTasks() == 0) {
            toPrint = Ui.setBorder("You have nothing on your list.");
        } else {
            StringBuilder msg = new StringBuilder("Here is your list:\n");
            for (Task e : list) {
                msg.append("\t(").append(getTaskIndex(e)).append(") ").append(e.toString()).append("\n");
            }
            toPrint += Ui.setBorder(msg.toString());
        }
        return toPrint;
    }
}
