import models.Contribuinte;
import models.ContribuinteCnpj;
import models.ContribuinteCpf;
import models.DatabaseLeao;
import services.NovoCadastroService;

public class Main {
    public static void main(String[] args) {

        DatabaseLeao databaseLeao = new DatabaseLeao();
        NovoCadastroService novoCadastroService = new NovoCadastroService(databaseLeao);

        Contribuinte contribTesteA = new ContribuinteCpf("Rosane", 2650D, 320D);
        Contribuinte contribTesteB = new ContribuinteCpf("Edilberto", 1420D, 120D);
        Contribuinte contribTesteC = new ContribuinteCpf("Roosevelt", 4500D, 650D);

        Contribuinte contribTesteD = new ContribuinteCnpj("Microsoft", 102000D, 50);
        Contribuinte contribTesteE = new ContribuinteCnpj("BMI", 50000D, 10);
        Contribuinte contribTesteF = new ContribuinteCnpj("BYD", 10250D, 8);

        novoCadastroService.cadastrar(contribTesteA);
        novoCadastroService.cadastrar(contribTesteB);
        novoCadastroService.cadastrar(contribTesteC);
        novoCadastroService.cadastrar(contribTesteD);
        novoCadastroService.cadastrar(contribTesteE);
        novoCadastroService.cadastrar(contribTesteF);

        databaseLeao.calcularImpostometro();

    }

}
