package io.github.felipevaccarini.ecommerce.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String usuario;

    @Email
    @NotBlank
    @Size(max = 254)
    private String email;
}
