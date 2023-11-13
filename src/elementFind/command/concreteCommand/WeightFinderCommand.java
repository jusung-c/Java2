package elementFind.command.concreteCommand;

import elementFind.command.FinderCommand;
import elementFind.input.UserInput;
import elementFind.periodic.PeriodicElement;
import elementFind.receiver.IPeriodicElementFinder;
import elementFind.receiver.NumberFinder;
import elementFind.receiver.WeightFinder;

import java.io.IOException;
import java.util.List;

public class WeightFinderCommand extends FinderCommand {
    // Receiver - Strategy Pattern 적용
    private IPeriodicElementFinder finder;

    @Override
    public List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException {
        // undo()를 위해 이전 상태 기록
        prevElements = elements;

        // 질량 범위를 입력받아 WeightFinder 생성
        System.out.print("조회하고 싶은 원소의 질량 범위를 물결('~')을 기준으로 입력하세요. : ");
        finder = new WeightFinder(UserInput.getDoubleArray());

        // 주어진 원소 리스트(elements)에서 WeightFinder를 이용해 조회 후 리턴
        return finder.find(elements);
    }
}
