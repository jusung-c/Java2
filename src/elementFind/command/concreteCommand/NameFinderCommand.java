package elementFind.command.concreteCommand;

import elementFind.command.FinderCommand;
import elementFind.input.UserInput;
import elementFind.periodic.PeriodicElement;
import elementFind.receiver.IPeriodicElementFinder;
import elementFind.receiver.NameFinder;
import elementFind.receiver.PhaseFinder;

import java.io.IOException;
import java.util.List;

public class NameFinderCommand extends FinderCommand {
    // Receiver - Strategy Pattern 적용
    private IPeriodicElementFinder finder;

    @Override
    public List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException {
        // undo()를 위해 이전 상태 기록
        prevElements = elements;

        // String 배열을 입력받아 NameFinder 생성
        System.out.print("조회하고 싶은 원소의 기호를 공백(' ')을 기준으로 입력하세요. (ex. Mercury, Bromine, ...): ");
        finder = new NameFinder(UserInput.getStringArray());

        // 주어진 원소 리스트 (elements)에서 NameFinder 이용해 조회 후 리턴
        return finder.find(elements);
    }
}
