package elementFind.command;

import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

// IFinderCommand를 구현하는 추상클래스
// Command 객체 모두가 동일한 undo 로직을 가지고 있으므로 추상클래스로 만들어 코드를 재사용한다.
public abstract class FinderCommand implements IFinderCommand {
    protected List<PeriodicElement> prevElements;

    @Override
    public List<PeriodicElement> undo() {
        return prevElements;
    }
}
