package com.jatin.designpatterns.commanddesignpattern.command;

import com.jatin.designpatterns.commanddesignpattern.reciever.TextFile;

public class FileOpenOperation implements TextFileOperation {
    TextFile textFile;

    public FileOpenOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.openFile();
    }
}
