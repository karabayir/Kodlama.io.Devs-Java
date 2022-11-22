package odev.Kodlama.io.Devs.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

	private ModelMapper mapper;

	@Override
	public ModelMapper forResponse() {
		
		mapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return mapper;
	}

	@Override
	public ModelMapper forRequest() {
		
		mapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return mapper;
	}
}
