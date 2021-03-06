package net.servehttp.bytecom.persistence.entity.financeiro.boleto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import net.servehttp.bytecom.persistence.entity.cadastro.EntityGeneric;

@Entity
@Table(name = "cedente")
public class Cedente extends EntityGeneric implements Serializable {

  private static final long serialVersionUID = -2529079451437071047L;

  private String nome;

  private int codigo;

  @Column(name = "digito_verificador")
  private int digitoVerificador;

  @Column(name = "codigo_operacao")
  private int codigoOperacao;

  @Column(name = "cpf_cnpj")
  private String cpfCnpj;

  @Column(name = "numero_agencia")
  private int numeroAgencia;

  @Column(name = "digito_agencia")
  private int digitoAgencia;

  @Column(name = "numero_conta")
  private int numeroConta;

  @Column(name = "digito_conta")
  private int digitoConta;

  public Cedente() {
    createdAt = LocalDateTime.now();
  }

  public int getCodigoOperacao() {
    return this.codigoOperacao;
  }

  public void setCodigoOperacao(int codigoOperacao) {
    this.codigoOperacao = codigoOperacao;
  }

  public String getCpfCnpj() {
    return this.cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public int getDigitoAgencia() {
    return this.digitoAgencia;
  }

  public void setDigitoAgencia(int digitoAgencia) {
    this.digitoAgencia = digitoAgencia;
  }

  public int getDigitoConta() {
    return this.digitoConta;
  }

  public void setDigitoConta(int digitoConta) {
    this.digitoConta = digitoConta;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumeroAgencia() {
    return this.numeroAgencia;
  }

  public void setNumeroAgencia(int numeroAgencia) {
    this.numeroAgencia = numeroAgencia;
  }

  public int getNumeroConta() {
    return this.numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getDigitoVerificador() {
    return digitoVerificador;
  }

  public void setDigitoVerificador(int digitoVerificador) {
    this.digitoVerificador = digitoVerificador;
  }

}
