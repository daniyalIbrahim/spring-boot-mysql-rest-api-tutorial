## Spring boot with Mysql

#### Setting up mysql in docker

  the following command will pull official 
  mysql container from docker hub
    
            docker pull mysql
    
  run the container when it is pulled using

    docker container run -d -p 3306:3306 --name anyname -e MYSQL_ROOT_PASSWORD=anypassword mysql  
 
  *just a hint, what -p 3306:3306 meant actually  
  -p [port visible outside at host] : [port visible inside the docker virtual network]
    
  now to list all containers, images or networks
    
    docker images ls
    docker container ls 
    docker network ls
    
   check the name of the container using the above mentioned command
   then go inside the container using
   
    docker container exec -it containername sh
   
   now you can create a database with a name of your choice or 
   any mysql cli commands can be executed here
   
   to open mysql cli type
   
    mysql -u root -p 
  
  when you execute this command, the cli will ask for password, type the password 
  you have given to the mysql, at the time you ran the container.
  
  now you are in the mysql cli

        create database databasename; 
        show databases;
        
  now exit and connect to the spring boot application, by adding key value pairs
  in the application.properties files
  
  also connect to the mysql container database using any ide
  just by mentioning the
        
       ip address
       port number
       database name // the one you created
       user name //by default is root
       password // the password you gave to the mysql container db

when connected run the following sql script, to have a model users table ready

    CREATE TABLE users(
      PersonID integer,
      Name varchar(255),
      Age integer,
      Sex varchar(255),
      Contact_Number Long,
      PRIMARY KEY (PersonID)
    );
    
#### Springboot with mysql CRUD Repository

so go to your package base folder, i.e the folder with Main Class
and make the following folders

#####model
this folder holds your table data, or simply objects. For each object
make a java class, add getter setter methods, and declare variables. 
Lets make a user class, which can hold data for a user table.

just to be clear. lombok plugin give us certain annotations such as,
        
        @NoArgsConstructor
        @RequiredArgsConstructor
        @Getter
        @Setter
 so we don't have to write the getter settter and constructor methods manually.
 use this plugin by downloading lombok in your ide. go to plugin manager of your ide.
        
#####controller
this class holds the rest api endpoints for your application. 
Each endpoint has a reserved method to use. you annotate your methods in 
this class using the path of endpoint 



