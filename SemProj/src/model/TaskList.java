package model;

import java.util.ArrayList;

public class TaskList
{
    ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(Task task)
    {
        taskList.add(task);
    }

    public Task getTask(int next)
    {
        return taskList.get(next);
    }

    public int getLength()
    {
        return taskList.size();
    }

}