package com.jatin.designpatterns.commanddesignpattern;

import com.jatin.designpatterns.commanddesignpattern.command.FileOpenOperation;
import com.jatin.designpatterns.commanddesignpattern.command.FileSaveOperation;
import com.jatin.designpatterns.commanddesignpattern.invoker.TextFileOperationExecutor;
import com.jatin.designpatterns.commanddesignpattern.reciever.TextFile;

public class CommandDesignPatternClient {

    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        TextFile textFile = new TextFile("tempFile");
        String fileOperation = textFileOperationExecutor.executeOperation(new FileOpenOperation(textFile));
        System.out.println("file operation :"+fileOperation);
        fileOperation = textFileOperationExecutor.executeOperation(new FileSaveOperation(textFile));
        System.out.println("file operation :"+fileOperation);
    }
}
