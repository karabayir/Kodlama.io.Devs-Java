package odev.Kodlama.io.Devs.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forResponse();
	ModelMapper forRequest();
}
