/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author jmayanes
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//notacoes do jpa 
    private Long id;

    @Column(nullable =  false, length = 120)//obrigatorio ter valor no nome quando gravar no banco.. se eu quiser o tamanho do varchar que eu to usando posso colocar virg e lenght = ...
    private String nome;
    
    @Column(nullable =  false,length = 120, unique = true)//obrigatorio ter valor no nome quando gravar no banco.. se eu quiser o tamanho do varchar que eu to usando posso colocar virg e lenght = ...
    private String login;
    
    @Column(nullable =  false, length = 100)//obrigatorio ter valor no nome quando gravar no banco.. se eu quiser o tamanho do varchar que eu to usando posso colocar virg e lenght = ...
    private String senha;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
     
    @Override // metodo que extend a classe object / o override ta sobrescrevendo por heran??a
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.Usuario[ id=" + id + " ]";
    }
    
}
