package com

class Employee {

    String username
    int age

    static mapping = {
        id name: 'age'
        version false
        id generator: 'assigned'
    }
    static constraints = {
        age(nullable: true)
    }

    public Employee(String name, int age){
        this.age = age
        this.username = name
    }
}
