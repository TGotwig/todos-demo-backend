package com.example.todosdemobackend;

import com.example.todosdemobackend.entity.Todo;
import com.example.todosdemobackend.entity.TodoContent;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoService {
    private static MongoClientURI mongoConnectionString = new MongoClientURI(System.getenv("MONGO"));
    private static MongoCollection<Document> collection = new MongoClient((mongoConnectionString))
            .getDatabase("todos-demo")
            .getCollection("todo");

    public static Todo getTodo(String id) {
        Document query = new Document("_id", new ObjectId(id));
        Document doc = collection.find(query).iterator().next();

        return new Todo(
                doc.getObjectId("_id").toString(),
                doc.getString("text")
        );
    }

    public static List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<Todo>();

        for (Document doc : collection.find()) {
            todos.add(new Todo(
                    doc.getObjectId("_id").toString(),
                    doc.getString("text"))
            );
        }

        return todos;
    }

    public static Todo putTodo(TodoContent todoContent) {
        Document doc = new Document();
        doc.put("text", todoContent.getText());
        collection.insertOne(doc);

        Todo todo = new Todo(doc.get( "_id" ).toString(), todoContent.getText());

        return todo;
    }

    public static List<Todo> deleteTodo(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));

        return MongoService.getTodos();
    }

    public static Todo updateTodo(Todo todo) {
        Bson filter = new Document("_id", new ObjectId(todo.getId()));
        Bson newValue = new Document("text", todo.getText());
        Bson updateOperationDocument = new Document("$set", newValue);

        collection.updateOne(filter, updateOperationDocument);

        return MongoService.getTodo(todo.getId());
    }
}
