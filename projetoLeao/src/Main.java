import models.ContribuinteCnpj;
import models.ContribuinteCpf;
import models.DatabaseLeao;
import services.NovoCadastroService;

public class Main {
    public static void main(String[] args) {

        DatabaseLeao databaseLeao = new DatabaseLeao();
        NovoCadastroService novoCadastroService = new NovoCadastroService(databaseLeao);

        novoCadastroService.cadastrar(new ContribuinteCpf("Rosane", 2650D, 320D));
        novoCadastroService.cadastrar(new ContribuinteCpf("Edilberto", 1420D, 120D));
        novoCadastroService.cadastrar(new ContribuinteCpf("Roosevelt", 4500D, 650D));
        novoCadastroService.cadastrar(new ContribuinteCnpj("Microsoft", 102000D, 50));
        novoCadastroService.cadastrar(new ContribuinteCnpj("BMI", 50000D, 10));
        novoCadastroService.cadastrar(new ContribuinteCnpj("BYD", 10250D, 8));

        databaseLeao.calcularImpostometro();
    }

}
