/**
 * @author Бекмухаметов Владислав
 * @version 1.0
 */

import utility.*;

/**
 * Main class
 */
public class Main {
    static final CollectionManager collectionManager = new CollectionManager();

    /**
     * Main
     *
     * @param args - Command line input
     */
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser(collectionManager, args);
        csvParser.startParse();
        CommandReader commandReader = new CommandReader(collectionManager,new Invoker(collectionManager));
        commandReader.read();
    }
}