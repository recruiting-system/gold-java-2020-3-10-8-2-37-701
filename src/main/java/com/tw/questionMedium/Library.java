package com.tw.questionMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addAll(Book ...books) {
        this.books.addAll(Arrays.asList(books));
    }

    /**
     * Find all the books which contains one of the specified tags.
     *
     * @param tags The tag list.
     * @return The books which contains one of the specified tags. The returned books
     *   should be ordered by their ISBN number.
     */
    public List<Book> findBooksByTag(String ...tags) {
        // TODO:
        //   Please implement the method
        // <-start-
        return null;
        // --end-->
    }

    // TODO:
    //   You can add additional methods here if you want.
    // <-start-

    // --end-->
}
