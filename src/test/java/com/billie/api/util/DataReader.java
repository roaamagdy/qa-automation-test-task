package com.billie.api.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author ROMA1
 *  This class is responsible for reading "Data" json file and parse it into Json Object 
 * */

public class DataReader {

	JSONObject jsonObj;
	JSONParser parser;
	HashMap<String, String> objectData;

	public DataReader() {
		try {
			parser = new JSONParser();
			jsonObj = (JSONObject) parser
					.parse(new FileReader(System.getProperty("user.dir") + "/resources/Data.json"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  This method responsible for mapping data in JSON file to map to be easily accessed by the key
	 *  */
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getData(String object) {
		objectData = new HashMap<String, String>();
		objectData = ((HashMap<String, String>) jsonObj.get(object));
		return objectData;
	}
}
