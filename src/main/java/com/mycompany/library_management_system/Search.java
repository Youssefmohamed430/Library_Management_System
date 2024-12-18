package com.mycompany.library_management_system;

import java.util.ArrayList;

public class Search {
    private SearchQuery currentQuery = new ConcreteSearchQuery(); // Initialize with a concrete implementation
    private final String BOOK_FILE_PATH = "E:\\programming\\Java\\Library_Management_System\\Data\\Books.txt";
    private ArrayList<Book> books = new ArrayList<>(FileManager.loadAllBooks(BOOK_FILE_PATH));
    
    public String getCurrentQuery() {
        return this.currentQuery.toString();
    }
    
    private void setCurrentQuery(String queryValue, String queryType) {
        if (queryType == null || queryValue == null || queryType.isEmpty() || queryValue.isEmpty()) {
            throw new IllegalArgumentException("Query type and value cannot be null or empty.");
        }
        this.currentQuery.queryType = queryType;
        this.currentQuery.queryValue = queryValue;
    }
    
    public Book searchBook(String queryType, String queryValue) {
        setCurrentQuery(queryValue, queryType);
        for (Book book : books) {
            if ("title".equalsIgnoreCase(queryType) && book.getTitle().equalsIgnoreCase(queryValue)) {
                return book;
            } else if ("author".equalsIgnoreCase(queryType) && book.getAuthor().equalsIgnoreCase(queryValue)) {
                return book;
            } else if ("Id".equalsIgnoreCase(queryType) && book.getId().equalsIgnoreCase(queryValue)) {
                return book;
            }
        }
        return null;
    }
}

abstract class SearchQuery {
    String queryType;
    String queryValue;

    @Override
    public String toString() {
        return "SearchQuery{" +
                "queryType='" + queryType + '\'' +
                ", queryValue='" + queryValue + '\'' +
                '}';
    }
}

class ConcreteSearchQuery extends SearchQuery {
    // Concrete implementation for SearchQuery
}
    
