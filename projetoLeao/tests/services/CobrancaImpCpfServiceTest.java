package services;

import models.Contribuinte;
import models.ContribuinteCnpj;
import models.ContribuinteCpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaImpCpfServiceTest {

    //contribuinte tipo cpf
    Contribuinte contribTesteA = new ContribuinteCpf("Adailson", 1500D, 250D);
    Contribuinte contribTesteB = new ContribuinteCpf("Adalberto", 2500D, 500D);
    Contribuinte contribTesteC = new ContribuinteCpf("Adalvano", 4500D, 340D);


    @Test
    void calcularImpostoTest() {
        //teste de calculo para imposto de contribuinte cpf
        assertEquals(100D, new CobrancaImpCpfService().calcularImposto(contribTesteA));
        assertEquals(375D, new CobrancaImpCpfService().calcularImposto(contribTesteB));
        assertEquals(955D, new CobrancaImpCpfService().calcularImposto(contribTesteC));
    }

}