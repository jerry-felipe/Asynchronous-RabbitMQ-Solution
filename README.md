# Asynchronous-RabbitMQ-Solution
A messaging solution using RabbitMQ to handle asynchronous communication between services. It enables decoupling of components, improving scalability and reliability. Ideal for event-driven architectures, message queues, and distributed systems with high throughput needs.

# Features  
- Asynchronous Messaging: Handles background tasks without blocking other services.  
- Message Queues: Efficient message distribution with RabbitMQ.  
- Event-Driven Architecture: Supports event-driven systems, improving responsiveness.  
- Scalable: Easily scales to handle high message volumes.  
- Fault Tolerance: Ensures message delivery even in the event of service failures.  

# Technologies Used  
- Backend Framework: Spring Boot (Java)  
- Message Broker: RabbitMQ  
- JMS (Java Message Service): JMS for RabbitMQ message handling  
- API Documentation: Swagger/OpenAPI  
- Dependencies: Spring AMQP, RabbitMQ Client Library  

# Set Up the Environment  
1. Install RabbitMQ:  
   - Follow the installation guide from [RabbitMQ official site](https://www.rabbitmq.com/download.html).

2. Set up RabbitMQ:  
   - Ensure RabbitMQ is running on the local or remote server:  
     '''bash
     sudo systemctl start rabbitmq-server
     '''

3. Configure Environment Variables:  
   - Create a '.env' file or set environment variables for RabbitMQ connection:  
     '''env
     RABBITMQ_HOST=localhost
     RABBITMQ_PORT=5672
     RABBITMQ_USERNAME=your_username
     RABBITMQ_PASSWORD=your_password
     '''

4. Add Dependencies to 'pom.xml':  
   Add the following dependencies to your pom.xml to integrate RabbitMQ with Spring Boot:  
   '''xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-amqp</artifactId>
   </dependency>
   <dependency>
       <groupId>com.rabbitmq</groupId>
       <artifactId>amqp-client</artifactId>
       <version>5.9.0</version>
   </dependency>
   '''

5. Run the Application:  
   - To start the Spring Boot application:  
     '''bash
     mvn spring-boot:run
     '''

# Usage  
- Start the API server using Spring Boot:  
  '''bash
  mvn spring-boot:run
  '''  
- Access the API documentation at:  
  '''
  http://localhost:8080/swagger-ui.html
  '''

# Endpoints  
| Endpoint                         | Method | Description                            |  
|----------------------------------|--------|----------------------------------------|  
| '/message/send'                 | POST   | Send a message to the queue.           |  
| '/message/receive'              | GET    | Receive messages from the queue.       |  
| '/message/status/{messageId}'   | GET    | Get the status of a message.           |  

# Contributing  
Contributions are welcome! Please fork the repository and submit a pull request with detailed notes.

# License  
This project is licensed under the MIT License.

---  
For more information, contact jerry.felipe@gmail.com.
