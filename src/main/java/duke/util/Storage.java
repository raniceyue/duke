package duke.util;

import duke.Exceptions.DukeException;
import duke.Tasks.*;
import duke.util.Parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
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

    public ArrayList<Task> load() throws DukeException, IOException {
        ArrayList<Task> list = new ArrayList<>();
        List<String> loaded_data = Files.readAllLines(data_path);
            for (String e : loaded_data) {
                if (loaded_data.isEmpty() || e.isBlank()) {
                    break;
                }
                list.add(Parser.parseFileLine(e));
            }
        return list;
    }

    public void write(TaskList taskList) throws IOException {
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

        FileWriter fw = new FileWriter(data_path.toFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toWrite.toString());
        bw.close();
        fw.close();
    }

}
