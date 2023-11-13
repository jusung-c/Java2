package elementFind;

import elementFind.command.IFinderCommand;
import elementFind.command.FinderCommand;

import java.util.HashMap;
import java.util.Map;

public class FinderCommandDatabase {
    Map<String, IFinderCommand> commands = new HashMap<>();

    public void addCommand(String name, IFinderCommand command) {
        commands.put(name, command);
    }

    public IFinderCommand getCommand(String name) {
        return commands.get(name);
    }
}
