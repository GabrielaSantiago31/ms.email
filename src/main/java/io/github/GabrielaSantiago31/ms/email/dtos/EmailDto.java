package io.github.GabrielaSantiago31.ms.email.dtos;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailDto {
	
//	@NotBlank
	private String ownerRef;
//	@NotBlank
	@Email
	private String mailFrom;
//	@NotBlank
	@Email
	private String mailTo;
//	@NotBlank
	private String subject;
//	@NotBlank
	private String text;
}
