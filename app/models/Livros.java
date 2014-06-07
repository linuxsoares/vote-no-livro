package models;

import play.db.ebean.Model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by gilmar on 05/06/14.
 */

@Entity
public class Livros extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    public long id;

    public String titulo;
    public String autor;
    public String descricao;
    public int voto;

    public static Model.Finder<Long,Livros> find = new Model.Finder<Long,Livros>(Long.class,Livros.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for (Livros c : Livros.find.orderBy("titulo").findList()) {
            options.put(c.autor ,c.titulo);
        }
        return options;
    }

    @Override
    public String toString() {
        return titulo;
    }

}
