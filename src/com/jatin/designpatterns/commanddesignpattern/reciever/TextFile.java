package com.jatin.designpatterns.commanddesignpattern.reciever;

public class TextFile {
    public String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String openFile(){
        return "open file"+this.fileName;
    }

    public String saveFile(){
        return "save file"+this.fileName;
    }
}
