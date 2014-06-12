package dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import models.Livro;
import play.db.ebean.Model;

import java.util.List;

/**
 * Created by gilmar on 12/06/14.
 */
public class UsuarioDAO {

    public static int getMaxIdVotoUsuario(){
        List<Livro> livro = Ebean.find(Livro.class).orderBy("id_voto_usuario desc").findList();
        return livro.get(0).idVotoUsuario;
    }
}
