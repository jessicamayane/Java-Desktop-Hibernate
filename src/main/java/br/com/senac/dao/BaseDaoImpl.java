/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import org.hibernate.*;

/**
 *
 * @author jessica.santos19
 * @param <T> representa qualquer classe entidade
 * @param <ID> representa o tipo do id
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{
//implementar sugestao de tds os metodos abstratos que foram criados na BaseDao
      //aqui que vai ter a codificação dos metodos criados na BaseDao
    //colocado abstract para que o erro de implementação de tds os metodos pare.. logo a classe que estender essa classe BaseDao vai ter que terminar de implementar o pesquisar por id
    //usando herança.. p salvar, alterar ou excluir vai precisar abrir uma alteração no bd
    //salvar coloca um registro, alterar mexe nas colunas de um registro excluir, tira um registro.. pesquisar nao precisa de transação
    //na DAO usa o javax.Persistenc aqui sempre vai usar o puro hibernate por casa do session factory
    
    private Transaction transaction;
    
    
    @Override
    public void salvarOuAlterar(T entidade, Session sessao) throws HibernateException {
        //pra abrir a transação tem que abrir a sessao
        transaction = sessao.beginTransaction();
        sessao.saveOrUpdate(entidade);
        transaction.commit();//prepara para executar a acao no banco 
        // o Hibernate sabe que se dentro da minha entidade chegar com o valor id/ DA CHAVE PRIMARIA ele altera.. se o objeto chegar sem valor de chave primaria ele salva
    }

    @Override
    public void excluir(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.delete(entidade);
        transaction.commit(); 
    } 
}
