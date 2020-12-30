package com.pulakdeyashi.javaexample;

public class Track {
    private String name;
    private String instructor;

    Track(String name, String instructor){
        this.name = name;
        this.instructor = instructor;
    }
    public String getName(){
        return this.name;
    }
    public String getInstructor(){
        return this.instructor;
    }
}
