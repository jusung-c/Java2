package hw8.importer;

import hw8.periodic.PeriodicElement;
import hw8.periodic.Phase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UnknownFormatConversionException;

public class PeriodicElementCSVImporter implements FileImporter<PeriodicElement>{

	// String 배열을 파싱해 PeriodicElement 객체로 만들어 반환하는 메소드
	public PeriodicElement parse(String[] items) {
		try {
			// PeriodicElement 필드값으로 채울 변수 저장
			int number = Integer.parseInt(items[0]);
            String name = items[1];
            String symbol = items[2];
            double mass = Double.parseDouble(items[3]);
			int period = Integer.parseInt(items[4]);
			int group = items[5].isEmpty() ? -1 : Integer.parseInt(items[5]);
			Phase phase = Phase.valueOf(items[6]);
        	String type = items.length == 7 ? "" : items[7];

			// 파싱한 변수들로 PeriodicElement 생성 후 반환
			return new PeriodicElement(number, name, symbol, mass, period, group, phase, type);

		// 예외처리
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException!");
		} catch (UnknownFormatConversionException e) {
			System.out.println("UnknownFormatConversionException!");
		} catch (IllegalArgumentException e) {
			System.out.print("IllegalArgumentException!");
		}

		return null;
	}
	
	// 지정한 파일을 불러와 파싱한 후 PeriodicElement 리스트로 반환하는 메소드
    public List<PeriodicElement> importFile(String filename) {
    	List<PeriodicElement> list = new ArrayList<PeriodicElement>();
        String line = "";
		
        // load data
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String delimiter = ",";

            while ((line = br.readLine()) != null) {
				// #이 포함된 line은 출력만 해주고 continue
            	if (line.contains("#")) {
            		continue;
            	}

                // use comma as separator
                String[] items = line.split(delimiter);

				// String[] items -> PeriodicElement
                PeriodicElement pe = parse(items);

				// 리스트로 추가
               	list.add(pe); 
            }

		// 예외처리
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		System.out.println();

		return list; 
    }

	@Override
	public void exportFile(String filepath, List<PeriodicElement> list) {

	}
}
