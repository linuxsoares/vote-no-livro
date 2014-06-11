package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class ApplicationController extends Controller {

    public static Result index() {
        return ok(views.html.inicio.index.render("Your new application is ready."));
    }

}
