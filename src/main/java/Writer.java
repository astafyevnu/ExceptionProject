import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Writer {
    public static void writing(HashMap<String, String> data) throws IOException {
        String fileName = data.get("surname") + ".txt";
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.append(data.get("surname") + " " +
                    data.get("name") + " " +
                    data.get("patronymic") + " " +
                    data.get("date") + " " +
                    data.get("phone") + " " +
                    data.get("sex") + "\n");
        }

    }
}
