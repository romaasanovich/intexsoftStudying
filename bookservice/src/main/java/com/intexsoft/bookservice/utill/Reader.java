package com.intexsoft.bookservice.utill;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {


    public String readFile(String path) throws IOException {
        String result = "";
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result += scan.nextLine();
            }
            return result;
        }
    }
}
