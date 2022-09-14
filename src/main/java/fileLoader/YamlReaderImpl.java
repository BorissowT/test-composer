package fileLoader;


import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlReaderImpl implements IFileReader {
    @Override
    public LinkedHashMap<String, Map<String, Object>> read(String path) {
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Yaml yaml = new Yaml();
        LinkedHashMap<String, Map<String, Object>> data = yaml.load(inputStream);
        return data;
    }
}
