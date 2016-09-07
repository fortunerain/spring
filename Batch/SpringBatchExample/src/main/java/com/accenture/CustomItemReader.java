package com.accenture;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.core.io.Resource;

import com.accenture.model.ResultModel;

public class CustomItemReader<T> implements ItemReader<ResultModel>{
	private JsonLineMapper lineMapper;
	private Resource resource;
	private int lineCount = 1;
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public JsonLineMapper getLineMapper() {
		return lineMapper;
	}

	public void setLineMapper(JsonLineMapper lineMapper) {
		this.lineMapper = lineMapper;
	}

	@Override
	public ResultModel read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		//여기서 REST API 호출하여 직접 mapLine으로 던져야한다.
		
		String line = resource.getFilename();

		if (line == null) {
			return null;
		}
		else {
			try {
				if(lineCount > 0) {
					return lineMapper.mapLine(line, lineCount--);
				}
				return null;
			}
			catch (Exception ex) {
				throw new FlatFileParseException("Parsing error at line: " + lineCount + "], input=[" + line + "]", ex, line, lineCount);
			}
		}
	}
}
