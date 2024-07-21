package org.example.FileSearch;

import java.io.File;
import java.util.List;

public class FileSearcher implements Runnable {

    private File path;
    private String word;

    public FileSearcher(File path,String word){
        this.path =path;
        this.word =word;
    }


    @Override
    public void run() {
        //read the file you received from searchmanager
        List<String> lines = Utils.readFile(path);
        if(lines!=null){
            int lineNumber =1;
            for (String line:lines){
                if(line.contains(word)){
                    String result = "Found in the file: "+path.getPath()+" at line "+lineNumber;
                    Utils.logResult(result);
                }
                lineNumber++;
            }
        }


    }
}
