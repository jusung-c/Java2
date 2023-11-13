package elementFind.invoker;

import elementFind.command.IFinderCommand;
import elementFind.periodic.PeriodicElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Invoker
public class FinderInvoker {
    // 설정할 Command 객체를 저장할 필드
    private IFinderCommand command;

    // Command 객체 기록을 가지고 있는 스택
    private final Stack<IFinderCommand> commandHistory = new Stack<>();

    // 실행할 Command 객체 설정
    public void setCommand(IFinderCommand command) {
        this.command = command;
    }

    // 설정한 Command 객체 실행
    public List<PeriodicElement> execute(List<PeriodicElement> elements) throws IOException {
        // 현재 Command 객체를 실행
        List<PeriodicElement> foundElements = command.execute(elements);
        // 현재 Command 객체를 Command 객체 기록을 가진 스택에 추가
        commandHistory.push(command);

        // 실행 결과 반환
        return foundElements;
    }

    // 이전 Command를 취소하고 그 때의 결과를 반환
    public List<PeriodicElement> undo() {
        // Command 명령 기록이 있을 경우
        if (!commandHistory.isEmpty()) {
            // 스택에서 직전 명령어 가져오기
            IFinderCommand lastCommand = commandHistory.pop();
            // undo 실행
            return lastCommand.undo();
        } else {   // Commamnd 스택이 비었을 경우, 즉 이전에 실행된 명령어가 없을 경우
            // 빈 리스트 반환
            return new ArrayList<>();
        }
    }
}
