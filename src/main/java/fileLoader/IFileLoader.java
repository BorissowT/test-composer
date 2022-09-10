package fileLoader;

import commands.IBaseTest;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IFileLoader {
    LinkedHashMap<String, Map<String, String>> read(String path);
}
