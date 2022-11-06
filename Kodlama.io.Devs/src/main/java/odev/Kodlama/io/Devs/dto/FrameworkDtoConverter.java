package odev.Kodlama.io.Devs.dto;

import org.springframework.stereotype.Component;

import odev.Kodlama.io.Devs.model.Framework;

@Component
public class FrameworkDtoConverter {

	public FrameworkDto convert(Framework framework) {
		return new FrameworkDto(framework.getId(), framework.getName());
	}
}
