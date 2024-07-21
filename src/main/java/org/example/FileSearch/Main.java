package org.example.FileSearch;


import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Directory to search: ");
        String path = scanner.nextLine();

        System.out.println("Enter keyword to search for: ");
        String word = scanner.nextLine();

        SearchManager searchManager = new SearchManager(path,word);
        searchManager.startSearch();
        System.out.println("Please Check Log File For the results");
    }
}
