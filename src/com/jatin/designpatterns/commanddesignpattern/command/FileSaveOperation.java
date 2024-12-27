package com.jatin.designpatterns.commanddesignpattern.command;

import com.jatin.designpatterns.commanddesignpattern.reciever.TextFile;

public class FileSaveOperation implements TextFileOperation {
    TextFile textFile;

    public FileSaveOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.saveFile();
    }
}
