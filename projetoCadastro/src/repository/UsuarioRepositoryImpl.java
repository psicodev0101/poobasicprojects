package repository;

import models.Usuario;

import java.util.ArrayList;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    /*optei aqui por nao usar um arraylist de usuarios como atributo,
    * vou salvar as informações diretamente no arquivo e, cada vez
    * que fizer uma transação, um arraylist será implementado dentro do
    * método, garantindo que seja destruído em seguida*/

    @Override
    public void addUsuario(Usuario usuario) {
        String info = usuario.toString();
        UsuarioData.gravar(info);
    }

    @Override
    public void removerUsuario(String cpf) {
        ArrayList<Usuario> list = UsuarioData.listar();
        int index = 0;
        assert list != null;
        for (Usuario usuario : list) {
            if (usuario.getCpf().equals(cpf)) {
                list.remove(index);
            }
            index++;
        }
        UsuarioData.atualizarDataBase(list);
    }

    @Override
    public Usuario buscarCpf(String cpf) {
        ArrayList<Usuario> list = UsuarioData.listar();
        assert list != null;
        for (Usuario usuario : list) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        System.out.println("ERRO: Nenhum registro encontrado.");
        return null;
    }

    @Override
    public void listarUsuarios() {
        ArrayList<Usuario> list = UsuarioData.listar();
        assert list != null;
        for (Usuario usuario : list) {
            System.out.println(usuario);
        }
    }
}
