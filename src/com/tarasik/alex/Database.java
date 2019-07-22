package com.tarasik.alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Alex Tarasik on 20.07.2019.
 * @project ATM
 */
public class Database {

    protected static ArrayList<String> database = new ArrayList<>(2);

    private static String separator = File.separator;
    private static String path = "." + separator + "src" + separator + "Database.txt";
    protected static File file = new File(path);

    //Класс читает данные из файла и записывает их в коллекцию
    public static void readingFile(){

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        while (scanner.hasNextLine()){
            database.add(scanner.nextLine());
        };
        scanner.close();

        /*for(String x: database){
            System.out.println(x);
        }*/
    }

    //Класс записывает данные из коллекции в файл
    public static void writingFile(){

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        for (int i = 0; i < database.size(); i++) {
            pw.println(database.get(i));
        }

        pw.close();
    }
}
