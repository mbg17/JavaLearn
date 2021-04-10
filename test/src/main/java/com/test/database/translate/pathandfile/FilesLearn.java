package com.test.database.translate.pathandfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesLearn {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\JAVA\\untitled\\src\\main\\java\\com\\leetcode\\translate\\outandinputstream");
        Stream<Path> walk = Files.walk(path);
        walk.forEach(p -> {
            try {
                if(Files.isRegularFile(p)) {
                    Files.copy(Paths.get("D:\\JAVA\\untitled\\src\\main\\java\\com\\leetcode\\translate\\outandinputstream\\"
                            + p.getFileName()), Paths.get("D:\\JAVA\\untitled\\src\\main\\resources\\copy\\" + p.getFileName()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
