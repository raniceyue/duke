package duke.Tasks;

import duke.Exceptions.DukeBadIndexException;
import duke.util.Ui;
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public int numTasks() {
        return list.size();
    }

    public int getTaskIndex(Task t) {
        return getList().indexOf(t) + 1;
    }

    public void addTask(Task t) {
        getList().add(t);
        String toPrint = Ui.setBorder("ADDED : " + t + "\n"
                + "\tYou now have " + numTasks() + " item(s) on your list.");
        System.out.println(toPrint);
    }

    public void setDone(int n) throws DukeBadIndexException {
        if (n > numTasks()) {
            throw new DukeBadIndexException(n);
        }
        getList().get(n - 1).setDone();
        String toPrint = Ui.setBorder("I've marked (" + n + ") as done!\n"
                + "\t(" + n + ") " + getList().get(n - 1));
        System.out.println(toPrint);
    }

    public void deleteTask(int n) throws DukeBadIndexException {
        if (n > numTasks()) {
            throw new DukeBadIndexException(n);
        }
        Task t = getList().get(n - 1);
        getList().remove(n - 1);
        String toPrint = Ui.setBorder("OK, I've removed the task:\n\t\t" + t + "\n"
                        + "\tYou now have " + (getList().size()) + " task(s) on your list.");
        System.out.println(toPrint);
    }


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
