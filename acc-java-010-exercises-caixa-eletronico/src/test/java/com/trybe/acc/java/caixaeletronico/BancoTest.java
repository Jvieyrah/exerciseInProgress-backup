package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco newBank = new Banco();
    String numeroConta = newBank.gerarNumeroNovaConta();
    assertEquals(10, numeroConta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco newBank = new Banco();
    newBank.adicionarPessoaCliente("José Ribeiro", "123.456.789-12", "123456");
    Set<PessoaCliente> retornoClientes = newBank.getPessoasClientes();
    assertFalse(retornoClientes.isEmpty());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco newBank = new Banco();
    newBank.adicionarPessoaCliente("José Ribeiro", "123.456.789-12", "123456");
    PessoaCliente logado = newBank.pessoaClienteLogin("123.456.789-12", "123456");
    assertEquals("José Ribeiro", logado.nome);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco newBank = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("José Ribeiro", "123.456.789-12", "123456");
    newBank.adicionarPessoaCliente(pessoaCliente);
    PessoaCliente correntista = newBank.pessoaClienteLogin("123.456.789-12", "123456");
    String conta = correntista.getConta();
    newBank.depositar(conta, 100);
    assertEquals(100, newBank.mostrarExtrato(conta));
    PessoaCliente pessoaCliente2 = new PessoaCliente("José silva", "123.456.789-13", "123456");
    newBank.adicionarPessoaCliente(pessoaCliente2);
    PessoaCliente correntista2 = newBank.pessoaClienteLogin("123.456.789-13", "123456");
    String conta2 = correntista2.getConta();
    newBank.transferirFundos(conta, conta2, 100);
    assertEquals(0, newBank.mostrarExtrato(conta));
    assertEquals(100, newBank.mostrarExtrato(conta2));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco newBank = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("José Ribeiro", "123.456.789-12", "123456");
    newBank.adicionarPessoaCliente(pessoaCliente);
    PessoaCliente correntista = newBank.pessoaClienteLogin("123.456.789-12", "123456");
    String conta = correntista.getConta();
    newBank.depositar(conta, 100);
    assertEquals(100, newBank.mostrarExtrato(conta));
    PessoaCliente pessoaCliente2 = new PessoaCliente("José silva", "123.456.789-13", "123456");
    newBank.adicionarPessoaCliente(pessoaCliente2);
    PessoaCliente correntista2 = newBank.pessoaClienteLogin("123.456.789-13", "123456");
    String conta2 = correntista2.getConta();
    newBank.transferirFundos(conta, conta2, 100);
    assertEquals(0, newBank.mostrarExtrato(conta));
    assertEquals(100, newBank.mostrarExtrato(conta2));
  }

}
