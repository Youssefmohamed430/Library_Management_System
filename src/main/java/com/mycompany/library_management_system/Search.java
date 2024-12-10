package com.mycompany.library_management_system;

import java.util.ArrayList;
import java.util.List;



public class Search {
    
    private SearchQuery currentQuery;    
    
    public void setCurrentQuery(SearchQuery query){
        this.currentQuery = query;
    }
    public SearchQuery getCurrentQuery(){
        return this.currentQuery;
    }
    
    public String search(SearchQuery query){
        setCurrentQuery(query);
        int i ;
        for(i = 0 ; i < books.length ; i++){
            if(books[i].type.equals(query.queryType) ||
               books[i].value.equals(query.queryValue)
              )
            {
             return books[i];  
            }
        }
    }    
}

class SearchQuery{
    
    String queryType;
    String queryValue;
    
    SearchQuery(){
        
    }
    
    SearchQuery(String queryType , String queryValue){
        this.queryType = queryType;
        this.queryValue = queryValue;
    }
    
    public String getQueryType(){
        return this.queryType;
    }
    
    public String getQueryValue(){
        return this.queryValue;
    }
    
    public void setQueryType(String queryType){
        this.queryType = queryType;
    }
    
    public void setQueryValue(String queryValue){
        this.queryValue = queryValue;
    }
    
    @Override
    public String toString() {
        return "SearchQuery{" +
                "queryType='" + queryType + '\'' +
                ", queryValue='" + queryValue + '\'' +
                '}';
    }
}
