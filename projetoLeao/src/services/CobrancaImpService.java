package services;

import models.Contribuinte;

public interface CobrancaImpService {
    double calcularImposto(Contribuinte contribuinte);
}
