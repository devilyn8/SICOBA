package net.servehttp.bytecom.percistence;

import java.util.List;

import javax.persistence.EntityManager;

import net.servehttp.bytecom.facede.CreateEntityManager;
import net.servehttp.bytecom.persistence.GenericoJPA;
import net.servehttp.bytecom.persistence.entity.Contrato;
import net.servehttp.bytecom.persistence.entity.Plano;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericoJPATest {
  private static EntityManager em;
  private static GenericoJPA genericoJPA;

  @BeforeClass
  public static void setUp() {
    em = CreateEntityManager.INSTANCE.getEntityManager();
    genericoJPA = new GenericoJPA();
    genericoJPA.setEntityManager(em);
  }

  @Test
  public void deveriaDeveriaBuscarTodos() {
    List<Plano> list = genericoJPA.buscarTodos(Plano.class);
    Assert.assertNotNull(list);
  }

  @Test
  public void deveriaDeveriaBuscarTodosComParametroString() {
    List<Plano> list = genericoJPA.buscarTodos("id", 1, Plano.class);
    Assert.assertNotNull(list);
    Assert.assertFalse(list.isEmpty());
    List<Contrato> contratos =
        genericoJPA.buscarTodos("plano", list.get(0), Contrato.class);
    Assert.assertNotNull(contratos);
    Assert.assertFalse(contratos.isEmpty());
//    List<Plano> list = genericoJPA.buscarTodos("nome", "1MB", Plano.class);
//    Assert.assertNotNull(list);
  }

  @Test
  public void deveriaDeveriaBuscarTodosComParametroInteiro() {
    List<Plano> list = genericoJPA.buscarTodos("id", "1", Plano.class);
    Assert.assertNotNull(list);
  }

  @Test
  public void deveriaDeveriaBuscarPorId() {
    Plano p = genericoJPA.buscarPorId(Plano.class, 1);
    Assert.assertNotNull(p);
  }

  @AfterClass
  public static void closeUp() {
    em.close();
  }

}
