package com.trybe.acc.java.caixaeletronico;

/**
 * Representa um cliente do banco.
 */
public class PessoaCliente {
  String nome;
  String cpf;
  String senha;
  private Conta conta;

  /**
   * Cria uma nova instância de PessoaCliente com um nome, CPF e senha iniciais.
   *
   * @param nome O nome do cliente.
   * @param cpf O CPF do cliente.
   * @param senha A senha do cliente.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    super();
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
  }

  public Conta getConta() {
    return this.conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }
}
