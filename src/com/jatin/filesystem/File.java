package com.jatin.filesystem;

public class File implements FileSystemEntity{
    private String fileName;

    public File(String fileName){
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ls() {
        System.out.println("file name :"+this.fileName);
    }
}
