import java.util.ArrayList;
import java.util.List;

public class Journal {
    List<String> logs = new ArrayList<>();

    public void log(String entry) {
        logs.add(entry);
    }

    public String getLog() {
        if (logs.isEmpty()) return "Nenhum log registrado.";
        return String.join("\n", logs);
    }
}
