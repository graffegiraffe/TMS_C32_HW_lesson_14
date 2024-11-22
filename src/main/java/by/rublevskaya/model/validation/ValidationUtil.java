package main.java.by.rublevskaya.model.validation;

import java.util.regex.Pattern;

public class ValidationUtil {
    public static String validateDocumentNumber(String docNumber) {
        if (docNumber.length() != 15) {
            return "Invalid length";
        }

        if (!Pattern.matches("^[a-zA-Z0-9]+$", docNumber)) {
            return "Contains invalid characters";
        }

        if (!docNumber.startsWith("docnum") && !docNumber.startsWith("contract")) {
            return "Invalid prefix";
        }

        return null;
    }
}