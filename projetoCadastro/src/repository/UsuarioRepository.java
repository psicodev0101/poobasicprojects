package repository;

import models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void addUsuario(Usuario usuario);
    void removerUsuario(String cpf);
    Usuario buscarCpf(String cpf, List<Usuario> list);
    void listarUsuarios();
}
