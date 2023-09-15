package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * Representa uma conta em um caixa eletrônico.
 */
public class Conta {
  String tipoConta;
  public String idConta;
  private PessoaCliente pessoaCliente;
  ArrayList<Transacao> transacoes;
  private double saldo;

  /**
   * Cria uma nova instância de Conta com um número de conta inicial.
   *
   * @param numeroConta O número da conta a ser associado à instance de Conta.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    super();
    this.tipoConta = tipoConta;
    this.idConta = banco.gerarNumeroNovaConta();
    this.pessoaCliente = pessoaCliente;
    this.saldo = 0;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao newTansacao = new Transacao(quantia, descricao);
    this.transacoes.add(newTansacao);
  }

  /**
   * Obtém o saldo atual da conta.
   *
   * @return O saldo atual da conta.
   */
  public double getSaldo() {
    return saldo;
  }

  /**
   * Realiza um depósito na conta.
   *
   * @param valor O valor a ser depositado na conta.
   */
  public void depositar(double valor) {
    this.saldo += valor;
  }

  /**
   * Realiza um saque da conta.
   *
   * @param valor O valor a ser sacado da conta.
   * @return true se o saque foi bem-sucedido, false caso contrário.
   */
  public boolean sacar(double valor) {
    if (valor >= saldo) {
      this.saldo -= valor;
      return true;
    }
    return false;
  }
}
