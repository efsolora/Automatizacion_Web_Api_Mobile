package com.choucair.utils;

public enum UrlResources {

    BASE_API_URL("https://dummy.restapiexample.com/"),
    POST_API_URL("api/v1/create"),
    GET_API_URL("api/v1/employee"),
    PUT_API_URL("public/api/v1/update"),
    DELETE_API_URL("public/api/v1/delete");


    private final String value;

    UrlResources(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
