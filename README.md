
# File Search Application

## Overview
This File Search Application is a Java-based tool that allows users to search for a specific keyword within all files in a given directory. The application utilizes multi-threading to perform concurrent searches, improving efficiency for large directories.

## Project Structure

The project consists of four main classes:

1. FileSearchApp
2. SearchManager
3. FileSearcher
4. Utils

### 1. FileSearchApp

This is the main class that serves as the entry point for the application.

#### Main method
- Handles user input for the directory path and keyword.
- Initializes the SearchManager with the provided inputs.
- Starts the search process.

### 2. SearchManager

This class manages the overall search operation.

#### Constructor
- Initializes the directory path and keyword to search for.

#### startSearch method
- Validates the provided directory path.
- Lists all files in the directory.
- Creates a thread pool using ExecutorService.
- Submits FileSearcher tasks for each file in the directory.
- Shuts down the ExecutorService after all tasks are submitted.

### 3. FileSearcher

This class implements the Runnable interface and performs the actual file searching.

#### Constructor
- Initializes the file to search and the keyword to look for.

#### run method
- Reads the file content using Utils.readFile().
- Searches each line for the keyword.
- If the keyword is found, it logs the result using Utils.logResult().

### 4. Utils

This utility class provides helper methods for file operations and logging.

#### readFile method
- Takes a File object as input.
- Reads the content of the file line by line.
- Returns a List<String> containing all lines from the file.
- Handles IOException and returns null if an error occurs.

#### logResult method
- Takes a result string as input.
- Appends the result to a log file named "search_results.log".
- Handles IOException and prints an error message if writing to the log file fails.

## How It Works

1. The user is prompted to enter a directory path and a keyword to search for.
2. The SearchManager validates the directory and retrieves all files within it.
3. A thread pool is created to manage concurrent file searches.
4. For each file in the directory, a FileSearcher task is created and submitted to the thread pool.
5. Each FileSearcher reads its assigned file, searches for the keyword, and logs any matches.
6. Results are written to a log file ("search_results.log") as they are found.
7. The application continues until all files have been searched.

## Concurrency

The application uses Java's ExecutorService to create a fixed-size thread pool (default size: 10). This allows multiple files to be searched concurrently, significantly improving performance for directories with many files.

## Error Handling

- The application checks for invalid directory paths and empty directories.
- File reading errors are caught and reported.
- Logging errors are caught and reported.

## Logging

Search results are logged to a file named "search_results.log". Each log entry includes the file path and the line number where the keyword was found.

## Scalability

The application is designed to handle large directories efficiently due to its concurrent nature. The thread pool size can be adjusted in the SearchManager class to optimize performance based on the system's capabilities.

## Future Improvements

- Create a graphical user interface for easier interaction using SpringBoot.
