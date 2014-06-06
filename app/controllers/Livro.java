package controllers;

import java.util.List;

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
        List<Livros> livros = Livros.find.findList();
        return ok(views.html.livros.render(livros));
    }
}
