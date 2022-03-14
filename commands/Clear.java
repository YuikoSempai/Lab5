/**
 * The command class for clear.
 */

package commands;

import utility.CollectionManager;

import java.util.List;

public class Clear extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Clear(CollectionManager collection) {
        super(collection);
    }

    public int getCountOfArguments() {
        return 0;
    }

    /**
     * Clears the collection
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        collectionManager.clear();

    }
}
