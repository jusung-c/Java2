/*
 * 과목: 자바프로그래밍2
 * 교수님: 박경신 교수님
 * 이름: 이주성
 * 학과: 컴퓨터공학과
 * 학번: 32183520
 * */

package Lab7;


import Lab7.adaptee.ElementJSONLoader;
import Lab7.adaptee.ElementXMLLoader;
import Lab7.adapter.FileLoaderImporterAdapter;
import Lab7.adapter.ListDataCollectionAdapter;
import Lab7.periodic.Element;
import Lab7.periodic.PeriodicElement;
import Lab7.periodic.PeriodicElementImporter;
import Lab7.target.DataCollection;
import Lab7.target.DynamicArray;
import Lab7.target.ElementCSVImporter;
import Lab7.target.FileImporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {
    public MainTest() {
        // PeriodicElements.csv 파일을 load해서 PeriodicElement 리스트로 저장
        List<PeriodicElement> peList = PeriodicElementImporter.loadCSV("ElementsCSVJSONXML/PeriodicElements.csv");

        System.out.println(">>>>>>>>>> [DataCollection Test] <<<<<<<<<<\n");

        // DataCollection<Element> 배열 초기화
        DataCollection<Element> dataCollection = new DynamicArray<>();

        // 배열에 Element 원소 추가 - put()
        for (PeriodicElement e : peList) {
            dataCollection.put(new Element(e.getNumber(), e.getName(), e.getSymbol(), e.getWeight()));
        }

        //        arrayList.forEach(System.out::println);

        System.out.println("===== put =====");
        System.out.println("put()을 모두 마친 후 요소의 개수: " + dataCollection.length());

        // 배열 0번째 원소 삭제 후 요소의 개수 출력 - remove()
        dataCollection.remove(0);
        System.out.println("===== remove =====");
        System.out.println("0번째 원소 삭제 후 요소의 개수: " + dataCollection.length() + "\n");

        // 배열의 5번째에 커스텀 Element 추가 후 요소의 개수 출력
        dataCollection.insert(5, new Element(0, "No", "N", 0L));
        System.out.println("===== insert =====");
        System.out.println("index 5에 삽입한 후 요소의 개수: " + dataCollection.length() + "\n");

        // 5번째에 넣은 요소 확인하기 - elemAt()
        Element e1 = dataCollection.elemAt(5);
        System.out.println("===== elemAt =====");
        System.out.println("삽입한 원소:" + e1.getNumber() + ", "
                + e1.getName() + ", "
                + e1.getSymbol() + ", "
                + e1.getWeight() + "\n");

        // 배열 전부 삭제 후 요소의 개수 확인- clear()
        dataCollection.clear();
        System.out.println("===== clear =====");
        System.out.println("배열 clear 후 요소의 개수: " + dataCollection.length() + "\n");


        System.out.println("\n\n>>>>>>>>>> [ArrayList -> DataCollection Test] <<<<<<<<<<\n");

        // ArrayList 생성
        List<Element> arrayList = new ArrayList<>();

        // ArrayList(Adaptee)를 ListDataCollectionAdapter(Adapter)를 이용해 DataCollection(Target)으로 사용하기
        DataCollection<Element> arrayDataList = new ListDataCollectionAdapter<>(arrayList);

        // 원소 put
        peList.forEach(e -> arrayDataList.put(new Element(e.getNumber(), e.getName(),
                e.getSymbol(), e.getWeight())));
        System.out.println("===== put =====");
        System.out.println("put()을 모두 마친 후 요소의 개수: " + dataCollection.length());

        // 배열 0번째 원소 삭제 후 요소의 개수 출력 - remove()
        arrayDataList.remove(0);
        System.out.println("===== remove =====");
        System.out.println("0번째 원소 삭제 후 요소의 개수: " + arrayDataList.length() + "\n");

        // 배열의 5번째에 커스텀 Element 추가 후 요소의 개수 출력
        arrayDataList.insert(5, new Element(0, "No", "N", 0L));
        System.out.println("===== insert =====");
        System.out.println("index 5에 삽입한 후 요소의 개수: " + arrayDataList.length() + "\n");

        // 5번째에 넣은 요소 확인하기 - elemAt()
        Element e2 = arrayDataList.elemAt(5);
        System.out.println("===== elemAt =====");
        System.out.println("삽입한 원소:" + e2.getNumber() + ", "
                + e2.getName() + ", "
                + e2.getSymbol() + ", "
                + e2.getWeight() + "\n");

        // 배열 전부 삭제 후 요소의 개수 확인- clear()
        arrayDataList.clear();
        System.out.println("===== clear =====");
        System.out.println("배열 clear 후 요소의 개수: " + arrayDataList.length() + "\n");


        System.out.println("\n\n>>>>>>>>>> [Stack -> DataCollection Test] <<<<<<<<<<\n");

        // ArrayList 생성 후 Element 추가
        List<Element> stack = new Stack<>();

        // ArrayList(Adaptee)를 ListDataCollectionAdapter(Adapter)를 이용해 DataCollection(Target)으로 사용하기
        DataCollection<Element> stackDataLlist = new ListDataCollectionAdapter<>(stack);
        peList.forEach(e -> stackDataLlist.put(new Element(e.getNumber(), e.getName(),
                e.getSymbol(), e.getWeight())));


        // 배열 0번째 원소 삭제 후 요소의 개수 출력 - remove()
        stackDataLlist.remove(0);
        System.out.println("===== remove =====");
        System.out.println("0번째 원소 삭제 후 요소의 개수: " + stackDataLlist.length() + "\n");

        // 배열의 5번째에 커스텀 Element 추가 후 요소의 개수 출력
        stackDataLlist.insert(5, new Element(0, "No", "N", 0L));
        System.out.println("===== insert =====");
        System.out.println("index 5에 삽입한 후 요소의 개수: " + stackDataLlist.length() + "\n");

        // 5번째에 넣은 요소 확인하기 - elemAt()
        Element e3 = stackDataLlist.elemAt(5);
        System.out.println("===== elemAt =====");
        System.out.println("삽입한 원소:" + e3.getNumber() + ", "
                + e3.getName() + ", "
                + e3.getSymbol() + ", "
                + e3.getWeight() + "\n");

        // 배열 전부 삭제 후 요소의 개수 확인- clear()
        stackDataLlist.clear();
        System.out.println("===== clear =====");
        System.out.println("배열 clear 후 요소의 개수: " + stackDataLlist.length() + "\n");

        // ElementJSONLoader - Import
        FileImporter<Element> importer = new FileLoaderImporterAdapter<>(new ElementJSONLoader());
        List<Element> elements = importer.importFile("ElementsCSVJSONXML/Elements.json");
        // elements.forEach(System.out::println);
        System.out.println("\nElementJSONLoader Load Elements Size: " + elements.size());

        // ElementJSONLoader - Export
        System.out.println("\n[ JSON File Export: ElementsCSVJSONXML/myJSON.json ]");
        importer.exportFile("ElementsCSVJSONXML/myJSON.json", elements);

        // ElementXMLLoader - Import
        importer = new FileLoaderImporterAdapter<>(new ElementXMLLoader());
        elements = importer.importFile("ElementsCSVJSONXML/Elements.xml");
        // elements.forEach(System.out::println);
        System.out.println("\nElementXMLLoader Load Elements Size: " + elements.size());

        // ElementXMLLoader - Export
        System.out.println("\n[ XML File Export: ElementsCSVJSONXML/myXML.xml ]");
        importer.exportFile("ElementsCSVJSONXML/myXML.xml", elements);

        // ElementCSVImporter - Import
        importer = new ElementCSVImporter();
        elements = importer.importFile("ElementsCSVJSONXML/Elements.csv");
        // elements.forEach(System.out::println);
        System.out.println("\nElementCSVImporter Load Elements Size: " + elements.size());

        // ElementCSVImporter - Export
        System.out.println("\n[ CSV File Export: ElementsCSVJSONXML/myCSV.csv ]");
        importer.exportFile("ElementsCSVJSONXML/myElements.csv", elements);
    }
}
