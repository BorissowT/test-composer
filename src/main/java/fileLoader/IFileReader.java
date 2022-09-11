package fileLoader;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IFileReader {
    LinkedHashMap<String, Map<String, String>> read(String path);
}
