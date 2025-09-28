import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String HISTORY_FILE = "history.ser";
    private static final int MAX_ENTRIES = 3;

    public static synchronized boolean saveEntry(String content) {
        try {
            List<String> history = loadHistory();
            history.add(0, content);

            if (history.size() > MAX_ENTRIES) {
                history = new ArrayList<>(history.subList(0, MAX_ENTRIES));
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(HISTORY_FILE))) {
                out.writeObject(history);
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static synchronized List<String> loadHistory() {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<String>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
