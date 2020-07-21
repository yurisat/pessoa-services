package com.desafio.pessoaservice.persistence.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DataSerializer extends StdSerializer<Date> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataSerializer() {
		super(Date.class);
	}

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if(date != null) {			
			gen.writeString(new SimpleDateFormat("yyyy-MM-dd").format(date));			
		}
		
	}

}
