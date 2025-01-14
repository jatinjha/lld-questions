package com.jatin.filesystem.factory;

import com.jatin.filesystem.Directory;
import com.jatin.filesystem.File;
import com.jatin.filesystem.FileSystemEntity;

public class FileSystemEntityFactory {
    public static File getFile(String name){
        return new File(name);
    }

    public static Directory getDirectory(String name){
        return new Directory(name);
    }
}
