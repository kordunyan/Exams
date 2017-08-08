package com.exams.serializer;

import com.exams.entity.Exam;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by sanya on 08.08.2017.
 */
public class ExamSerializer implements JsonSerializer<Exam> {

	@Override
	public JsonElement serialize(Exam exam, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject result = new JsonObject();

		result.addProperty("mark", exam.getMark());
		result.add("createDate", jsonSerializationContext.serialize(exam.getCreateDate()));
		return result;
	}
}
