package odev.Kodlama.io.Devs.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odev.Kodlama.io.Devs.business.abstracts.FrameworkService;
import odev.Kodlama.io.Devs.business.requests.CreateFrameworkRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import odev.Kodlama.io.Devs.business.responses.CreateFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateFrameworkResponse;
import odev.Kodlama.io.Devs.core.utilities.mapping.ModelMapperService;
import odev.Kodlama.io.Devs.model.Framework;
import odev.Kodlama.io.Devs.repository.FrameworkRepository;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService{
	
	private final FrameworkRepository frameworkRepository;
	private final ModelMapperService mapperService;

	@Override
	public List<GetAllFrameworkResponse> getAll() {
		return frameworkRepository.findAll()
				.stream()
				.map(f-> mapperService.forResponse().map(f, GetAllFrameworkResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetFrameworkResponse getBtName(String name) {
		Framework framework = frameworkRepository.findByName(name); 
		return mapperService.forResponse().map(framework, GetFrameworkResponse.class);
	}

	@Override
	public GetFrameworkResponse getById(int id) {
		Framework framework = frameworkRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(framework, GetFrameworkResponse.class);
	}

	@Override
	public CreateFrameworkResponse add(CreateFrameworkRequest request) {
		Framework framework = mapperService.forRequest().map(request, Framework.class);
		//framework.setId(0);
		frameworkRepository.save(framework);
		return mapperService.forResponse().map(framework, CreateFrameworkResponse.class);
	}

	@Override
	public UpdateFrameworkResponse update(UpdateFrameworkRequest request) {
		Framework framework = mapperService.forRequest().map(request, Framework.class);
		frameworkRepository.save(framework);
		return mapperService.forResponse().map(framework, UpdateFrameworkResponse.class);
	}

	@Override
	public void delete(int id) {
		frameworkRepository.deleteById(id);
		
	}

}
