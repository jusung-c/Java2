package Lab7.adaptee;

import Lab7.periodic.Element;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// JSON 파일에서 데이터를 읽고 그 데이터를 Element 객체로 변환
public class ElementJSONLoader implements FileLoader<Element> {

    @Override
    public List<Element> load(String filepath) {
        // 반환할 Element 객체 리스트
        List<Element> elist = new ArrayList<Element>();
        String line = "";

        // Gson 라이브러리 사용
        Gson gson = new Gson();

        // load data
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            StringBuilder jsonString = new StringBuilder();

            // 파일의 끝까지 읽기
            while ((line = br.readLine()) != null) {
                // JSON 파일을 읽어와서 문자열로 저장
                jsonString.append(line);
            }

            // JSON 문자열을 List<Element> 객체로 변환
            Type elementType = new TypeToken<List<Element>>(){}.getType();
            elist = gson.fromJson(jsonString.toString(), elementType);

        // 예외 처리
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elist;
    }

    @Override
    public void save(String filepath, List<Element> list) {
        // Gson 라이브러리 사용
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            // List<Element> 객체를 JSON 문자열로 변환 후 파일에 쓰기
            gson.toJson(list, bw);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
