import java.time.LocalDateTime;
import java.util.List;

public class Validator {
    private static Validator instance;
    LocalDateTime lastPinChange = null;

    private Validator() {
        String pinChange = FileManager.getFileContent("pin_change.txt");
        if (pinChange != null) {
            lastPinChange = LocalDateTime.parse(pinChange);
        }
    }

     public static synchronized Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public boolean canGenerateNew() {
        if (lastPinChange == null) {
            return true;
        }

        LocalDateTime now = LocalDateTime.now();
        return lastPinChange.plusHours(1).isBefore(now);
    }

    public boolean saveGeneratedText(String content) {
        lastPinChange = LocalDateTime.now();

        boolean isPinChangeDateSaved = FileManager.saveToFile("pin_change.txt", lastPinChange.toString());
        boolean isHistorySaved = HistoryManager.saveEntry(content);

        return isHistorySaved && isPinChangeDateSaved;
    }

    public List<String> getHistory() {
        return HistoryManager.loadHistory();
    }
}
