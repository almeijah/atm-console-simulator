# ATM Console Simulator

Simulador de caixa eletrônico desenvolvido em Java, executado através do terminal.

O projeto foi desenvolvido com o objetivo de praticar os fundamentos da linguagem Java, organização em pacotes,
orientação a objetos, tratamento de exceções, `BigDecimal`, `HashMap` e entrada de dados pelo console.

## Funcionalidades

- Criar conta
- Depositar dinheiro
- Sacar dinheiro
- Consultar saldo
- Validar dados de entrada
- Impedir criação de contas duplicadas
- Impedir depósitos e saques com valores inválidos
- Verificar saldo insuficiente
- Tratar contas inexistentes
- Tratar entradas inválidas no menu
- Interface interativa pelo terminal

## Estrutura do projeto

```text
src/
└── com/atm/
    ├── Application.java
    │
    ├── model/
    │   └── Account.java
    │
    ├── service/
    │   └── BankService.java
    │
    ├── exception/
    │   ├── AccountAlreadyExistsException.java
    │   ├── AccountNotFoundException.java
    │   ├── InsufficientBalanceException.java
    │   ├── InvalidAccountNumberException.java
    │   ├── InvalidAmountException.java
    │   └── InvalidHolderNameException.java
    │
    └── ui/
        └── ConsoleInterface.java
Tecnologias
Java
BigDecimal
Collections (Map / HashMap)
Scanner
Exceções personalizadas
Git
Como executar

Execute a classe:

Application.java

O programa exibirá o menu no terminal:

----Welcome to ATM----
1-Create Account
2-Deposit
3-Withdraw
4-Balance
5-Exit

Digite a opção desejada e siga as instruções exibidas.

Validações

O sistema realiza validações para:

Número de conta nulo ou vazio
Nome do titular nulo ou vazio
Conta já existente
Conta não encontrada
Valor de depósito nulo, zero ou negativo
Valor de saque nulo, zero ou negativo
Saldo insuficiente
Entrada não numérica no menu
Objetivo do projeto

Este é um projeto de estudo desenvolvido para consolidar conhecimentos fundamentais de Java e servir como base para projetos posteriores mais complexos.