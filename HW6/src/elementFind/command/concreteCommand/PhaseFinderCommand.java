package elementFind.command.concreteCommand;

import elementFind.command.FinderCommand;
import elementFind.input.UserInput;
import elementFind.periodic.PeriodicElement;
import elementFind.periodic.Phase;
import elementFind.receiver.IPeriodicElementFinder;
import elementFind.receiver.PhaseFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhaseFinderCommand extends FinderCommand {
    // Receiver - Strategy Pattern 적용
    private IPeriodicElementFinder finder;

    @Override
    public List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException {
        // undo()를 위해 이전 상태 기록
        prevElements = elements;

        // phase를 입력받아 PhaseFinder 생성
        System.out.print("Please enter [phase] of PeriodicElement [e.g. gas, liq, solid, artificial]: ");
        finder = new PhaseFinder(UserInput.getPhase());

        // 주어진 원소 리스트 (elements)에서 PhaseFinder를 이용해 조회 후 리턴
        return finder.find(elements);
    }
}
