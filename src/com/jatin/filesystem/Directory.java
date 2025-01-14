package com.jatin.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemEntity{
    private String directoryName;
    List<FileSystemEntity> fileSystemEntityList;

    public Directory(String directoryName){
        this.directoryName = directoryName;
        fileSystemEntityList = new ArrayList<>();
    }

    public void addEntity(FileSystemEntity fileSystemEntity){
        fileSystemEntityList.add(fileSystemEntity);
    }

    @Override
    public void ls() {
        System.out.println("directory name "+directoryName);
        fileSystemEntityList.forEach(FileSystemEntity::ls);
    }
}
