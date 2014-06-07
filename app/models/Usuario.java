package models;

import play.db.ebean.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by gilmar on 07/06/14.
 */
public class Usuario extends Model {

    @Id
    @GeneratedValue
    public long idUsuario;

    public String nomeUsuario;
    public String emailUsuario;

    public static Model.Finder<Long,Usuario> find = new Model.Finder<Long,Usuario>(Long.class,Usuario.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for (Usuario c : Usuario.find.orderBy("titulo").findList()) {
            options.put(c.nomeUsuario ,c.emailUsuario);
        }
        return options;
    }

    @Override
    public String toString() {
        return nomeUsuario;
    }
}
