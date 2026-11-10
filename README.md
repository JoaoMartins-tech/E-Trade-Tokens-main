# E-Trade Tokens 🪙

Projeto Java orientado a objetos para gestão e troca de tokens de fidelidade entre clientes e empresas. O projeto utiliza **Maven** para gestão de dependências, possui uma suíte de testes unitários automatizados desenvolvida com **JUnit 5 (TDD)** e aplica padrões de projeto clássicos (**GoF**).

---

## 🚀 Padrões de Projeto (Design Patterns)

O sistema foi estruturado aplicando três padrões de projeto:

1. **Facade (`Menus.java`):**
   * Centraliza e simplifica o fluxo completo de compra de produtos.
   * Integra a verificação de estoque (`Produto`), validação e débito de tokens (`Cliente`) e aplicação de regras de desconto em um único ponto de chamada (`realizarCompra`).

2. **Strategy (`DescontoStrategy` / `DescontoPercentual`):**
   * Permite alternar dinamicamente o algoritmo de cálculo de desconto aplicado sobre as compras.
   * Possibilita aplicar diferentes percentuais de desconto sem alterar o código consumidor da Facade.

3. **Factory Method (`UsuarioFactory`):**
   * Encapsula a lógica de criação de instâncias de utilizadores (`Cliente` e `Empresa`).
   * Fornece um ponto centralizado para a instanciação a partir de tipos parametrizados, reduzindo o acoplamento direto com os construtores das subclasses de `Usuario`.

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 17 / 23
* **Gestão de Dependências e Build:** Apache Maven
* **Framework de Testes:** JUnit 5 (`junit-jupiter-5.10.0`)
* **Metodologia de Desenvolvimento:** Test-Driven Development (TDD)
* **IDE:** Visual Studio Code (com Java Extension Pack)

---

## 📁 Estrutura do Projeto

O repositório segue o padrão de diretórios recomendado pelo Maven:

```text
E-Trade-Tokens
├── pom.xml
├── README.md
├── .gitignore
└── src
    ├── main
    │   └── java
    │       ├── controller
    │       │   ├── Cliente.java
    │       │   ├── DescontoPercentual.java
    │       │   ├── DescontoStrategy.java
    │       │   ├── Empresa.java
    │       │   ├── Menus.java (Facade)
    │       │   ├── Produto.java
    │       │   └── UsuarioFactory.java (Factory)
    │       ├── model
    │       │   ├── Operacoes.java
    │       │   ├── OperacoesImpl.java
    │       │   └── Usuario.java
    │       └── view
    │           ├── CadastroClienteFrame.java
    │           ├── CadastroEmpresaFrame.java
    │           ├── CadastroProdutoFrame.java
    │           ├── ComprarProdutoFrame.java
    │           ├── Main.java
    │           └── MainFrame.java
    └── test
        └── java
            └── test
                ├── ClienteTest.java
                ├── CompraFacadeTest.java
                ├── EmpresaTest.java
                ├── ProdutoTest.java
                └── UsuarioFactoryTest.java