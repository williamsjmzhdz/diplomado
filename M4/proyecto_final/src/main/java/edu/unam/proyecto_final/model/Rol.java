package edu.unam.proyecto_final.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioRol> usuariosRoles = new HashSet<>();

}
