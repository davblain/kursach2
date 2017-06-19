package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Component
	public class CalendarSerializer extends JsonSerializer<Calendar> {



		@Override
		public void serialize(Calendar calendar, JsonGenerator jsonGenerator,
							  SerializerProvider serializerProvider) throws IOException {

			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField("day", calendar.get(Calendar.DAY_OF_MONTH));
			jsonGenerator.writeNumberField("month", calendar.get(Calendar.MONTH)+1);
			jsonGenerator.writeNumberField("year", calendar.get(Calendar.YEAR));
			jsonGenerator.writeEndObject();
		}
	}

	@Component
	public class CalendarDeserializer extends JsonDeserializer<Calendar> {
		@Override
		public Calendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

			ObjectCodec oc = jsonParser.getCodec();
			JsonNode node = oc.readTree(jsonParser);
			Calendar rez =Calendar.getInstance();
			rez.set(node.get("year").asInt(),node.get("month").asInt(),node.get("day").asInt());
			return rez;
		}
	}

	}
