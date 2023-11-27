package hw8.periodFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.PeriodicElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupFinder extends AbstractFinder<PeriodicElement> {

    // 사용자 입력(조건) 받기
    @Override
    protected Integer getUserInput() {
        int input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find Element");
        System.out.print("조회하고 싶은 원소의 Group을 입력하세요(1 ~ 18 혹은 null일 경우 -1을 입력): ");

        while(true) {
            try {
                input = Integer.parseInt(br.readLine());

                if ((input >= 1 && input <= 18) || input == -1) {
                    break;
                } else {
                    System.out.print("1 ~ 18 범위 또는 -1의 값을 입력해주세요: ");
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
        return e.getGroup() == (int) input;
    }
}
