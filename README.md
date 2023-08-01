# role-base-login
This application is a demo project for doing the role base access control with basic authentication.

Here we can have different roles, currently I have assumed two roles- ROLE_ADMIN and ROLE_STAFF.
Roles can be created as many as the client needs as per the level of access control required.


Rest Api Support available for USER controller:

1. admin/staff can signup and create admin/staff role (roles use either "ROLE_ADMIN" or "ROLE_STAFF")
2. admin can delete user


Rest Api Support available for SCHEDULE controller: 
1. admin can create/delete schedule for a user.
2. admin/staff can view all or a specific user schedule.

Steps to run the application:
 1. clone the application from : 'git clone https://github.com/soni-world/role-base-login.git'
 2. Then run the maven command from inside the repo src : 'mvn clean build'
 3. docker build: 'docker build -t role-base-login.jar .'
 4. finally you will have image created, run the image as 'docker run -p 8080:8080 role-base-login.jar'
 5. Also can find the api documentation on 'http://localhost:8080/api-docs' 
 6. and swagger can be accessed at 'http://localhost:8080/swagger-ui/index.html'

Usage:
1. Create a USER with ROLE_ADMIN or ROLE_STAFF.
2. then create schedules for the users with userID.
3. access, create or delete the schedules and users as per the role access.
4. Note: can use postman for the api access and as I have used basic auth so need to provide username and password for api accessing in the authorization on postman.