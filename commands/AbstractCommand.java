/**
 * Abstract command for all another commands.
 */
package commands;

import commands.interfaces.CommandInterface;
import utility.CollectionManager;

import java.util.List;


public abstract class AbstractCommand implements CommandInterface {
    final CollectionManager collectionManager;
    final int countOfArguments = 0;
    /**
     *
     * @param collection collection
     */

    public AbstractCommand(CollectionManager collection) {
        collectionManager = collection;
    }

    /**
     * Executing the command
     * @param arguments arguments for our command
     */
    @Override
    public abstract void execute(List<Object> arguments);

    public int getCountOfArguments(){
        return countOfArguments;
    }
}
