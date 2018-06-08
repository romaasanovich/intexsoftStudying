package com.intexsoft.bookservice.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {


    public String readFile(String path) throws IOException {
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scan = new Scanner(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scan.hasNextLine()) {
                stringBuilder.append(scan.nextLine());
            }
            return stringBuilder.toString();
        }
    }

    public File getFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return file;
        } else {
            throw new IOException();
        }
    }
}
