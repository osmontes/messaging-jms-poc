# POC Messaging JMS con Spring Boot
POC para de publicación y suscripción de mensajes mediante un JMS Broker y Spring boot.
#### Tecnologías
Java 11

spring-boot-starter-activemq 2.3.4-RELEASE

#### Ejecución
Para comprobar su funcionamiento se debe arrancar el servicio y comprobar las trazas de log
donde se podrá ver cuando se envía un mensaje a la cola y su recepción.

Se reciben de tres formas distintas, como un String, un mapa o un pojo convertido a JSON.

Código basado en el tutorial: https://spring.io/guides/gs/messaging-jms/