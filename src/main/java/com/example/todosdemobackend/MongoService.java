package com.example.todosdemobackend;

import com.example.todosdemobackend.entity.Todo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoService {
    private static MongoClientURI mongoConnectionString = new MongoClientURI(String.format(
        "mongodb+srv://%s:%s@%s",
        System.getenv("MONGO_USER"),
        System.getenv("MONGO_PW"),
        System.getenv("MONGO_URL")
    ));

    public static Todo getTodo(String id) {
        try(MongoClient mongoClient = new MongoClient((mongoConnectionString))) {
            MongoDatabase database = mongoClient.getDatabase("todos-demo");
            MongoCollection<Document> collection = database.getCollection("todo");

            Document query = new Document("_id", new ObjectId(id));
            Document doc = collection.find(query).iterator().next();

            return new Todo(
                    doc.getObjectId("_id").toString(),
                    doc.getString("text")
            );
        }
    }

    public static List<Todo> getTodos() {
        try(MongoClient mongoClient = new MongoClient((mongoConnectionString))) {
            MongoDatabase database = mongoClient.getDatabase("todos-demo");
            MongoCollection<Document> collection = database.getCollection("todo");

            List<Todo> todos = new ArrayList<Todo>();

            for (Document doc : collection.find()) {
                todos.add(new Todo(
                        doc.getObjectId("_id").toString(),
                        doc.getString("text"))
                );
            }

            return todos;
        }
    }
}
