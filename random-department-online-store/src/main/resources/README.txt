Authentication and Authorization
https://spring.io/guides/gs/securing-web/
https://www.baeldung.com/spring-security-expressions
https://www.baeldung.com/spring-security-login

Free online store templates from
https://www.bootstrapdash.com/product/free-bootstrap-login/

Website logo generated from
https://www.freelogodesign.org/

Initial Json data generated from
https://www.generatedata.com/

Populate the category repository with initial data
https://www.danvega.dev/blog/2017/07/05/read-json-data-spring-boot-write-database/
https://stackoverflow.com/questions/43804262/how-to-access-a-resource-file-in-src-main-resources-folder-in-spring-boot

Registration Form
The phone number input is a plugin by https://github.com/jackocnr/intl-tel-input/blob/master/README.md
The original registration template has been modified from https://jsfiddle.net/bootstrapious/3j4a0Lps/

Password Custom validation
https://www.baeldung.com/java-custom-annotation
https://www.baeldung.com/registration-with-spring-mvc-and-spring-security

Online cart functionality
https://www.youtube.com/embed/rFSxmKen6aQ

Cascading
https://www.baeldung.com/jpa-cascade-types

This is the description of the Database

One CustomerAccount can have many CustomerOrder.
One CustomerOrder can have many OrderItem.
One CusomterAccount can have many CartItem.
A Product has one value of ProductCategory.Category Enum. 
 
 Note for future problems:
 There are some reserved table names, like Order, so I had to change the CustomerOrder entity to customer order, or else SQL ALTER statement errors would occur