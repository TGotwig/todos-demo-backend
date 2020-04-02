include .env
export

install:
	mvn clean install

run:
	java -jar target/todos-demo-backend-0.0.1-SNAPSHOT.jar
