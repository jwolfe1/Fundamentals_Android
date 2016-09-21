package com.JasonWolfe.Project_1;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    static void displayMenu() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
    }

    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static void addTask(ArrayList<String> taskArray) {
        System.out.println("Enter a description of the new task.");
        String newTask = getInput();
        taskArray.add(newTask);
    }

    static void removeTask(ArrayList<String> taskArray) {
        System.out.println("Enter the index of the task to remove.");
        int taskToRemove = Integer.parseInt(getInput());
        taskArray.remove(taskToRemove);
    }

    static void updateTask(ArrayList<String> taskArray) {
        System.out.println("Enter the index of the task to update.");
        int taskToUpdate = Integer.parseInt(getInput());
        System.out.println("Enter the new description of the task.");
        String newTaskDescription = getInput();
        taskArray.set(taskToUpdate, newTaskDescription);
    }

    static void listTasks(ArrayList<String> taskArray) {
        for(int i = 0; i < taskArray.size(); ++i) {
            System.out.println(i + ". " + taskArray.get(i));
        }

    }

    public static void main(String[] args) {
        String input = "45";
        ArrayList taskList = new ArrayList();

        while(!input.equals("0")) {
            displayMenu();
            input = getInput();
            byte var4 = -1;
            switch(input.hashCode()) {
                case 49:
                    if(input.equals("1")) {
                        var4 = 0;
                    }
                    break;
                case 50:
                    if(input.equals("2")) {
                        var4 = 1;
                    }
                    break;
                case 51:
                    if(input.equals("3")) {
                        var4 = 2;
                    }
                    break;
                case 52:
                    if(input.equals("4")) {
                        var4 = 3;
                    }
            }

            switch(var4) {
                case 0:
                    addTask(taskList);
                    break;
                case 1:
                    removeTask(taskList);
                    break;
                case 2:
                    updateTask(taskList);
                    break;
                case 3:
                    listTasks(taskList);
            }
        }

    }
}
