FROM openjdk:21
WORKDIR /app
COPY ./target/product.jar /app
EXPOSE 8087
CMD ["java","-jar","emp.jar"]