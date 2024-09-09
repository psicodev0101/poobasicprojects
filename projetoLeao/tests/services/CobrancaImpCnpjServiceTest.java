package services;

import models.Contribuinte;
import models.ContribuinteCnpj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaImpCnpjServiceTest {

    //contribuinte tipo cnpj
    Contribuinte contribTesteD = new ContribuinteCnpj("OdontoVida", 52000D, 50);
    Contribuinte contribTesteE = new ContribuinteCnpj("OdontoBem", 14000D, 10);
    Contribuinte contribTesteF = new ContribuinteCnpj("OdontoLife", 10250D, 8);

    @Test
    void calcularImpostoTest() {
        //teste de calculo para imposto de contribuinte cnpj
        assertEquals(7280D, new CobrancaImpCnpjService().calcularImposto(contribTesteD));
        assertEquals(2240D, new CobrancaImpCnpjService().calcularImposto(contribTesteE));
        assertEquals(1640D, new CobrancaImpCnpjService().calcularImposto(contribTesteF));
    }
}