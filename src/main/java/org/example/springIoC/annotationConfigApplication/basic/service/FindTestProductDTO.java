package org.example.springIoC.annotationConfigApplication.basic.service;

public class FindTestProductDTO {
    private final String id;
    private final String name;

    public FindTestProductDTO(final String id, final String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
