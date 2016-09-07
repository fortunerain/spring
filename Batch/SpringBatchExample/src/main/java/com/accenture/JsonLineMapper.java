package com.accenture;

import org.springframework.batch.item.file.LineMapper;

import com.accenture.model.ResultModel;
import com.accenture.util.JsonUtil;

/**
 * Interpret a line as a Json object and parse it up to a Map. The line should
 * be a standard Json object, starting with "{" and ending with "}" and composed
 * of <code>name:value</code> pairs separated by commas. Whitespace is ignored,
 * e.g.
 * 
 * <pre>
 * { "foo" : "bar", "value" : 123 }
 * </pre>
 * 
 * The values can also be Json objects (which are converted to maps):
 * 
 * <pre>
 * { "foo": "bar", "map": { "one": 1, "two": 2}}
 * </pre>
 * 
 * @author Dave Syer
 * 
 */
public class JsonLineMapper implements LineMapper<ResultModel> {

//	private MappingJsonFactory factory = new MappingJsonFactory();

	/**
	 * Interpret the line as a Json object and create a Map from it.
	 * 
	 * @see LineMapper#mapLine(String, int)
	 */
	@Override
	public ResultModel mapLine(String line, int lineNumber)
			throws Exception {
		/*ResultModel result;
		try {
			JsonParser parser = factory.createJsonParser(line);
			@SuppressWarnings("unchecked")
			ResultModel token = parser.readValueAs(ResultModel.class);
			result = token;
		} catch (Exception e) {
			throw new FlatFileParseException("Cannot parse line to JSON", e, line, lineNumber);
		}*/
		ResultModel result = (ResultModel) JsonUtil.parseJsonString(line, ResultModel.class);
		return result;
	}

}