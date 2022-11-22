package odev.Kodlama.io.Devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFrameworkRequest {

	private int id;
	private String name;
	private int languageId;
}
