package repository;

import models.Usuario;

public interface UsuarioRepository {
    void addUsuario(Usuario usuario);
    void removerUsuario(String cpf);
    Usuario buscarCpf(String cpf);
    void listarUsuarios();
}
