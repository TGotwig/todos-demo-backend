-include .env
export

install:
	mvn clean install

setup:
	sh setup.sh

run:
	mvn compile && mvn spring-boot:run

run-snap:
	java -jar target/todos-demo-backend-0.0.1-SNAPSHOT.jar
