package elementFind.command;

import elementFind.periodic.PeriodicElement;

import java.io.IOException;
import java.util.List;

// Command interface
public interface IFinderCommand {
	List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException;

	List<PeriodicElement> undo();
}
