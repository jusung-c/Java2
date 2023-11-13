package elementFind.periodic;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UnknownFormatConversionException;

public class PeriodicElementImporter {
	
	private PeriodicElementImporter() {}	

	// String 배열을 파싱해 PeriodicElement 객체로 만들어 반환하는 메소드
	public static elementFind.periodic.PeriodicElement parse(String[] items) {
		try {
			// PeriodicElement 필드값으로 채울 변수 저장
			int number = Integer.parseInt(items[0]);
            String name = items[1];
            String symbol = items[2];
            double mass = Double.parseDouble(items[3]);
			int period = Integer.parseInt(items[4]);
			int group = items[5].isEmpty() ? 0 : Integer.parseInt(items[5]);
			Phase phase = elementFind.periodic.Phase.valueOf(items[6]);
        	String type = items.length == 7 ? "" : items[7];

			// 파싱한 변수들로 PeriodicElement 생성 후 반환
			return new elementFind.periodic.PeriodicElement(number, name, symbol, mass, period, group, phase, type);

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
    public static List<elementFind.periodic.PeriodicElement> loadCSV(String filename) {
    	List<elementFind.periodic.PeriodicElement> list = new ArrayList<elementFind.periodic.PeriodicElement>();
        String line = "";
		
        // load data
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	System.out.println("file import: " + filename);

			String delimiter = ",";

            while ((line = br.readLine()) != null) {
				// #이 포함된 line은 출력만 해주고 continue
            	if (line.contains("#")) {
            		System.out.println("line contains #: " + line);
            		continue;
            	}

                // use comma as separator
                String[] items = line.split(delimiter);

				// String[] items -> PeriodicElement
                elementFind.periodic.PeriodicElement pe = parse(items);

				// 리스트로 추가
               	list.add(pe); 
            }

		// 예외처리
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		System.out.println("load successfully");
		System.out.println();

		return list; 
    }
}
