/**
 * The command class for exit.
 */

package commands;

import utility.CollectionManager;

import java.util.List;

public class Exit extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Exit(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * Exits the program
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        System.out.println("Завершение выполнения");
    }
}
