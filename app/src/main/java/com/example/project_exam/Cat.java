package com.example.project_exam;

public class Cat {
private String name;
private String breed;
private Boolean status;

public Cat(String name, String breed, Boolean status) {
    this.name = name;
    this.breed = breed;
    this.status = status;
}

public String getName () {
    return name;
}
public String getBreed () {
    return breed;
}
public Boolean getStatus() {
    return status;
}
}
