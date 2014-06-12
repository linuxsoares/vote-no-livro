package dao;

import com.avaje.ebean.Ebean;
import models.Livro;

import java.util.List;

/**
 * Created by gilmar on 11/06/14.
 */
public class LivrosDAO {

    public static List<Livro> getListMaisVotados(){
        return Ebean.find(Livro.class).where().orderBy("voto desc").findList();
    }

    public static Livro getLivro(Long id){
        return Livro.find.byId(id);
    }

    public static List<Livro> getListAllLivros(){
        return Ebean.find(Livro.class).findList();
    }

    public static List<Livro> getListVotoUsuario(){
        return Livro.find.where().eq("id_voto_usuario",UsuarioDAO.getMaxIdVotoUsuario()).findList();
    }
}
