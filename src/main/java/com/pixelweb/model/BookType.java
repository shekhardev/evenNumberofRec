package com.pixelweb.model;

public enum  BookType {
    CD("cd"),
    KINDLE("kindle"),
    PDF("pdf");

    private final String name;

    BookType(String name) {
        this.name = name;
    }
}
