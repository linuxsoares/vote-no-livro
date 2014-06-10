package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import controllers.routes;
import models.Livro;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by gilmar on 05/06/14.
 */
public class LivrosController extends Controller {

    private static final Form<Livro> livroForm = Form.form(Livro.class);

    static int quantVoto = 0;

    public static Result list(){
        List<Livro> livros = new LinkedList<Livro>();
        Random random = new Random();
        for(int i = 0; livros.size() < 2; i++){
            int auxNum = random.nextInt(Livro.find.all().size());
            if(!livros.contains(Livro.find.findList().get(auxNum))){
                livros.add(Livro.find.findList().get(auxNum));
            }
        }
        return ok(views.html.livros.render(livros));
    }

    public static Result listAll(){
        List<Livro> livros = Livro.find.all();
        return ok(views.html.livros.render(livros));
    }

    public static Result voto(Long id){
        quantVoto += 1;
        Livro livro = Livro.find.byId(id);
        livro.voto += 1;
        livro.update(id);
        livro.save();
        flash("sucesso","Voto gravado com sucesso");
        if (quantVoto < 5){
            return redirect(routes.LivrosController.list());
        } else {
            quantVoto = 0;
            return redirect(routes.UsuarioController.formCadastroUsuario());
        }

    }
}
