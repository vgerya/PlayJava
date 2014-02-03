package controllers;

import models.*;
import play.data.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;

public class Application extends Controller {
    final static Form<Proposal> proposalForm = Form.form(Proposal.class);

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result newProposal() {

        return ok(views.html.newProposal.render(proposalForm));
    }

    public static Result submitProposal() {
        Form<Proposal> submittedForm = proposalForm.bindFromRequest();
        if(submittedForm.hasErrors()) {
            return ok(views.html.newProposal.render(submittedForm));
        }else {
            Proposal proposal = submittedForm.get();
            proposal.save();

            flash("message", "Thanks for submitting the proposal.");
            return redirect(routes.Application.index());
        }

//        return Results.TODO;
    }

}
