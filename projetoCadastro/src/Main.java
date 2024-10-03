import models.Usuario;
import repository.UsuarioData;

public class Main {
    public static void main(String[] args) {
        Usuario teste = new Usuario("teste", "02206658267", 27);
        UsuarioData.gravar(teste.toString());
        System.out.println(UsuarioData.ler());
    }

// estou criando usuarioRepository. Criei o metodo carregarUsuarios. Implementei
    //os metodos gravar, ler e gerar tabela. verificar o que mais precisa alem disso

}



