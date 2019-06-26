# StudentAppSpringBoot

Simple Student Application using Spring Boot.
* This Application does CRUD operation with Embedded Database (H2) or MySql.
* Application has 2 profiles 'dev' and 'prod'. 
    * dev profile it points to embedded H2 database and has initial data script (data-h2.sql) 
for prepopulate some data when application start.
    * prod profile point to mysql database and application will use data that is already persisted in it.
* Uses JPA (CrudRepository) to access fetch and update data.
Also support externalize cloud configuration with different profiles like dev,prod etc from github repository.

* Application provides 2 ways to access it
    1. UI - 'https://localhost:port/ui/students' 
    2. Rest - 'https://localhost:port/rest/students' 

