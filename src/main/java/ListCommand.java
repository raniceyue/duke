public class ListCommand extends Command {

    public ListCommand() {

    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        System.out.println(taskList.toString());
    }
}
