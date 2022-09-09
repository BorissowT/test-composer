package fileLoader;

import commands.IBaseTest;

public interface IFileLoader {
    IBaseTest read(String path);
}
