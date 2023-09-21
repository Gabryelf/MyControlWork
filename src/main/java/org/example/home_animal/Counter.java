package org.example.home_animal;

public class Counter {
    private int count;
    private String animalType;

    public Counter(){
        count = 0;
        animalType = " ";
    }

    public void increment(String animalType){
        count++;
        this.animalType = animalType;
    }

    public int getCount(){
        return count;
    }

    public String getAnimalType(){
        return animalType;
    }
}
