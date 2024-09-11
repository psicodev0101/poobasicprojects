### Projeto Leão
---
`REQUISITOS`
1. `Funcionalidade:` O software deve ser capaz de cadastrar um usuário requisitando a inserção de tipo (cpf ou cnpj), nome e renda anual, além de informar a quantia gasta com saúde (caso CPF), ou quantidade de funcionários (caso CNPJ). Deve calcular automaticamente a taxa de imposto que será paga pelo contribuinte e informar qual o valor total arrecadado no impostômetro.

3. `Regras de negócio`: O cálculo do valor da arrecadação de cada contribuinte será feita de acordo com o tipo de cadastro informado:
2.1 `CPF:` Caso a renda anual seja até 20.000,00 reais, a taxa cobrada será 15%. Caso superior, a taxa será 25%. Caso o contribuinte possua gastos com saúde, serão deduzidos 50% desse valor da taxa devida.
2.2 `CNPJ:` Pessoa jurídica, independentemente do valor da renda anual, será taxada em 16%. Caso, entretanto, a quantidade de funcionários seja maior que 10, a taxa será reduzida para 14%.
