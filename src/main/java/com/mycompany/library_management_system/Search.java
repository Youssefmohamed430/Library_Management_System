package com.mycompany.library_management_system;

import java.util.ArrayList;

public class Search {
    private SearchQuery currentQuery = new SearchQuery();
    private FileManager manager = new FileManager();
    private ArrayList<Book> books = new ArrayList<>(manager.loadAllBooks("C:\\Library_Management_System\\Data"));
    

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


    public Object searchBook(String queryType, String queryValue) {
        setCurrentQuery(queryValue, queryType);
        
        for(Book book : books){
            if("title".equalsIgnoreCase(queryType) && book.getTitle().equalsIgnoreCase(queryValue)){
                return book;
            }
            else if("author".equalsIgnoreCase(queryType) && book.getAuthor().equalsIgnoreCase(queryValue)){
                return book;
            }
            else if("book_id".equalsIgnoreCase(queryType) && book.getId().equalsIgnoreCase(queryValue)){
                return book;
            }
            else{
                throw new IllegalArgumentException("invalid Query type or value ");
            }
        } 
        
//        if not located in memory , we will find through the fileManager
        String bookFilePath = "C:\\Library_Management_System\\Books";
        Object bookFromFile = manager.LoadBook(queryType, queryValue, bookFilePath);
        if (bookFromFile instanceof Book) {
            return (Book) bookFromFile;
        }
        
        return null;
    }
}


class SearchQuery {
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
