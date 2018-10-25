package fr.insee.bar.model;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
@SuppressWarnings("serial")
public class ActivityPojoJsonModule extends SimpleModule {

	public ActivityPojoJsonModule() {
		this.addDeserializer(ActivityPojo.class, new ActivityPojoDeserializer());
	}

	public static class ActivityPojoDeserializer extends JsonDeserializer<ActivityPojo> {

		@Override
		public ActivityPojo deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			ObjectCodec codec = parser.getCodec();
			JsonNode node = codec.readTree(parser);
			System.out.println(node);
			if(this.isDrug(node)) {
				return parser.readValueAs(DrugPojo.class);
			}
			return parser.readValueAs(ObservationPojo.class);
		}
		
		private boolean isDrug(JsonNode node) {
			return node.has("drugDisplay");
		}
		
		private boolean isObservation(JsonNode node) {
			return node.has("measurementWeight");
		}
	}
}
