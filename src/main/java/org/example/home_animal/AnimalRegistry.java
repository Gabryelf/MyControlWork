package org.example.home_animal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.home_animal.Animal.addCommands;

public class AnimalRegistry {
    private static List<Animal> animals = new ArrayList<>();
    private static Counter counter = new Counter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do{
            printMainMenu();
            choice = readChoice(scanner);

            switch (choice) {
                case 1:
                    createAnimal(scanner);
                    break;
                case 2:
                    printAnimalCommands( scanner );
                    break;
                case 3:
                    printAnimalCount();
                    break;
                case 4:
                    createCommandForAnimal(scanner);
                case 0:
                    System.out.println("Завершение программы.");
                    break;
                default:
                    System.out.println("Неправильный ввод! Пожалуйста, ознокомьтесь с инструкцией в меню.");
            }
        }while (choice != 0);
    }

    private static void createCommandForAnimal(Scanner scanner) {
        System.out.println("Можно приступить к оьучению!");
        scanner.nextLine();

        System.out.println("Введите имя обучаемого питомца: ");
        String name = scanner.nextLine();

        System.out.println("Введите команду для питомца: ");
        String command = scanner.nextLine();

        try{
            Animal.setCommands();
            addCommands();

            System.out.println("Питомец учится!");

        }catch (Exception e){
            System.out.println("Ошибка: Животное не зарегистрировано! ");
        }

    }

    private static void createAnimal(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Введите тип животного (-Собака/Кошка/Хомяк-): ");
        String animalType = scanner.nextLine();

        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        try{
            Animal animal;
            if(animalType.equalsIgnoreCase("Собака")){
                animal = new Dog(name);
            } else if (animalType.equalsIgnoreCase("Кошка")) {
                animal = new Cat(name);
            } else if (animalType.equalsIgnoreCase("Хомяк")) {
                 animal = new Hamster(name);
            }
            else{
                System.out.println("Этого типа еще нет в реестре.");
                return;
            }

            animals.add( animal );
            counter.increment( animalType );

            System.out.println("Регистрация животного успешно завершена!");
        } catch (Exception e){
            System.out.println("Ошибка: Животное не зарегистрировано! ");
        }
    }

    private static int readChoice(Scanner scanner) {
        System.out.println("Подтведите ваш выбор - введите число: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            return  -1;
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== Реестр Животных ===");
        System.out.println(" [ 1 ] Создать новую запись. Регистрация нового животного.");
        System.out.println(" [ 2 ] Смотреть команды животного.");
        System.out.println(" [ 3 ] Сводка. Общее количество животных.");
        System.out.println(" [ 4 ] Обучение. Научите питомца командам.");
        System.out.println(" [ 0 ] Выход из меню.");
    }

    private static void printAnimalCommands(Scanner scanner){
        if(animals.isEmpty()){
            System.out.println("Нет зарегистрированных животных.");
            return;
        }

        scanner.nextLine();

        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = findAnimalByName(name);
        if(animal != null){
            animal.printCommands();
        }
        else{
            System.out.println("Животного нет в реестре! Просмотрите сводку, там есть некоторые данные.");
        }
    }

    private static Animal findAnimalByName(String name) {
        for(Animal animal : animals){
            if(animal.getName().equalsIgnoreCase( name )){
                return animal;
            }
        }
        return null;
    }

    private static void printAnimalCount(){
        System.out.println("Всего зарегистрированно животных : " + counter.getCount());
        System.out.println("Тип животных : " + counter.getAnimalType());
    }
}
