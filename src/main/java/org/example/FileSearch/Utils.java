package org.example.FileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readFile(File file){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            //this checks the conditon every time loop runs
            while ((line=reader.readLine())!=null){
                lines.add(line);
            }
        }catch (IOException e){
            System.err.println("Error reading file: "+file.getPath());
        }

        return lines;
    }

    public static  void logResult(String result){
        try(FileWriter writer=new FileWriter("search_results.log",true)){
            writer.write(result+System.lineSeparator());

        }catch (IOException e){
            System.err.println("Error writing to log");
        }
    }

}
