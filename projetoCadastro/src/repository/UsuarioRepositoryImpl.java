package repository;

import models.Usuario;

import java.util.ArrayList;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    /*optei aqui por nao usar um arraylist de usuarios como atributo,
    * vou salvar as informações diretamente no arquivo e, cada vez
    * que fizer uma transação, um arraylist será implementado dentro do
    * método, garantindo que seja destruído em seguida*/

    @Override
    public boolean addUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean removerUsuario(String cpf) {
        return false;
    }

    @Override
    public Usuario buscarCpf(String cpf) {
        return null;
    }

    @Override
    public void listarUsuarios() {

    }
}
