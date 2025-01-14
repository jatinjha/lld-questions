package com.jatin.filesystem;

import com.jatin.filesystem.factory.FileSystemEntityFactory;

public class FileSystemDriver {
    public static void main(String[] args) {
        File txtFile = FileSystemEntityFactory.getFile("tempFile");
        File movieFile = FileSystemEntityFactory.getFile("movieFile");
        File songFile = FileSystemEntityFactory.getFile("songFile");
        Directory  songDirectory = FileSystemEntityFactory.getDirectory("songs");
        File codeFile = FileSystemEntityFactory.getFile("codeFile");
        Directory entertainmentDirectory = FileSystemEntityFactory.getDirectory("entertainment");
        Directory workspaceDirectory = FileSystemEntityFactory.getDirectory("workspace");

        Directory rootDirectory = FileSystemEntityFactory.getDirectory("root");

        workspaceDirectory.addEntity(codeFile);
        workspaceDirectory.addEntity(txtFile);
        songDirectory.addEntity(songFile);
        entertainmentDirectory.addEntity(movieFile);
        entertainmentDirectory.addEntity(songDirectory);
        rootDirectory.addEntity(entertainmentDirectory);
        rootDirectory.addEntity(workspaceDirectory);

        rootDirectory.ls();
    }
}
