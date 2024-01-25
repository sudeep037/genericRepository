package SDET53;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.json.Json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.core.JsonParser.NumberType;

import io.restassured.internal.support.FileReader;

public class fetchDataFromJson {

	public static void main(String[] args)  throws Throwable{
		
		java.io.FileReader filepath = new java.io.FileReader(".\\src\\main\\resources\\jsonReader.json");
		JSONParser json = new JSONParser();
		Object obj = json.parse(filepath);
		Map  map = (JSONObject) obj;
		
		System.out.println(map.get("Browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
}
