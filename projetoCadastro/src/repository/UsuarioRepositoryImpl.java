package repository;

import models.Usuario;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Usuario> list = null; // inserir aqui funçao que implementa usuarios;

        assert list != null;
        for (Usuario usuario : list) {
            if (usuario.getCpf().equals(cpf)) {
                list.remove(usuario);
            }
        }
        UsuarioData.sincronizarDataBase(list);

        /*esse metodo pode ser resumido atraves do metodo de List (Collections):
        * list.removeIf(usuario -> usuario.getCpf().equals(cpf));
        * */
    }

    @Override
    public Usuario buscarCpf(String cpf) {
        List<Usuario> list = carregarUsuarios();
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
        //ArrayList<Usuario> list = UsuarioData.listar();
        //assert list != null;
        /*comentei os comandos acima e passei o listar() direto pro foreach
        * testar isso pra ver se o metodo nao vai acabar chamando a listagem
        * repetidamente a cada iteração*/
        for (String usuario : UsuarioData.ler()) {
            System.out.println(usuario);
        }
    }

    public List<Usuario> carregarUsuarios() {
        List<String[]> tabela = UsuarioData.gerarTabela();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (String[] dados : tabela) {
            String nome = dados[0];
            String cpf = dados[1];
            int idade = Integer.parseInt(dados[2]);
            Usuario usuario = new Usuario(nome, cpf, idade);
            usuarios.add(usuario);
        }
        return usuarios;
    }


}
