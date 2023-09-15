package com.trybe.acc.java.caixaeletronico;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * classe pricipal.
 *
 */
public class Banco {
  private Set<Conta> contas = new HashSet<Conta>();
  private Set<PessoaCliente> clientes = new HashSet<PessoaCliente>();

  /**
   * gerador de numero de conta.
   *
   */
  public String gerarNumeroNovaConta() {
    String contaCriada = null;
    Random random = new Random();
    do {
      StringBuilder conta = new StringBuilder();
      for (int i = 0; i < 10; i++) {
        int numero = random.nextInt(10);
        conta.append(Integer.toString(numero));
      }
      contaCriada = conta.toString();
    } while (getConta(contaCriada) != null);

    return contaCriada;
  }


  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }


  /**
   * cria Pessoacliente.
   */
  public void adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    clientes.add(cliente);
  }

  public Set<PessoaCliente> getPessoasClientes() {
    return this.clientes;
  }

  /**
   * cpf param senha return.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente cliente : clientes) {
      if (cliente.cpf.equals(cpf) && cliente.senha.equals(senha)) {
        return cliente;
      }
    }
    return null;
  }


  /**
   * retorna conta pelo seu numero.
   */
  public Conta getConta(String numeroConta) {
    for (Conta conta : this.contas) {
      if (conta.idConta.equals(numeroConta)) {
        return conta;
      }
    }
    return null;
  }

  public void depositar(String conta, double valor) {
    Conta contaAdepositar = getConta(conta);
    contaAdepositar.depositar(valor);
  }

  public double mostrarExtrato(String conta) {
    Conta contaSaldo = getConta(conta);
    return contaSaldo.getSaldo();
  }

  public void sacar(String conta, double valor) {
    Conta contaSacar = getConta(conta);
    contaSacar.sacar(valor);
  }

  public void transferirFundos(String daConta, String paraConta, double quantia) {
    this.sacar(daConta, quantia);
    this.depositar(paraConta, quantia);
  }

}

