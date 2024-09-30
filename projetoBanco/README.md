## Projeto BANCO - Java POO
Projeto pessoal desenvolvido para fins de estudos em POO com java, 
visando a prática de conceitos fundamentais como classes, interfaces
herança, polimorfismo, abstração, encapsulamento, métodos, listas
organização de diretórios, injeção de dependências e afins.

### 1. Objetivo
Desenvolver um sistema bancário que permita a realização de saques 
por dois métodos distintos: Saque via Caixa Eletrônico e Saque via Pix.
O sistema deve ser flexível e extensível, utilizando o conceito de Injeção 
de Dependência para facilitar a troca entre os métodos de saque sem alterar 
o código da classe principal.

Módulo de Conta Bancária:



### 2. Escopo do projeto
> **2.1. Sistema de Contas Bancárias:**
> 
> - Deve permitir o depósito e saque de valores.
> - Deve utilizar as mesmas classes para receber diversas modalidades de saque via injeção de dependências.
>
> **2.2. Modalidades de saque**
> 
> - **Saque via Caixa Eletrônico:** Cobra uma taxa fixa pré definida por saque.
> - **Saque via pix:** É gratuito, porém limitado a 10 saques por conta (devido aos fins da prática, não implementei mecanismos que restaurem a contagem).

### 3. Requisitos

> **3.1. Requisitos Funcionais (RF):**
>
> - **RF01:** O sistema deve permitir que o usuário realize saques: 
>   - O sistema deve aceitar diferentes métodos de saque.
>   - O sistema deve ser capaz de alternar entre métodos de saque em tempo de execução.
> - **RF02:** O sistema deve aplicar uma taxa pré-definida para saques via Caixa Eletrônico.
>   - Caso o valor do saldo disponível seja insuficiente para cobrir o valor do saque adicionado da taxa, o sistema deverá reportar erro e o saque deve ser negado.
> - **RF03:** O sistema deve permitir um máximo de dez saques via pix por conta.
>   - Caso este limite seja atingido, serão negados novos saques nessa modalidade.
> - **RF04:** O sistema deve fazer a verificação dos requisitos para o saque de acordo com o tipo de conta (CC ou Poupança).
>   - O sistema deve reportar erro caso qualquer requisito não esteja de acordo com o esperado.

> **3.2. Requisitos não Funcionais (RF):**
>
> - **RFN01:** O sistema deve ser implementado em Java.
> - **RNF02:** O sistema deve ser modular e extensível, permitindo a adição de novos métodos de saque sem alteração no código da classe principal.

### 4. Tecnologias e ferramentas
> - **Linguagens:**
>   - Java - JDK 20.0.0.1
> - **IDE:** IntelliJ IDEA
> - **Versionamento:** Git, Github

### 5. Critérios de aceitação
> O sistema deve permitir realizar saques via Caixa Eletrônico e via Pix com as regras específicas para cada tipo de saque.
> O sistema deve retornar corretamente mensagens de sucesso ou erro em cada operação de saque.
> O código deve seguir os princípios de injeção de dependências, facilitando a troca de implementações de saque.


---
Pedro C. Souza
<br>
Setembro de 2024
<br>
pedrocsouza97@gmail.com
