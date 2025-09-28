import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static boolean saveToFile(String fileName, String content) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, content.getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String getFileContent(String fileName) {
        Path path = Paths.get(fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return null;
        }
    }
}
