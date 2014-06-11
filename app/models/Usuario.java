package models;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Required;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Constraint;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by gilmar on 07/06/14.
 */

@Entity
public class Usuario extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public long idUsuario;

    @Constraints.Required
    public String nomeUsuario;

    @Email
    public String emailUsuario;

    public static Model.Finder<Long,Usuario> find = new Model.Finder<Long,Usuario>(Long.class,Usuario.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for (Usuario c : Usuario.find.orderBy("nomeUsuario").findList()) {
            options.put(String.valueOf(c.idUsuario) ,c.nomeUsuario);
        }
        return options;
    }

    @Override
    public String toString() {
        return nomeUsuario;
    }
}
