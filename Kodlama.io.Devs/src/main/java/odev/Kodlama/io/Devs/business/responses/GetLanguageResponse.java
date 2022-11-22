package odev.Kodlama.io.Devs.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLanguageResponse {

	private int id;
	private String name;
	private List<GetAllFrameworkResponse> frameworks;
}
