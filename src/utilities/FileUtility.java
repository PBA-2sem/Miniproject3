/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtility {

    public static String[] toStringArray(String path, String del) throws IOException {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split(del)))
                .filter(word -> !word.isEmpty())
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
    }
    
}
