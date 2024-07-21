package org.example.FileSearch;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchManager {

    private String path;
    private String word;

    public SearchManager(String path,String word){
        this.path = path;
        this.word = word;
    }

    public void startSearch(){

        File directory = new File(path);
        if(!directory.isDirectory()){
            System.err.println("Invalid Directory path");
        }

        //list the files in the directory
        File[] files = directory.listFiles();
        if(files==null || files.length==0){
            System.err.println("No files found in the directory");
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (File file:files){
            if(file.isFile()){
                //runnable class we created in filesearcher file
                FileSearcher fileSearcher = new FileSearcher(file,word);
                executorService.submit(fileSearcher);
            }
        }
        executorService.shutdown();


    }
}
