package by.sabrina.arraytask1.parser;

import by.sabrina.arraytask1.exception.ArrayTaskException;
import by.sabrina.arraytask1.parser.ArrayParser;
import by.sabrina.arraytask1.parser.impl.ArrayParserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserImplTest {

    private final ArrayParser parser = new ArrayParserImpl();

    @Test
    void shouldParseSupportedDelimiters() throws ArrayTaskException {
        assertArrayEquals(
                new int[]{1, 2, 3},
                parser.parse("1; 2; 3")
        );

        assertArrayEquals(
                new int[]{3, 4, 7},
                parser.parse("3 4 7")
        );
    }

    @Test
    void shouldThrowExceptionOnEmptyString() {
        assertThrows(ArrayTaskException.class, () -> parser.parse(""));
    }

    @Test
    void shouldThrowExceptionOnNullLine() {
        assertThrows(ArrayTaskException.class, () -> parser.parse(null));
    }
}