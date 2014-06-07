package controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import controllers.routes;
import models.Livros;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by gilmar on 05/06/14.
 */
public class Livro extends Controller {

    private static final Form<Livros> livroForm = Form.form(Livros.class);

    public static Result list(){
        List<Livros> livros = new LinkedList<Livros>();
        Random random = new Random();
        for(int i = 0; livros.size() < 2; i++){
            int auxNum = random.nextInt(Livros.find.all().size());
            if(!livros.contains(Livros.find.findList().get(auxNum))){
                livros.add(Livros.find.findList().get(auxNum));
            }
        }
        return ok(views.html.livros.render(livros));
    }

    public static Result voto(Long id){
        Livros livro = Livros.find.byId(id);
        livro.voto += 1;
        livro.update(id);
        livro.save();
        return redirect(routes.Livro.list());
    }
}
