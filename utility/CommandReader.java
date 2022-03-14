package utility;

import java.util.NoSuchElementException;

public class CommandReader {
    final CollectionManager collectionManager;
    final Invoker invoker;
    public CommandReader(CollectionManager collectionManager,Invoker invoker){
        this.collectionManager = collectionManager;
        this.invoker = invoker;
    }

    public void read(){
        System.out.println("\n\tВведите команду");
        try {
            String newInput = Console.next();
            while (!newInput.equals("exit")) {
                invoker.execute(newInput);
                System.out.println("\n\tВведите команду");
                newInput = Console.next();
            }
        } catch (IllegalArgumentException | NoSuchElementException e1) {
            System.out.println("Некорректный ввод");
        }
    }
}
