package org.example.home_animal;

import java.util.ArrayList;

public class Animal {
    private String name;
    private static ArrayList commands;

    public Animal(String name){
        this.name = name;
        this.commands = commands;
    }

    public static void setCommands() {
    }

    public void setCommands(ArrayList commands) {
        this.commands = commands;
    }

    public String getName(){
        return name;
    }

    public static void printCommands(){
        System.out.println("Это животное не знает никаких команд.");
    }

    public static void printUseCommands(){
        System.out.println("Это животное знает команды.");

    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getCommands() {
        return commands;
    }

    public static void addCommands(){
        if(commands.isEmpty()){
           printCommands();
        }
        else{
            printUseCommands();
            for ( Object command : commands ){
                System.out.println(" - " + command);
            }
        }
    }
}
