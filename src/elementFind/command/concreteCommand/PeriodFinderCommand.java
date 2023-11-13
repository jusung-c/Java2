package elementFind.command.concreteCommand;

import elementFind.command.FinderCommand;
import elementFind.input.UserInput;
import elementFind.periodic.PeriodicElement;
import elementFind.receiver.IPeriodicElementFinder;
import elementFind.receiver.NumberFinder;
import elementFind.receiver.PeriodFinder;

import java.io.IOException;
import java.util.List;

public class PeriodFinderCommand extends FinderCommand {
    // Receiver - Strategy Pattern 적용
    private IPeriodicElementFinder finder;

    @Override
    public List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException {
        // undo()를 위해 이전 상태 기록
        prevElements = elements;

        // 1~ 7의 원소를 공백을 기준으로 입력받아 PeriodFinder 생성
        System.out.print("조회하고 싶은 원소의 주기를 입력하세요. (1~7 사이의 값이어야 합니다.): ");
        finder = new PeriodFinder(UserInput.getIntegerBetween(1, 7));

        // 주어진 원소 리스트(elements)에서 PeriodFinder를 이용해 조회 후 리턴
        return finder.find(elements);
    }
}
