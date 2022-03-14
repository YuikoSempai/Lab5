/**
 * The command class for add.
 */

package commands;

import data.Coordinates;
import data.Person;
import data.Ticket;
import data.TicketType;
import utility.CollectionManager;
import utility.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Add extends AbstractCommand {
    final int countOfArguments = 10;
    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public Add(CollectionManager collection){
        super(collection);
    }
    public int getCountOfArguments() {
        return countOfArguments;
    }


    public void execute(List<Object> arguments) {
        Ticket ticket = createObject(arguments);
        if (Console.getReadFromFileStatus()) {
            if (ticket == null) {
                System.out.println("Ошибка входных данных в скрипте, файл не был создан");
            } else {
                collectionManager.add(ticket);
                System.out.println("Объект был создан\n");
            }
        } else {
            collectionManager.add(ticket);
            System.out.println("Объект был создан\n");
        }
    }


    /**
     * Creates an object of the Ticket class based on the list of arguments passed to it.
     * @param arguments arguments for create a new ticket.
     * @return Ticket
     * @throws NullPointerException - can't create a new ticket.
     */
    protected Ticket createObject(List<Object> arguments) throws NullPointerException{
        int i = 0;
        try {
            String name = (String) arguments.get(i++);
            double price = (Double) arguments.get(i++);
            String comment = (String) arguments.get(i++);
            Integer coordinatesX = (Integer) arguments.get(i++);
            Float coordinatesY = (Float) arguments.get(i++);
            Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY);
            TicketType type = (TicketType) arguments.get(i++);
            LocalDateTime localDateTime = ((LocalDate) arguments.get(i++)).atStartOfDay();
            Float height = (Float) arguments.get(i++);
            Integer weight = (Integer) arguments.get(i++);
            String passportId = (String) arguments.get(i);
            Person person = new Person(localDateTime, height, weight, passportId);
            return new Ticket(name, coordinates, price, comment, type, person);
        } catch (Exception e) {
            System.out.println("Неправильные входные данные. Объект не был создан");
            throw new NullPointerException();
        }
    }
}