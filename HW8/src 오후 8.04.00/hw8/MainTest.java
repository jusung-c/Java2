/*
 * 과목: 자바프로그래밍2
 * 교수님: 박경신 교수님
 * 이름: 이주성
 * 학과: 컴퓨터공학과
 * 학번: 32183520
 */

package hw8;

import hw8.chemicalCompoundFinder.*;
import hw8.importer.ChemicalCompoundJSONImporter;
import hw8.periodFinder.*;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.PeriodicElement;
import hw8.importer.PeriodicElementCSVImporter;
import hw8.finderTemplate.AbstractFinder;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public MainTest() {
        // CSV Importer를 사용해 csv 파일을 파싱해 PeriodicElement 리스트로 변환
        List<PeriodicElement> elist = new PeriodicElementCSVImporter().importFile("data/PeriodicElements.csv");

        // 원하는 xxxFinder 추가
        List<AbstractFinder<PeriodicElement>> finders = new ArrayList<>();
//        finders.add(new NumberFinder());
//        finders.add(new NameFinder());
//        finders.add(new SymbolFinder());
//        finders.add(new WeightFinder());
//        finders.add(new PeriodFinder());
//        finders.add(new GroupFinder());
//        finders.add(new PhaseFinder());
//        finders.add(new TypeFinder());

        for (var finder : finders) {
            // 템플릿 메서드 호출
            List<PeriodicElement> found = finder.find(elist);

            if (found.isEmpty()) {
                System.out.println("Not Found.");
            } else {
                found.forEach(System.out::println);
            }
            System.out.println();
        }

        List<ChemicalCompound> clist = new ChemicalCompoundJSONImporter().importFile("data/ChemicalCompounds.json");
        // System.out.println(clist.size());

        // find CC by name, symbol, weight, phase, element (using symbol)
        List<AbstractFinder<ChemicalCompound>> ccfinders = new ArrayList<>();
//        ccfinders.add(new ChemicalCompoundNameFinder());
//        ccfinders.add(new ChemicalCompoundSymbolFinder());
//        ccfinders.add(new ChemicalCompoundWeightFinder());
//        ccfinders.add(new ChemicalCompoundPhaseFinder());
        ccfinders.add(new ChemicalCompoundElementFinder());

        for (var finder : ccfinders) {
            // 템플릿 메서드 호출
            List<ChemicalCompound> found = finder.find(clist);

            if (found.isEmpty()) {
                System.out.println("Not Found.");
            } else {
                found.forEach(System.out::println);
            }
            System.out.println();
        }

    }
}
