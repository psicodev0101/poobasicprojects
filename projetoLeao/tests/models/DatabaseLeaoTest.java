package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseLeaoTest {

    DatabaseLeao databaseLeao = new DatabaseLeao();
    Contribuinte contribTesteA = new ContribuinteCpf("Adailson", 1500D, 250D);
    Contribuinte contribTesteD = new ContribuinteCnpj("OdontoVida", 52000D, 50);


    @Test
    void guardarContribuinteTest() {

        databaseLeao.guardarContribuinte(contribTesteA);
        databaseLeao.guardarContribuinte(contribTesteD);

        assertEquals(databaseLeao.getContribuintesCpf().getFirst(), contribTesteA);
        assertEquals(databaseLeao.getContribuintesCnpj().getFirst(), contribTesteD);
    }

    @Test
    void calcularImpostometroTeste() {

        contribTesteA.taxa = 200D;
        contribTesteD.taxa = 200D;
        databaseLeao.guardarContribuinte(contribTesteA);
        databaseLeao.guardarContribuinte(contribTesteD);

        databaseLeao.calcularImpostometro();
        assertEquals(400D, databaseLeao.getImpostometro(), 0.001D);

    }

}