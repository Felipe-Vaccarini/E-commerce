package io.github.felipevaccarini.ecommerce.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "usuario" )
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "usuario", length = 50, nullable = false)
    private String usuario;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(name = "senha", length = 128, nullable = false)
    private String senha;

    @Email
    @NotBlank
    @Size(max = 254)
    @Column(length = 254, nullable = false, unique = true)
    private String email;

}


