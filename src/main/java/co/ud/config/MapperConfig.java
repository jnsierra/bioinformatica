package co.ud.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.ud.dto.ArchivoFastaDto;
import co.ud.entity.ArchivoFastaEntity;

@Configuration
public class MapperConfig {
	@Bean
	@Primary
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
	@Bean("mapperArchivoSimple")
	public ModelMapper getMapperArchivoSimple() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<ArchivoFastaEntity, ArchivoFastaDto>() {

			@Override
			protected void configure() {
				skip().setLineas(null);				
			}
		});
		return modelMapper;
	}
}
