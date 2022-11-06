package odev.Kodlama.io.Devs.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LanguageDto {
	
	private int id;
	private String name;
	
	private List<FrameworkDto> frameworkList;

}
