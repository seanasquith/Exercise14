package com.company.asquith;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Task {
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Task(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }
}

class TaskList {
    private List<Task> todos = new ArrayList<>();

    public TaskList(List<Task> todos) {
        this.todos = todos;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("src/com/company/asquith/data.json");
        Gson gson = new Gson();
        TaskList taskList = gson.fromJson(reader, TaskList.class);

        FileWriter writer = new FileWriter("src/com/company/asquith/data2.json");
        gson.toJson(taskList, writer);
        writer.close();
    }
}
