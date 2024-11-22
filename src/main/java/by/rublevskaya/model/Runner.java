package main.java.by.rublevskaya.model;

import main.java.by.rublevskaya.model.service.FileProcessor;

import java.nio.file.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file:");
        String inputFilePath = scanner.nextLine();
        Path inputPath = Paths.get(inputFilePath);

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFile(inputPath);
        scanner.close();
    }
}