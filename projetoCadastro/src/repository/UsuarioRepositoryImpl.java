package repository;

import models.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    /*optei aqui por nao usar um arraylist de usuarios como atributo,
    * vou salvar as informações diretamente no arquivo e, cada vez
    * que fizer uma transação, um arraylist será implementado dentro do
    * método, garantindo que seja destruído em seguida*/

    @Override
    public void addUsuario(Usuario usuario) {



    }

    @Override
    public void removerUsuario(String cpf) {
    }

    @Override
    public Usuario buscarCpf(String cpf) {
        return null;
    }

    @Override
    public void listarUsuarios() {

    }
}
