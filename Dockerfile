FROM openjdk

COPY target .

EXPOSE 9999

ENTRYPOINT ["java", "-jar" , "product-ms-0.0.1-SNAPSHOT.jar"]