package commands;

import utility.CollectionManager;

import java.util.List;
/**
 * The command class for info.
 */
public class Info extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Info(CollectionManager collection) {
        super(collection);
    }


    /**
     * Print information about collection(Type, data of init and count of objects).
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {

        String s = "Type of Collection - TreeSet" + "\n" +
                "Date of init - " + collectionManager.getInitTime() + "\n" +
                "Count of object in Collection - " + collectionManager.size();

        System.out.println(s);

    }
}
