/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.entidade;

import br.com.senac.dao.BaseDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jessica.santos19
 */
//                          < quem eu quero salvar, tipo da chave primaria >, o usuariodaoimpl tem que implementar a interface dele
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao{

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        //tem que devolver um usuario
        //                         ( Em cima de qual classe, em cima de qual chave primaria )
//        Usuario usuario = sessao.get(Usuario.class, id);
//        return usuario;
    return sessao.get(Usuario.class, id);
        
    }
    
}
