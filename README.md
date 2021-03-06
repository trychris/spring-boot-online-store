# spring-boot-online-shop

This information is accurate as of 23/2/2022

### Tech stack and libraries
1. This project uses Spring boot MVC.
1. MySQL is used as a database.
1. Java Hibernate is used for Object-Relational Mapping
1. Lombok is used to generate constructors, getters and setters
1. JQuery and Ajax is used for the REST services.
1. The original online store template is modified from https://www.bootstrapdash.com/product/free-bootstrap-login/.
1. Bootstrap and various plugins are used in the design of the website.

### Set up MYSQL database (Windows)
1. Install MySQL and add it to path
2. Run cmd as admin and run the command 
```
mysqld –initialize
```
This command creates the mysql system schema and its tables, and creates a 'root'@'localhost' superuser account with a random password

3. Start the server with 
```
mysqld --console
```
4. Start another cmd as admin and use the command line client to login to the MySQL server

```
mysql -u root –p
```
This will prompt you to enter the random password generated earlier

5. Create a database with the command 
```
CREATE DATABASE DatabaseName;
```


### Set up
1. In the application.properties file, change (database_name), (username) and (password) of the MySQL database
2. If you use Maven, run the following command in a terminal window (in the complete) directory:
```
mvnw spring-boot:run
```
3. The web application will run on localhost on port 8080 by default.


### Authentication and Authorization
1. https://spring.io/guides/gs/securing-web/
2. https://www.baeldung.com/spring-security-expressions
3. https://www.baeldung.com/spring-security-login

### Password Custom validation
1. https://www.baeldung.com/java-custom-annotation
2. https://www.baeldung.com/registration-with-spring-mvc-and-spring-security

### How to populate the category repository with initial data
1. https://www.danvega.dev/blog/2017/07/05/read-json-data-spring-boot-write-database/
2. https://stackoverflow.com/questions/43804262/how-to-access-a-resource-file-in-src-main-resources-folder-in-spring-boot

### Online cart functionality
https://www.youtube.com/embed/rFSxmKen6aQ

# Resources used

### Website logo generated from
https://www.freelogodesign.org/

### Initial Json data generated from
https://www.generatedata.com/

### Registration Form plugins
The phone number input is a plugin by https://github.com/jackocnr/intl-tel-input/blob/master/README.md \
The original registration template has been modified from https://jsfiddle.net/bootstrapious/3j4a0Lps/
 
### Note for future problems:
There are some reserved table names in MySQL, like Order


The file structure is as follows:
```
|   mvnw
|   mvnw.cmd
|   pom.xml
|   
+---.mvn
|   \---wrapper
|           maven-wrapper.jar
|           maven-wrapper.properties
|           MavenWrapperDownloader.java
|                
+---src
|   +---main
|   |   +---java
|   |   |   \---demo
|   |   |       |   RandomDepartmentOnlineStoreApplication.java
|   |   |       |   
|   |   |       +---entity
|   |   |       |       CartItem.java
|   |   |       |       CustomerAccount.java
|   |   |       |       CustomerOrder.java
|   |   |       |       OrderForm.java
|   |   |       |       OrderItem.java
|   |   |       |       Product.java
|   |   |       |       ProductCategory.java
|   |   |       |       
|   |   |       +---repository
|   |   |       |       CartItemRepository.java
|   |   |       |       CustomerAccountRepository.java
|   |   |       |       CustomerOrderRepository.java
|   |   |       |       OrderItemRepository.java
|   |   |       |       ProductCategoryRepository.java
|   |   |       |       ProductRepository.java
|   |   |       |       
|   |   |       +---security
|   |   |       |       LoginController.java
|   |   |       |       PasswordMatches.java
|   |   |       |       PasswordMatchesValidator.java
|   |   |       |       RegistrationController.java
|   |   |       |       RegistrationForm.java
|   |   |       |       UserRepositoryUserDetailsService.java
|   |   |       |       WebSecurityConfig.java
|   |   |       |       
|   |   |       +---service
|   |   |       |       ShoppingCartServices.java
|   |   |       |       
|   |   |       \---web
|   |   |               AccountController.java
|   |   |               BrowseShopController.java
|   |   |               CheckoutController.java
|   |   |               HomeController.java
|   |   |               ShoppingCartController.java
|   |   |               ShoppingCartRestController.java
|   |   |               
|   |   \---resources
|   |       |   application.properties
|   |       |   README.txt  
|   |       +---static
|   |       |   +---css
|   |       |   +---fonts     
|   |       |   +---img     
|   |       |   +---js      
|   |       |   \---json
|   |       |           CustomerAccountData.json
|   |       |           productData.json
|   |       |           
|   |       \---templates
|   |               cart.html
|   |               category.html
|   |               checkout.html
|   |               footer.html
|   |               header.html
|   |               index.html
|   |               login.html
|   |               products.html
|   |               registration.html
|   |               single-product.html
|   |               
|   \---test
|       \---java
|           \---demo
|               |   RandomDepartmentOnlineStoreApplicationTests.java
|               |   WebApplicationTest.java
|               |   WebLayerOnlyTest.java
|               |   
|               \---entity
|                       ShoppingCartTests.java
|                       
```
