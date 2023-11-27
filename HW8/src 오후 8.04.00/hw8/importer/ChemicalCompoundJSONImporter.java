package hw8.importer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.CompoundElementInfo;
import hw8.serializer.ChemicalCompoundDeserializer;
import hw8.serializer.CompoundElementInfoDeserializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// JSON 파일을 CemicalCompound 객체 리스트로 불러오거나 JSON 파일로 내보내는 클래스
public class ChemicalCompoundJSONImporter implements FileImporter<ChemicalCompound> {

    @Override
    public List<ChemicalCompound> importFile(String filepath) {
        // 반환할 Element 객체 리스트
        List<ChemicalCompound> list = new ArrayList<>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            StringBuilder jsonString = new StringBuilder();

            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ChemicalCompound.class, new ChemicalCompoundDeserializer())
                    .registerTypeAdapter(CompoundElementInfo.class, new CompoundElementInfoDeserializer())
                    .create();

            // JSON 문자열을 List<ChemicalCompound>으로 역직렬화.
            Type listType = new TypeToken<List<ChemicalCompound>>() {}.getType();
            List<ChemicalCompound> compounds = gson.fromJson(jsonString.toString(), listType);

            list.addAll(compounds);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void exportFile(String filepath, List<ChemicalCompound> list) {}
}
