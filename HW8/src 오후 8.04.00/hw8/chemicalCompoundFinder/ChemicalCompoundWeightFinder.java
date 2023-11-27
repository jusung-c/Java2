package hw8.chemicalCompoundFinder;

import hw8.finderTemplate.AbstractFinder;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.PeriodicElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChemicalCompoundWeightFinder extends AbstractFinder<ChemicalCompound> {

    // 사용자 입력(조건) 받기
    @Override
    protected double[] getUserInput() {
        double[] input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n>>>> Start Find CC Element");
        System.out.print("조회하고 싶은 화합물의 Weight 범위를 입력하세요(예시: 3~5) : ");

        while (true) {
            try {
                input = Arrays.stream(br.readLine().split("~"))
                        .mapToDouble(Double::parseDouble).toArray();

                if (input.length == 2) {
                    break;
                } else {
                    System.out.println("다시 입력해주세요 (예시: 3~5): ");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Arrays.sort(input);

        return input;
    }

    // 입력받은 조건과 일치하는지 확인
    @Override
    protected boolean predicate(ChemicalCompound e, Object input) {
        double[] d = (double[]) input;
        return (e.getWeight() >= d[0] && e.getWeight() <= d[1]);
    }
}
