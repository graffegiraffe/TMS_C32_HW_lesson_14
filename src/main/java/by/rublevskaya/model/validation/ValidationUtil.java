package main.java.by.rublevskaya.model.validation;
import main.java.by.rublevskaya.model.exception.InvalidDocumentException;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static void validateDocumentNumber(String docNumber) throws InvalidDocumentException {
        if (docNumber.length() != 15) {
            throw new InvalidDocumentException("Invalid length");
        }

        if (!Pattern.matches("^[a-zA-Z0-9]+$", docNumber)) {
            throw new InvalidDocumentException("Contains invalid characters");
        }

        if (!docNumber.startsWith("docnum") && !docNumber.startsWith("contract")) {
            throw new InvalidDocumentException("Invalid prefix");
        }
    }
}