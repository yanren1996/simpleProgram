package cyr;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonUility {
	public static JsonObject data(String s,boolean b) {
		JsonObject json=new JsonObject();
		json.add("msg", new JsonPrimitive(s));
		json.addProperty("display", b);
		return json;
	}
	
	public static void main(String[] args) {
		System.out.println(JsonUility.data("測試",true));
	}

}
