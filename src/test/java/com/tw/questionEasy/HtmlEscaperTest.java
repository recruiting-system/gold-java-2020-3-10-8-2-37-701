package com.tw.questionEasy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HtmlEscaperTest {
    private static Object[][] createEscapingCases() {
        return new Object[][] {
            new Object[] { "\"test\"", "&quot;test&quot;" },
            new Object[] {"'test'", "&#39;test&#39;" },
            new Object[] {"test & test & test", "test &amp; test &amp; test"},
            new Object[] {"test << 1", "test &lt;&lt; 1"},
            new Object[] {"test >> 1", "test &gt;&gt; 1"},
            new Object[] {"<tab>", "&lt;tab&gt;"}
        };
    }

    private static Object[][] createComplicatedCases() {
        return new Object[][] {
            new Object[] {"foo&bar", "foo&amp;bar"},
            new Object[] {"a\"b<c>d&", "a&quot;b&lt;c&gt;d&amp;"},
            new Object[] {"foo&&bar", "foo&amp;&amp;bar"}
        };
    }

    @Test
    void should_not_escape_string_which_does_not_contains_characters_to_escape() {
        assertEquals("xxx", HtmlEscaper.escape("xxx"));
    }

    @ParameterizedTest
    @MethodSource("createEscapingCases")
    void should_escape_characters_defined_in_html_4_simple_cases(String text, String expected) {
        assertEquals(expected, HtmlEscaper.escape(text));
    }

    @ParameterizedTest
    @MethodSource("createComplicatedCases")
    void should_escape_more_complicated_cases(String text, String expected) {
        assertEquals(expected, HtmlEscaper.escape(text));
    }

    @Test
    void should_not_escape_if_there_is_no_character_to_escape() {
        final String noCharacterToEscape =
            "!@#$%^*()_+=-/?\\|]}[{,.;:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        assertEquals(noCharacterToEscape, HtmlEscaper.escape(noCharacterToEscape));
    }

    @Test
    void should_throw_if_input_is_null() {
        assertThrows(IllegalArgumentException.class, () -> HtmlEscaper.escape(null));
    }
}
