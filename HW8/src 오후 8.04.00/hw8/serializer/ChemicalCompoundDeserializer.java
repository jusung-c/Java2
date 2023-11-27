package hw8.serializer;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.CompoundElementInfo;
import hw8.periodic.Phase;

import java.lang.reflect.Type;
import java.util.List;

// JSON 문자열 -> ChemicalCompound 객체 역직렬화
public class ChemicalCompoundDeserializer implements JsonDeserializer<ChemicalCompound>{
    private final Gson gson = new Gson();

    @Override
    public ChemicalCompound deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        String symbol = jsonObject.get("symbol").getAsString();
        Phase phase = Phase.names(jsonObject.get("phase").getAsString());

        JsonArray compoundsArray = jsonObject.getAsJsonArray("compounds");
        List<CompoundElementInfo> compounds = context.deserialize(compoundsArray, new TypeToken<List<CompoundElementInfo>>() {}.getType());

        // ChemicalCompound 객체를 생성하고 반환
        return new ChemicalCompound(name, symbol, compounds, phase);
    }
}
