package com.mycompany.library_management_system;

import java.util.ArrayList;

public class Search {
    private SearchQuery currentQuery = new SearchQuery();
    private ArrayList<Books> books = new ArrayList<>();  
    private String bookFilePath = "C:\\Library_Management_System\\Data";

    public String getCurrentQuery() {
        return this.currentQuery.toString();
    }

    private void setCurrentQuery(String queryValue, String queryType) {
        this.currentQuery.queryType = queryType;
        this.currentQuery.queryValue = queryValue;
    }
<<<<<<< HEAD
//    public String search(String queryValue , String queryType){
//        setCurrentQuery(queryValue , queryType);
//        int i ;
//        for(i = 0 ; i < books.length ; i++){
//            if(books[i].type.equals(currentQuery.queryType) ||
//               books[i].value.equals(currentQuery.queryValue)
//              )
//            {
//             return books[i].toString();  
//            }
//        }
//    }    
=======

    public Object searchBook(String queryType, String queryValue) {
        setCurrentQuery(queryValue, queryType);

        for (int i = 0; i < books.size(); i++) {
            Books book = books.get(i);
            if (queryType.equals("title") && book.getTitle().equals(queryValue)) {
                return book;
            } else if (queryType.equals("author") && book.getAuthor().equals(queryValue)) {
                return book;
            }
        }

        // If not found in memory, load from file
        Object bookFromFile = FileManager.LoadBook(queryType , queryValue , bookFilePath);
        if (bookFromFile instanceof Books) {
            return bookFromFile;
        }

        return null;
    }
>>>>>>> 84567c455ea32b042161505ac5c250b0ef73271c
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
