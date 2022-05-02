/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jessica.santos19
 * @param <T>
 * @param <ID>
 */
//no id sig tipo da chave primaria
public interface BaseDao<T, ID> {
//td mundo que ta dentro de uma interace ja é abstract, por isso fica por defautl
    void salvarOuAlterar(T entidade, Session sessao) throws HibernateException;
    
    void excluir(T entidade, Session sessao) throws HibernateException;
    
    T pesquisarPorId(ID id, Session sessao) throws HibernateException;
    
}
