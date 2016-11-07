package trywithresources;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ssselim on 9/17/16.
 */
public class Helper {
    static public Reader openReader(String fileName) throws IOException {
      return Files.newBufferedReader(Paths.get(fileName));
    }

    static public Writer openWriter(String fileName) throws IOException {
      return Files.newBufferedWriter(Paths.get(fileName));
    }
}
