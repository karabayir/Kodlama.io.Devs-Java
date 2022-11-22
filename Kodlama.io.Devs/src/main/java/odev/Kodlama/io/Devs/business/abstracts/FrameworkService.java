package odev.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import odev.Kodlama.io.Devs.business.requests.CreateFrameworkRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import odev.Kodlama.io.Devs.business.responses.CreateFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateFrameworkResponse;

public interface FrameworkService {
	
	List<GetAllFrameworkResponse> getAll();
	
	GetFrameworkResponse getBtName(String name);
	
	GetFrameworkResponse getById(int id);
	
	CreateFrameworkResponse add(CreateFrameworkRequest request); 
	
	UpdateFrameworkResponse update(UpdateFrameworkRequest request);
	
	void delete(int id);

}
