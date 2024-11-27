package main.java.by.rublevskaya.model.service;

import main.java.by.rublevskaya.model.exception.InvalidDocumentException;
import main.java.by.rublevskaya.model.validation.ValidationUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    public void processFile(Path inputPath) {
        Path parentDir = inputPath.getParent();
        Path docnumReportPath = resolvePath(parentDir, "valid_docnums.txt");
        Path contractReportPath = resolvePath(parentDir, "valid_contracts.txt");
        Path invalidReportPath = resolvePath(parentDir, "invalid_docs.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter docnumWriter = Files.newBufferedWriter(docnumReportPath);
             BufferedWriter contractWriter = Files.newBufferedWriter(contractReportPath);
             BufferedWriter invalidWriter = Files.newBufferedWriter(invalidReportPath)) {

            processLines(reader, docnumWriter, contractWriter, invalidWriter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path resolvePath(Path parentDir, String fileName) {
        return parentDir.resolve(fileName);
    }

    private void processLines(BufferedReader reader, BufferedWriter docnumWriter, BufferedWriter contractWriter, BufferedWriter invalidWriter) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                ValidationUtil.validateDocumentNumber(line);
                writeLine(line, docnumWriter, contractWriter);
            } catch (InvalidDocumentException e) {
                invalidWriter.write(line + " ---- " + e.getMessage());
                invalidWriter.newLine();
            }
        }
    }

    private void writeLine(String line, BufferedWriter docnumWriter, BufferedWriter contractWriter) throws IOException {
        if (line.startsWith("docnum")) {
            docnumWriter.write(line);
            docnumWriter.newLine();
        } else if (line.startsWith("contract")) {
            contractWriter.write(line);
            contractWriter.newLine();
        }
    }
}