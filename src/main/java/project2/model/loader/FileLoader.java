package project2.model.loader;

import project2.model.DataLoader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class FileLoader implements DataLoader {
    private String fileSource;
    private String fileDest;

    public FileLoader(String fileSource,String fileDestination) {
        this.fileDest = fileDestination;
        this.fileSource = fileSource;
    }

    public void saveStream(Stream<String> stringStream) {
        try {
            List<String> list = stringStream.collect(Collectors.toList());
            Files.write(Paths.get(fileDest),list , StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CharSequence getContent() {
        Stream<String> s = null;
        try {
            s = Files.lines(Paths.get(fileSource), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        s.forEach(stringBuilder::append);
        return stringBuilder;
    }
}
