package com.tw.questionMedium;

import java.util.*;

public class Book {
    private final String isbn;
    private final String name;
    private final int price;
    private final List<String> tags = new ArrayList<>();

    public Book(String isbn, String name, int price) {
        this.isbn = Objects.requireNonNull(isbn);
        this.name = Objects.requireNonNull(name);
        this.price = price;
    }

    public void addTags(String ...tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }
}
