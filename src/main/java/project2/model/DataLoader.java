package project2.model;

import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface DataLoader {
    CharSequence getContent();

    void saveStream(Stream<String> stringStream);
}
