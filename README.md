# dougbook
The world's most basic and unremarkable notebook system.

## Running via docker
###Requirements
- Docker CLI
- Maven

### Instructions
- From the terminal navigate to the parent folder /dougbook
- From the root directory of /dougbook run :````docker build -t spring-boot-dougbook.jar . ````
- Once the container is created, run the container: 
````docker run -p 9090:8080 spring-boot-dougbook.jar````
- You will see Spring Boot initialize and start. You will be able to access it via: 
```` http://localhost:9090 ````

Swagger is install and can be accessed:
``http://localhost:9090/swagger-ui.html#/notebook-controller``
if running via the provided docker command.

If running locally: 
``http://localhost:8080/swagger-ui.html#/notebook-controller``
