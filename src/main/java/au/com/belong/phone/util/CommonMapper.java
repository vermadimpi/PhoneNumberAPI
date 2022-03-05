package au.com.belong.phone.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import au.com.belong.phone.model.Phone;
import au.com.belong.phone.dto.PhoneDto;

@Component
public class CommonMapper {

	private ModelMapper modelMapper;

	public CommonMapper() {
		modelMapper = new ModelMapper();
	}

	public PhoneDto convert(Phone phone) {
		return modelMapper.map(phone, PhoneDto.class);
	}
}