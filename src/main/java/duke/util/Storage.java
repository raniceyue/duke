package duke.util;

import duke.exceptions.DukeBadPathException;
import duke.exceptions.DukeException;
import duke.exceptions.DukeWriteFailException;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.tasks.ToDo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static String home = System.getProperty("user.dir");
    protected Path projectRootPath;
    protected Path dataFilePath;

    public Storage(String filePath) {
        this.projectRootPath = Paths.get(home);
        this.dataFilePath = Paths.get(projectRootPath.toString(), "data", filePath);
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> list = new ArrayList<>();
        try {
            List<String> loadedData = Files.readAllLines(dataFilePath);
            for (String e : loadedData) {
                if (loadedData.isEmpty() || e.isBlank()) {
                    break;
                }
                list.add(Parser.parseFileLine(e));
            }
            return list;
        } catch (IOException e) {
            throw new DukeBadPathException(dataFilePath);
        }
    }

    public void write(TaskList taskList) throws DukeWriteFailException {
        StringBuilder toWrite = new StringBuilder();
        for (Task e : taskList.getList()) {
            if (e instanceof ToDo) {
                toWrite.append(e.toString()).append("\n");
            } else if (e instanceof Event) {
                toWrite.append(((Event) e).writeFormat()).append("\n");
            } else if (e instanceof Deadline) {
                toWrite.append(((Deadline) e).writeFormat()).append("\n");
            }
        }

        try {
            FileWriter fw = new FileWriter(dataFilePath.toFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toWrite.toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new DukeWriteFailException();
        }
    }

}
