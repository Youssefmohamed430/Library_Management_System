package com.mycompany.library_management_system;

import java.util.ArrayList;
import java.util.List;



public class Search {
    private SearchQuery currentQuery;    
    
    public String getCurrentQuery(){
        return this.currentQuery.toString();
    }
    
    private void setCurrentQuery(String queryValue , String queryType){
        this.currentQuery.queryType = queryType;
        this.currentQuery.queryValue = queryValue;
    }
    public String search(String queryValue , String queryType){
        setCurrentQuery(queryValue , queryType);
        int i ;
        for(i = 0 ; i < books.length ; i++){
            if(books[i].type.equals(currentQuery.queryType) ||
               books[i].value.equals(currentQuery.queryValue)
              )
            {
             return books[i].toString();  
            }
        }
    }    
}

class SearchQuery{
    
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
