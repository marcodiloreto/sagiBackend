package application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaViewDto {
	
	private Long ID;
	private String nombre;
	private String fotoURL;
}
