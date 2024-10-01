package repository;

import models.Usuario;

public interface UsuarioRepository {
    boolean addUsuario(Usuario usuario);
    boolean removerUsuario(String cpf);
    Usuario buscarCpf(String cpf);
    void listarUsuarios();
}
