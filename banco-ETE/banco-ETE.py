# Autor: João PauLo Falcão
# Github: https://github.com/jplfalcao
# Data de criação: 22/10/2023
# Data de modificação: 19/11/2023
# Versão: 1.1


import random
import os

qtd_letras_titular = 0
saldo_conta_corrente = 0.0
saldo_conta_poupanca = 0.0
valor_deposito_inicial = 0.0

def saldo():
    print(nome_titular)
    print(f"Agência: {agencia}")
    print(f"Conta Corrente: {numero_conta_corrente}-{digito_verificador}")
    print(f"Saldo Conta Corrente: R$ {saldo_conta_corrente:.2f}")
    print(f"Conta Poupança: {numero_conta_poupanca}-{digito_verificador}")
    print(f"Saldo Conta Poupança: R$ {saldo_conta_poupanca:.2f}\n")

def deposito():
    global saldo_conta_corrente

    valor_deposito = float(input("Valor do depósito: R$ "))
    if valor_deposito <= 0:
        print("\nDepósito não permitido!\n")
    else:
        saldo_conta_corrente += valor_deposito
        print("\nDepósito realizado com sucesso!\n")

def saque():
    global saldo_conta_corrente

    valor_saque = float(input("Valor do saque: R$ "))
    if valor_saque <= 0:
        print("\nSaque não permitido!\n")
    elif saldo_conta_corrente < valor_saque:
        print("\nSaldo insuficiente!\n")
    else:
        saldo_conta_corrente -= valor_saque
        print("\nSaque realizado com sucesso!\n")

def transferencia():
    global saldo_conta_corrente, saldo_conta_poupanca

    valor_transferencia = float(input("Qual valor deseja transferir: R$ "))
    if valor_transferencia <= 0:
        print("\nTransferência não permitida!\n")
    elif saldo_conta_corrente < valor_transferencia:
        print("\nSaldo insuficiente!\n")
    else:
        saldo_conta_corrente -= valor_transferencia
        saldo_conta_poupanca += valor_transferencia
        print("\nTransferência realizada com sucesso!\n")

def resgate():
    global saldo_conta_corrente, saldo_conta_poupanca

    valor_resgate = float(input("Qual valor deseja resgatar: R$ "))
    if valor_resgate <= 0:
        print("\nResgate não permitido!\n")
    elif saldo_conta_poupanca < valor_resgate:
        print("\nSaldo insuficiente!\n")
    else:
        saldo_conta_poupanca -= valor_resgate
        saldo_conta_corrente += valor_resgate
        print("\nResgate realizado com sucesso!\n")

def main():
    global nome_titular, agencia, numero_conta_corrente, numero_conta_poupanca, digito_verificador, saldo_conta_corrente, saldo_conta_poupanca, valor_deposito_inicial, qtd_letras_titular

    # Menu
    while True:
        print("$$$$$ BANCO ETE $$$$$")
        print("0-Criar Conta")
        print("1-Exibir Saldo")
        print("2-Depósito Conta Corrente")
        print("3-Saque Conta Corrente")
        print("4-Aplicar Conta Poupança")
        print("5-Resgate Conta Poupança")
        print("6-Sair")
        opcao_menu = int(input("Opção: "))

        # Utiliza o comando 'clear' do GNU/Linux para limpar tela
        # Em sistemas Widowns utilize 'cls'
        os.system('clear')
        
        if opcao_menu == 0:
            if qtd_letras_titular == 0:
                while True:
                    nome_titular = str(input("Titular: ").title())
                    # Verifica se a entrada contém apenas letras
                    if nome_titular.isalpha():
                        break
                    else:
                        print("Digite apenas caracteres alfabéticos!")
        
                qtd_letras_titular = len(nome_titular)
                agencia = random.randint(1000, 9999)
                numero_conta_corrente = random.randint(10000, 99999)
                numero_conta_poupanca = random.randint(10000, 99999)
                digito_verificador = random.randint(0, 9)

                os.system('clear')

                print(nome_titular)
                print(f"Agência: {agencia}")
                print(f"Conta Corrente: {numero_conta_corrente}-{digito_verificador}")
                print(f"Conta Poupança: {numero_conta_poupanca}-{digito_verificador}")
            else:
                print("Não é permitido cadastrar novos clientes!\n")
                continue
    
            opcao_deposito_inicial = int(input("Deseja realizar um depósito na Conta Corrente? [0-SIM][1-NÃO]: "))
            if opcao_deposito_inicial == 0:    
                valor_deposito_inicial = float(input("Valor do depósito:R$ "))
                if valor_deposito_inicial <= 0.0:
                    print("\nDepósito não permitido!\n")
                else:
                    saldo_conta_corrente += valor_deposito_inicial
                    print("\nDepósito realizado com sucesso!\n")
            else:
                os.system('clear')       

        elif opcao_menu == 1:
            if qtd_letras_titular == 0:
                print("Ainda não há conta cadastrada!\n")
            else:
                saldo()
        elif opcao_menu == 2:
            if qtd_letras_titular == 0:
                print("Ainda não há conta cadastrada!\n")
            else:    
                deposito()
        elif opcao_menu == 3:
            if qtd_letras_titular == 0:
                print("Ainda não há conta cadastrada!\n")
            else:
                saque()
        elif opcao_menu == 4:
            if qtd_letras_titular == 0:
                print("Ainda não há conta cadastrada!\n")
            else:
                transferencia()
        elif opcao_menu == 5:
            if qtd_letras_titular == 0:
                print("Ainda não há conta cadastrada!\n")
            else:
                resgate()
        elif opcao_menu == 6:
            print("Saindo...\n")
            break
        else:
            print("Opção inválida!\n")

if __name__ == "__main__":
    main()
