package hw8.periodFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.PeriodicElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberFinder extends AbstractFinder<PeriodicElement> {

    // 사용자 입력(조건) 받기
    @Override
    protected Integer getUserInput() {
        int input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find Element");
        System.out.print("조회하고 싶은 원소의 Number를 입력하세요(1 ~ 118): ");

        // 1~118 사이의 숫자 입력받을때까지
        while (true) {
            try {
                input = Integer.parseInt(br.readLine());

                if (input >= 1 && input <= 118) {
                    break;
                } else {
                    System.out.print("1과 118 사이의 값을 입력해주세요: ");
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
        return e.getNumber() == (int) input;
    }
}
