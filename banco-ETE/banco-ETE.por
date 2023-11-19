/*
Curso: Desenvolvimento de Sistemas
Disciplina: Lógica de Programação
Discente: João Paulo Falcão
Docente: Silvio Monte
Data de criação: 11/10/2023
Data de modificação: 19/11/2023
IDE/Editor: https://dgadelha.github.io/Portugol-Webstudio/

Banco ETE - Projeto final para conclusão do 1º módulo
*/

programa {
  inclua biblioteca Texto
  inclua biblioteca Util

  // Variáveis globais
  cadeia nomeTitular
  inteiro agencia, numeroContaCorrente, numeroContaPoupanca, digitoVerificador, qtdLetrasTitular = 0, opcaoDepositoInicial
  real saldoContaCorrente = 0.0, saldoContaPoupanca = 0.0, valorDepositoInicial = 0.0

  // Saldo
  funcao saldo() {
    escreva(nomeTitular)
    escreva("\nAgência: ", agencia)
    escreva("\nConta Corrente: ", numeroContaCorrente, "-", digitoVerificador)
    escreva("\nSaldo Conta Corrente: R$ ", saldoContaCorrente)
    escreva("\nConta Poupança: ", numeroContaPoupanca, "-", digitoVerificador)
    escreva("\nSaldo Conta Poupança: R$ ", saldoContaPoupanca, "\n\n")
  }

  // Depósito
  funcao deposito() {
    real valorDeposito = 0.0

    escreva("Valor do depósito: R$ ")
    leia(valorDeposito)

    se (valorDeposito <= 0.0) {
      escreva("\nDepósito não permitido!\n\n")
    } senao {
      saldoContaCorrente = saldoContaCorrente + valorDeposito
      escreva("\nDepósito realizado com sucesso!\n\n")
    }
  }

  // Saque
  funcao saque() {
    real valorSaque = 0.0
  
    escreva("Valor do saque: R$ ")
    leia(valorSaque)

    se (valorSaque <= 0.0) {
      escreva("\nSaque não permitido!\n\n")
    } senao se (saldoContaCorrente < valorSaque) {
      escreva("\nSaldo insuficiente!\n\n")
    } senao {
      saldoContaCorrente = saldoContaCorrente - valorSaque
      escreva("\nSaque realizado com sucesso!\n\n")
    }
  }

  // Transferência
  funcao transferencia() {
    real valorTransferencia = 0.0

    escreva("Qual valor deseja transferir:R$ ")
    leia(valorTransferencia)

    se (valorTransferencia <= 0.0) {
      escreva("\nTransferência não permitida!\n\n")
    } senao se (saldoContaCorrente < valorTransferencia){
      escreva("\nSaldo insuficiente!\n\n")
    } senao {
      saldoContaCorrente = saldoContaCorrente - valorTransferencia
      saldoContaPoupanca = saldoContaPoupanca + valorTransferencia
      escreva("\nTransferência realizada com sucesso!\n\n")
    }
  }

  // Resgate
  funcao resgate() {
    real valorResgate = 0.0
        
    escreva("Qual valor deseja resgatar:R$ ")
    leia(valorResgate)

    se (valorResgate <= 0.0) {
      escreva("\nResgate não permitido!\n\n")
    } senao se (saldoContaPoupanca < valorResgate){
      escreva("\nSaldo insuficiente!\n\n")
    } senao {
      saldoContaPoupanca = saldoContaPoupanca - valorResgate
      saldoContaCorrente = saldoContaCorrente + valorResgate
      escreva("\nResgate realizado com sucesso!\n\n")
    }
  }
  
  // Função principal
  funcao inicio() {
    inteiro opcaoMenu

    // Menu
    enquanto (opcaoMenu != 6) {
      escreva("$$$$$ BANCO ETE $$$$$")
      escreva("\n0-Criar Conta")
      escreva("\n1-Exibir Saldo")
      escreva("\n2-Depósito Conta Corrente")
      escreva("\n3-Saque Conta Corrente")
      escreva("\n4-Aplicar Conta Poupança")
      escreva("\n5-Resgate Conta Poupança ")
      escreva("\n6-Sair")
      escreva("\nOpção: ")
      leia(opcaoMenu)

      limpa()

      escolha (opcaoMenu) {
        //Criando a conta
        caso 0:
          se (qtdLetrasTitular == 0) {
            escreva("Titular: ")
            leia(nomeTitular)

            qtdLetrasTitular = Texto.numero_caracteres(nomeTitular)
        
            // Gera números aleatórios para agência, contas e dígito verificador
            agencia = Util.sorteia(1000, 9999)
            numeroContaCorrente = Util.sorteia(10000, 99999)
            numeroContaPoupanca = Util.sorteia(10000, 99999)
            digitoVerificador = Util.sorteia(0, 9)

            limpa()

            escreva(nomeTitular)
            escreva("\nAgência: ", agencia)
            escreva("\nConta Corrente: ", numeroContaCorrente, "-", digitoVerificador)
            escreva("\nConta Poupança: ", numeroContaPoupanca, "-", digitoVerificador)
          } senao {
            escreva("Não é permitido cadastro de novos clientes!\n\n")
            pare
          }

          escreva("\nDeseja realizar um depósito na Conta Corrente? [0-SIM][1-NÃO]: ")
          leia(opcaoDepositoInicial)

          se (opcaoDepositoInicial == 1) {
            limpa()
            pare
          }  
        
          escreva("Valor do depósito:R$ ")
          leia(valorDepositoInicial)
          se (valorDepositoInicial <= 0.0) {
            escreva("\nDepósito não permitido!\n\n")
          } senao {
            saldoContaCorrente = saldoContaCorrente + valorDepositoInicial
            escreva("\nDepósito realizado com sucesso!\n\n")
          }
        pare

        caso 1:
          // Verifica se há conta cadastrada
          se (qtdLetrasTitular == 0) {
            escreva("Ainda não há conta cadastrada!\n\n")
          } senao {
            saldo()
          }
        pare

        caso 2:
          se (qtdLetrasTitular == 0) {
            escreva("Ainda não há conta cadastrada!\n\n")
          } senao {
            deposito()
          }
        pare

        caso 3:
          se (qtdLetrasTitular == 0) {
            escreva("Ainda não há conta cadastrada!\n\n")
          } senao {
            saque()
          }
        pare

        caso 4:
          se (qtdLetrasTitular == 0) {
            escreva("Ainda não há conta cadastrada!\n\n")
          } senao {
            transferencia()
          }
        pare

        caso 5:
          se (qtdLetrasTitular == 0) {
            escreva("Ainda não há conta cadastrada!\n\n")
          } senao {
            resgate()
          }
        pare

        caso 6:
          escreva("\nSaindo...\n")
        pare

        caso contrario:
          escreva("Opção inválida!\n\n")
        pare
      }
    }
  }
}
