package hw8.chemicalCompoundFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.CompoundElementInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChemicalCompoundElementFinder extends AbstractFinder<ChemicalCompound> {
    // 사용자 입력(조건) 받기
    @Override
    protected String getUserInput() {
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find CC Element");
        System.out.println("해당 원소를 1개라도 포함하고 있는 화합물을 조회합니다.");
        System.out.print("조회하고 싶은 원소를 입력하세요(H,O, ...): ");

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
        for (CompoundElementInfo ce : c.getCompounds()) {
            if (ce.getElement().getSymbol().equals((String) input)) {
                return true;
            }
        }
        return false;
    }
}