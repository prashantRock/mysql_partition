package com

class Person {


    String name
    int age

    static mapping = {
        version false
    }


    public Person(String name, int age){
        this.age = age
        this.name = name
    }

}
