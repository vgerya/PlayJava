package controllers;

import models.Proporsal;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;

public class Application extends Controller {
    final static Form<Proporsal> proporsalForm = Form.form(Proporsal.class);

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result newProposal() {

        return ok(views.html.newProposal.render(proporsalForm));
    }

    public static Result submitProposal() {
        Form<Proporsal> submittedForm = proporsalForm.bindFromRequest();
        if(submittedForm.hasErrors()) {
            ok(views.html.newProposal.render(submittedForm));
        }else {
            Proporsal proporsal = submittedForm.get();
            proporsal.save();

            flash("message", "Thanks for submitting the proposal.");
            return redirect(routes.Application.index());
        }

        return Results.TODO;
    }

}
