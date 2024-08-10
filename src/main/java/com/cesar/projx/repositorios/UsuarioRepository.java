package com.cesar.projx.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cesar.projx.modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
