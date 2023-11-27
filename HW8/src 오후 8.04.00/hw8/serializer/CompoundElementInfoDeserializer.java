package hw8.serializer;

import com.google.gson.*;
import hw8.periodic.CompoundElementInfo;
import hw8.periodic.PeriodicElement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CompoundElementInfoDeserializer implements JsonDeserializer<CompoundElementInfo> {

    @Override
    public CompoundElementInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonObject periodicElementJson = jsonObject.getAsJsonObject("PeriodicElement");
        PeriodicElement periodicElement = context.deserialize(periodicElementJson, PeriodicElement.class);
        int count = jsonObject.get("count").getAsInt();

        return new CompoundElementInfo(periodicElement, count);
    }
}
