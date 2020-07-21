package com.desafio.pessoaservice.service.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
	
	private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
	
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();
	    addDateProvider(modelMapper);
	    return modelMapper;
	    
	}
	
	public void addDateProvider(ModelMapper modelMapper) {
		Provider<Date> dateProvider = new AbstractProvider<Date>() {
			@Override
			public Date get() {
				return new Date();
			}
		};

		Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
			@Override
			protected Date convert(String source) {
				
				Date date = null;
				try {
					if(source != null) {
						date = format.parse(source);						
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					return null;
				}
				return date;
			}
		};


		modelMapper.createTypeMap(String.class, Date.class);
		modelMapper.addConverter(toStringDate);
		modelMapper.getTypeMap(String.class, Date.class).setProvider(dateProvider);
	}
	
}
