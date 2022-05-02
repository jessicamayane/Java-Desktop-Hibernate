/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

//import br.com.senac.entidade.Usuario;
import br.com.senac.entidade.Usuario;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Silvio
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //Singleton  design patterns
    //a aplicação conversa com o banco apenas por essa variavel, e não fica abrindo várias conexoes 
    //existem duas maneirass de usar o hibernate.. esse é um tipo de ORM 

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Usuario.class);
            //descomenta a linha acima na hora de testar 
//gerenciar as classes de entiadade
//se tiver 10 classes no projeto, mas 10 tem que ta aqui declaradas

            cfg.configure("/META-INF/hibernate.cfg.xml");
            //atencao com essa linha - aponta onde buscar o arquivo e mostra a as configuracoes do bd
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session abrirConexao() {
        return sessionFactory.openSession();
    }
}
