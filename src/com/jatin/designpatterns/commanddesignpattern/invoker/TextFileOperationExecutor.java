package com.jatin.designpatterns.commanddesignpattern.invoker;

import com.jatin.designpatterns.commanddesignpattern.command.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {
    List<TextFileOperation> textFileOperationList = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation){
        textFileOperationList.add(textFileOperation);
        return textFileOperation.execute();
    }
}
