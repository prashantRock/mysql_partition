package com

class FetchController {

    /*
    ALTER TABLE partition_db.employee PARTITION BY RANGE COLUMNS(age)
(
PARTITION p0 VALUES LESS THAN (5000),
PARTITION p1 VALUES LESS THAN (10000),
PARTITION p2 VALUES LESS THAN (15000),
PARTITION p3 VALUES LESS THAN (20000),
PARTITION p4 VALUES LESS THAN (25000),
PARTITION p5 VALUES LESS THAN (30000),
PARTITION p6 VALUES LESS THAN (35000),
PARTITION p7 VALUES LESS THAN (40000),
PARTITION p8 VALUES LESS THAN MAXVALUE
);

     */
    def index() {}

    def saveEmployeeData() {
        for (int i = 47098; i < 50000; i++) {
            Employee employee = new Employee("prashant" + i, i)
            employee.save(flush: true)
        }
    }

    def savePersonData() {
        for (int i = 1; i < 50000; i++) {
            Person person = new Person("prashant" + i, i)
            person.save(flush: true)
        }
    }

    def employeeDetail() {
        long initialTime = System.currentTimeMillis()
        def employee = Employee.findByAge(30001)
//        def employee = Employee.executeQuery("select username from Employee where age = 32001")
        println employee
        long finalTime = System.currentTimeMillis()
        println "================ partitioned " + (finalTime - initialTime)
        render "time taken ====>>>>>>   "+ (finalTime - initialTime)
    }

    def personDetail() {
        long initialTime = System.currentTimeMillis()
        def person = Person.findByAge(30001)
//        def person = Person.executeQuery("select name from Person where age = 32001")
        println person
        long finalTime = System.currentTimeMillis()
        println "================non partitioned " + (finalTime - initialTime)
        render "time taken ====>>>>>>   "+ (finalTime - initialTime)
    }
}