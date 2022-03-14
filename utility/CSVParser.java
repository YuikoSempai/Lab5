package utility;

import data.Coordinates;
import data.Person;
import data.Ticket;
import data.TicketType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVParser {
    final CollectionManager collectionManager;
    final String[] args;
    /**
     * Class constructor
     *
     * @param collectionManager - class for work with collection
     */
    public CSVParser(CollectionManager collectionManager, String[] aArgs){
        this.collectionManager = collectionManager;
        args = aArgs;
    }
    
    public void startParse(){
        if (args.length > 0) {
            String filePath = args[0];
            try {
                if (new File(filePath).canRead()) {
                    if (!filePath.equals("without_path")) {
                        parseCSVtoString(filePath.replace("/", "//"));
                    }
                    if (new File(filePath).canWrite()) {
                        System.out.println("Файл доступен для записи");
                        collectionManager.setPathForFile(filePath);
                    } else {
                        System.out.println("Файл не доступен для записи");
                    }
                } else {
                    System.out.println("файл не доступен для чтения");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void parseCSVtoString(String file) throws IOException {
        Path path = Paths.get(file);
        Scanner reader = new Scanner(path);
        reader.next();
        while (reader.hasNext()) {
            String line = reader.next(); // nextLine?
            String[] row = line.split(";");
            List<String> arguments = Arrays.asList(row);
            createObject(arguments);
        }
        reader.close();
    }

    /**
     * Creates a new instance of the Ticket
     *
     * @param arguments fields for instance of the Ticket
     */
    private void createObject(List<String> arguments) {
        int i=0;
        try {
            String name = arguments.get(i++);
            Integer coordinatesX = Integer.valueOf(arguments.get(i++));
            Float coordinatesY = Float.valueOf(arguments.get(i++));
            Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY);
            double price = Double.parseDouble(arguments.get(i++));
            String comment = arguments.get(i++);
            TicketType type = TicketType.valueOf(arguments.get(i++));
            String[] birthday = arguments.get(i++).split("-");
            LocalDateTime localDateTime = LocalDateTime.of(
                    Integer.parseInt(birthday[2]), Integer.parseInt(birthday[1]),
                    Integer.parseInt(birthday[0]), 0, 0
            );
            Float height = Float.valueOf(arguments.get(i++));
            Integer weight = Integer.valueOf(arguments.get(i++));
            String passportId = arguments.get(i);
            Person person = new Person(localDateTime, height, weight, passportId);
            Ticket ticket = new Ticket(name, coordinates, price, comment, type, person);
            collectionManager.add(ticket);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Wrong input in file");
        }

    }
}