package net.servehttp.bytecom.persistence.relatorios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import net.servehttp.bytecom.persistence.entity.Mensalidade;

@Transactional
public class MensalidadeRelatorioJPA implements Serializable {

  private static final long serialVersionUID = -666959135258997285L;
  @PersistenceContext(unitName = "bytecom-pu")
  private EntityManager em;

  public List<Mensalidade> buscarPorDataStatus(Date inicio, Date fim, int status) {
    String jpql = "select m from Mensalidade m where m.dataVencimento between :inicio and :fim order by m.dataOcorrencia desc";

    TypedQuery<Mensalidade> query =
        em.createQuery(jpql, Mensalidade.class).setParameter("inicio", inicio)
            .setParameter("fim", fim);
    return query.getResultList();
  }
}
