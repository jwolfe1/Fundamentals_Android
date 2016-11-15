package com.JasonWolfe.Project_03;

import java.util.*;

class Task implements Comparable<Task>
{
    private String task;
    private String description;
    private int priority;

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    Task(String task, String description, int priority)
    {
        setTask(task);
        setDescription(description);
        setPriority(priority);
    }

    @Override
    public int compareTo(Task o) {
        int result;

        if (this.getPriority() == o.getPriority()) {
            result = this.getTask().compareTo(o.getTask());
        }
        else if(this.getPriority() < o.getPriority()) {
            result = -1;
        }
        else {
            result = 1;
        }

        return result;
    }

} // end of class Task

class TaskBook implements Iterable<Task>{
    List<Task> taskList = new ArrayList<>();

    public void add(Task task) {
        taskList.add(task);
    } // end of add method

    public void listAllTasks() {
        int i = 0;
        Collections.sort(taskList);
        for(Task task: taskList) {
            System.out.println("Task index: " + i + ", Name: " + task.getTask() + ", Description: " + task.getDescription() + ", Priority: " + task.getPriority());
            i++;
        }
    } // end of listAllTasks method

    public void listTaskByPriority(int priority) {
        int i = 0;
        for(Task task: taskList) {
            if(task.getPriority() == priority) {
                System.out.println("Task index: " + i + ", Name: " + task.getTask() + ", Description: " + task.getDescription() + ", Priority: " + task.getPriority());
            }
            i++;
        }
    } // end of listTasksByPriority method

    public void removeTask(int taskIndex) {
        if(taskIndex >= 0 && taskIndex < taskList.size()) {
            taskList.remove(taskIndex);
        }
        else {
            System.out.println("There is not a task at index " + taskIndex);
        }

    } // end of removeTask method

    public void updateTask(int taskIndex, Task task) {
        if(taskIndex >= 0 && taskIndex < taskList.size()) {
            taskList.set(taskIndex, task);
        }
        else {
            System.out.println("There is not a task at index " + taskIndex);
        }


    }// end of updateTask method

    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }

} // end of class TaskBook

class UserInput {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List tasks by priority.");
        System.out.println("(0) Quit.");
    } // end of displayMenu method

    public int getMenuItem() {
        boolean isInt = false;
        int input = 99;

        String menuItemInput = scanner.nextLine();
        while(!isInt) {
            try {
                input = Integer.parseInt(menuItemInput);
                isInt = true;
            }
            catch(NumberFormatException nfe) {
                System.out.println("Enter a number.");
                menuItemInput = scanner.nextLine();
                isInt = false;
            }
        }
    return input;
    } // end of getMenuItem method

    public String getTask() {
        System.out.println("Enter a name for the task.");
        return scanner.nextLine();
    } // end of getTask method

    public String getTaskDescription() {
        System.out.println("Enter a description for the task.");
        return scanner.nextLine();
    } // end of getTaskDescription method

    public int getPriority() {
        int priority = 99;
        boolean isInt = false;

        System.out.println("Enter the task's priority.");
        String input = scanner.nextLine();
        while(!isInt) {
            try {
                priority = Integer.parseInt(input);
                isInt = true;
            }
            catch(NumberFormatException nfe) {
                System.out.println("Enter the task's priority.");
                input = scanner.nextLine();
                isInt = false;
            }
        }

        if(priority > 5) {
            priority = 5;
        }
        else if (priority < 0) {
            priority = 0;
        }

        return priority;
    } // end of getPriority method

    public int getIndex() {
        int index = 99;
        boolean isInt = false;

        System.out.println("Enter the number of the index.");
        String input = scanner.nextLine();
        while(!isInt) {
            try {
                index = Integer.parseInt(input);
                isInt = true;
            }
            catch(NumberFormatException nfe) {
                System.out.println("Enter the number of the index.");
                input = scanner.nextLine();
                isInt = false;
            }
        }

        return index;
    } // end of getIndex method
} // end of class UserInput


public class Main
{
    public static void main(String[] args)
    {
        int input = 99;
        String taskName;
        String taskDescription;
        int taskPriority;

        UserInput userInput = new UserInput();
        TaskBook myTaskBook = new TaskBook();

        while(input != 0) {
            userInput.displayMenu();
            input = userInput.getMenuItem();

            switch(input){
                case 1:
                    taskName = userInput.getTask();
                    taskDescription = userInput.getTaskDescription();
                    taskPriority = userInput.getPriority();
                    Task task = new Task(taskName, taskDescription, taskPriority);
                    myTaskBook.add(task);
                    break;
                case 2:
                    System.out.println("You have selected to remove a task.");
                    myTaskBook.removeTask(userInput.getIndex());
                    break;
                case 3:
                    System.out.println("You have selected to update a task.");
                    int taskIndexToUpdate = userInput.getIndex();
                    String newTaskName = userInput.getTask();
                    String newTaskDescription = userInput.getTaskDescription();
                    int newTaskPriority = userInput.getPriority();
                    Task updatedTask = new Task(newTaskName, newTaskDescription, newTaskPriority);
                    myTaskBook.updateTask(taskIndexToUpdate, updatedTask);
                    break;
                case 4:
                    myTaskBook.listAllTasks();
                    break;
                case 5:
                    int priority = userInput.getPriority();
                    myTaskBook.listTaskByPriority(priority);
                    break;
                case 0:
                    System.out.println("Have a good day!.");
                    break;
                default:
                    System.out.println("Enter a number for the menu item.");
                    break;
            } // end of switch
        } // end of while loop

    } // end of main

}// end of class Main
