package Lab7.target;

import Lab7.periodic.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ElementCSVImporter implements FileImporter<Element> {
    // csv 파일에서 데이터를 읽고 그 데이터를 Element 객체 리스트로 만들어 반환
    @Override
    public List<Element> importFile(String filepath) {
        // 반환할 Element 객체 리스트
        List<Element> elist = new ArrayList<Element>();
        String line = "";

        // load data
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // 구분자
            String delimiter = ",";

            // 파일의 끝까지 읽기
            while ((line = br.readLine()) != null) {
                // "#" 이 포함된 line은 continue
                if (line.contains("#")) {
                    continue;
                }

                // 구분자를 기준으로 스플릿
                String[] items = line.split(delimiter);

                // 데이터를 Element 객체로 파싱
                Element e = parse(items);

                // 리스트에 추가
                elist.add(e);
            }

        // 예외 처리
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elist;
    }

    // filepath 위치에 Element 리스트를 csv 파일로 내보내기
    @Override
    public void exportFile(String filepath, List<Element> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))){

            // Element 리스트를 돌면서 파일에 한줄씩 이어쓰기
            for (Element e : list) {
                bw.append(e.getDescription()).append("\n");
            }

        // 예외 처리
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // String 배열을 파싱해 Element 객체로 만들어 반환하는 메소드
    public Element parse(String[] items) {
        try {
            // PeriodicElement 필드값으로 채울 변수 저장
            int number = Integer.parseInt(items[0]);
            String name = items[1];
            String symbol = items[2];
            double weight = Double.parseDouble(items[3]);

            // 파싱한 변수들로 Element 생성 후 반환
            return new Element(number, name, symbol, weight);

            // 예외처리
        } catch (Exception e) {
            System.out.println("\n[ Error 발생!! ]:  " + e.getMessage() + "\n\n");
        }

        return null;
    }
}
