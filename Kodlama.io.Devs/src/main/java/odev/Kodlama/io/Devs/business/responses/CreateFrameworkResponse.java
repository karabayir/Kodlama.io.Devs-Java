package odev.Kodlama.io.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworkResponse {

	private int id;
	private String name;
	private int languageId;
}
