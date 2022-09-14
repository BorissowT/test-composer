package fileLoader;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IFileReader {
    LinkedHashMap<String, Map<String, Object>> read(String path);
}
