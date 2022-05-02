/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.entidade;

import br.com.senac.dao.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessica.santos19
 */
public class UsuarioDaoImplTest {

    //criar o tipo sempre em cima da interface
    //o objeto é sempre e cima da classe que implementou
    private Usuario usuario;

    private UsuarioDao usuarioDao;

    private Session sessao;

    public UsuarioDaoImplTest() {
        //pega o "link" usuarioDao para inicializa-lo. o new é em cima da classe que implementa a interface
        usuarioDao = new UsuarioDaoImpl();
    }

    @Test
    public void testSalvar() {
        //criar um novo objeto e vai inserir no banco 
        System.out.println("salvar");
        usuario = new Usuario(null, "jessica1", "@jessica1", "123456");
        //para salvar no banco tem que abrir a conexao 
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

}
