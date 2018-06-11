package com.intexsoft.bookservice.importer.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {


    public String readFile(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scan = new Scanner(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scan.hasNextLine()) {
                stringBuilder.append(scan.nextLine());
            }
            return stringBuilder.toString();
        }
    }
}
