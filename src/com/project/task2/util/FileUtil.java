package com.project.task2.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    private FileUtil() {}

    public static List<List<Integer>> readFromFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("labyrinth.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return Arrays.stream(content.toString().split("\n")).map(row -> Arrays.stream(row.split(" ")).map(Integer::valueOf).toList()).toList();
    }
}
