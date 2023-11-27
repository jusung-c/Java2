package hw8.chemicalCompoundFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.ChemicalCompound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChemicalCompoundSymbolFinder extends AbstractFinder<ChemicalCompound> {
    // 사용자 입력(조건) 받기
    @Override
    protected String getUserInput() {
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find CC Element");
        System.out.print("조회하고 싶은 화합물의 Symbol을 입력하세요 (H20, CO2 ...): ");

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
    protected boolean predicate(ChemicalCompound c, Object input) {
        return c.getSymbol().equals((String) input);
    }
}
