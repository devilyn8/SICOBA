package net.servehttp.bytecom.persistence.entity.caixa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.servehttp.bytecom.converter.date.LocalDateTimePersistenceConverter;
import net.servehttp.bytecom.persistence.entity.cadastro.EntityGeneric;

@Entity
@Table(name = "header")
public class Header extends EntityGeneric implements Serializable {

  private static final long serialVersionUID = -7418368665896060578L;
  private int sequencial;

  @Column(name = "nome_arquivo")
  private String nomeArquivo;
  @Column(name = "data_geracao")
  @Convert(converter = LocalDateTimePersistenceConverter.class)
  private LocalDateTime dataGeracao;

  @OneToMany(mappedBy = "header", cascade = CascadeType.ALL)
  private List<HeaderLote> headerLotes;
  @OneToOne(mappedBy = "header", cascade = CascadeType.ALL)
  private Trailer trailer;

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }

  public int getSequencial() {
    return sequencial;
  }

  public void setSequencial(int sequencial) {
    this.sequencial = sequencial;
  }

  public LocalDateTime getDataGeracao() {
    return dataGeracao;
  }

  public void setDataGeracao(LocalDateTime dataGeracao) {
    this.dataGeracao = dataGeracao;
  }

  public Trailer getTrailer() {
    return trailer;
  }

  public void setTrailer(Trailer trailer) {
    this.trailer = trailer;
  }

  public List<HeaderLote> getHeaderLotes() {
    return headerLotes;
  }

  public void setHeaderLotes(List<HeaderLote> headerLotes) {
    this.headerLotes = headerLotes;
  }
}
