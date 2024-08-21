package io.github.felipevaccarini.ecommerce.api.dto;

import io.github.felipevaccarini.ecommerce.domain.entity.Usuario;
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

    @NotBlank
    @Size(min = 8, max= 128)
    private String senha;

    @Email
    @NotBlank
    @Size(max = 254)
    private String email;

    public static UsuarioDTO fromEntity(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getSenha(),
                usuario.getEmail()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setUsuario(dto.getUsuario());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }
}
