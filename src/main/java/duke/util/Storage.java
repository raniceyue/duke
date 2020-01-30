package duke.util;

import duke.Exceptions.DukeBadPathException;
import duke.Exceptions.DukeException;
import duke.Exceptions.DukeWriteFailException;
import duke.Tasks.*;

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
    protected Path project_root;
    protected Path data_path;

    public Storage(String filePath) {
        this.project_root = Paths.get(home);
        this.data_path = Paths.get(project_root.toString(), "data", filePath);
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> list = new ArrayList<>();
        try {
            List<String> loaded_data = Files.readAllLines(data_path);
            for (String e : loaded_data) {
                if (loaded_data.isEmpty() || e.isBlank()) {
                    break;
                }
                list.add(Parser.parseFileLine(e));
            }
            return list;
        } catch (IOException e) {
            throw new DukeBadPathException(data_path);
        }
    }

    public void write(TaskList taskList) throws DukeWriteFailException {
        StringBuilder toWrite = new StringBuilder();
        for (Task e : taskList.getList()) {
            if (e instanceof ToDo) {
                toWrite.append(e.toString()).append("\n");
            } else if (e instanceof Event) {
                toWrite.append(((Event) e).WriteFormat()).append("\n");
            } else if (e instanceof Deadline) {
                toWrite.append(((Deadline) e).WriteFormat()).append("\n");
            }
        }

        try {
            FileWriter fw = new FileWriter(data_path.toFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toWrite.toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new DukeWriteFailException();
        }
    }

}
