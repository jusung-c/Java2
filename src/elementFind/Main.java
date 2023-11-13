package elementFind;/*
 * 과목: 자바프로그래밍2
 * 교수님: 박경신 교수님
 * 이름: 이주성
 * 학과: 컴퓨터공학과
 * 학번: 32183520
 * */

import elementFind.command.concreteCommand.*;
import elementFind.input.UserInput;
import elementFind.invoker.FinderInvoker;
import elementFind.periodic.PeriodicElement;
import elementFind.periodic.PeriodicElementImporter;
import elementFind.receiver.IPeriodicElementFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<PeriodicElement> deepCopy(List<PeriodicElement> list) {
        return new ArrayList<>(list);
    }

    public static void main(String[] args) throws IOException {
        // PeriodicElements.csv 파일을 load해서 PeriodicElement 리스트로 저장
        List<PeriodicElement> peList = PeriodicElementImporter.loadCSV("PeriodicElements.csv");

        // invoker class
        FinderInvoker invoker = new FinderInvoker();

        // incremental finder
        FinderCommandDatabase database = new FinderCommandDatabase();
        database.addCommand("phase", new PhaseFinderCommand());
        database.addCommand("number", new NumberFinderCommand());
        database.addCommand("group", new GroupFinderCommand());
        database.addCommand("name", new NameFinderCommand());
        database.addCommand("period", new PeriodFinderCommand());
        database.addCommand("weight", new WeightFinderCommand());
        database.addCommand("symbol", new SymbolFinderCommand());

        // create foundList
        List<PeriodicElement> foundList = deepCopy(peList);

        do {
            // 원하는 Command 입력 받기 - 유효한 Coammand인지 검증까지 해줌
            System.out.print("Please enter command [e.g. number | name | symbol | weight | period | group | phase | undo]: ");
            String commandName = UserInput.getCommandString();

            // 입력받은 명령이 "undo"일 경우
            if (commandName.equalsIgnoreCase("undo")) {
                // invoker의 undo 실행 -> 커맨드 패턴
                // 이전 명령어 스택에서 꺼내 undo를 실행한다.
                foundList = invoker.undo();

                // undo()의 결과로 빈 리스트가 반환되었다면 다시 deepCopy
                if (foundList == null || foundList.isEmpty()) {
                    foundList = deepCopy(peList);
                }

            } else {
                // invoker에 command 객체 설정
                invoker.setCommand(database.getCommand(commandName));

                // invoker의 execute()를 실행해 설정한 command 객체의 execute()를 실행시켜준다. -> 커맨드 패턴
                foundList = invoker.execute(foundList);
            }

            // 출력
            foundList.forEach(System.out::println);

        } while (!UserInput.getExitKey()); // exit 입력받으면 종료
    }
}