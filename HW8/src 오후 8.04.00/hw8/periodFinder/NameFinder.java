package hw8.periodFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.PeriodicElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameFinder extends AbstractFinder<PeriodicElement> {

    // 사용자 입력(조건) 받기
    @Override
    protected String getUserInput() {
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find Element");
        System.out.print("조회하고 싶은 원소의 Name을 입력하세요: ");

        while (true) {
            try {
                input = br.readLine();

                if (input != null) {
                    break;
                } else {
                    System.out.print("다시 입력해주세요: ");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return input;
    }

    // 입력받은 조건과 일치하는지 확인
    @Override
    protected boolean predicate(PeriodicElement e, Object input) {
        return e.getName().equals((String) input);
    }
}
