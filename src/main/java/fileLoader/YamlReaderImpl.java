package fileLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import commands.BaseTestImpl;
import commands.IBaseTest;

import java.io.File;
import java.io.IOException;

public class YamlReaderImpl implements IFileLoader{
    @Override
    public IBaseTest read(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        BaseTestImpl FileObject = null;
        try {
            FileObject = mapper.readValue(new File(path), BaseTestImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileObject;
    }
}
