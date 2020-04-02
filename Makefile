-include .env
export

install:
	mvn clean install

setup:
	sh setup.sh

run:
	java -jar target/todos-demo-backend-0.0.1-SNAPSHOT.jar
