package controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

import models.Proposal;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import play.mvc.Results;
import scala.util.Either;
import services.ProposalService;
import services.ServiceError;
import views.html.list;
import views.html.proposalform;
import views.html.updateform;

public class ProposalController extends Controller {

	@Inject
	private ProposalService service;

	//-----------------new proposal----------------
	
	public Result newProposal() {
		return ok(proposalform.render(Optional.empty()));
	}
	
	//-----------------update proposal-------------
	
		public Result updateProposal(String id) {
			UUID uuid = null;
			try {
				uuid = UUID.fromString(id);
			} catch (IllegalArgumentException e) {
				return Results.badRequest();
			}
		Optional<Proposal> p = service.get(uuid);
		if (p.isPresent()) {
			return ok(updateform.render(p));
		} else {
			return Results.notFound();
		}
	}
	
	//-----------------save------------------------
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result save() {
		RequestBody body = request().body();
		try {
			JsonNode json = body.asJson();
			Proposal p = Proposal.fromJson(json.toString());
			if (p.uuid.isPresent()) {
				return badRequest();
			}
			Either<ServiceError, Proposal> r = service.put(p);
			if (r.isLeft()) {
				return internalServerError(r.left().toString());
			} else {
				return ok(r.right().get().toJson());
			}
		} catch (JsonProcessingException e) {
			return badRequest();
		}
	}
	

	//------------------------get----------------------------------------
	
	public Result get(String id) {
		UUID uuid = null;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			return Results.badRequest();
		}
		Optional<Proposal> result = service.get(uuid);
		if(request().acceptedTypes().get(0).accepts("application/json")) {
			if (result.isPresent()) {
				return ok(result.get().toJson());
			} else {
				return Results.notFound();
			}

		} else if(request().accepts("text/html"))  {
			if (result.isPresent()) {			
				return Results.ok(views.html.getproposal.render(result));
			} else {
				return Results.notFound();
			}
		} else return Results.status(415);
	}

	//-----------------------update--------------------------------------
	
	@BodyParser.Of(BodyParser.Json.class) // Body parsers play framework
	public Result update() {
		RequestBody body = request().body();
		try {
			JsonNode json = body.asJson();
			Proposal p = Proposal.fromJson(json.toString());
			if (!p.uuid.isPresent()) {
				return badRequest();
			}
			Either<ServiceError, Proposal> result = service.put(p);
			if (result.isLeft()) {
				return internalServerError(result.left().toString());
			} else {
				return ok(result.right().get().toJson());
			}
		} catch (JsonProcessingException e) {
			return badRequest();
		}
	}

	//------------------------list--------------------------------------
	
	public Result list(Integer offset, Integer size) {
		List<Proposal> result = service.list(Optional.ofNullable(offset), Optional.ofNullable(size));
		if(request().acceptedTypes().get(0).accepts("application/json")) {
			if (!result.isEmpty()) {
				return ok(Json.toJson(result));
			} else {
				return Results.notFound();
			}

		} else if(request().accepts("text/html"))  {
			if (!result.isEmpty()) {			
				return Results.ok(list.render(result));
			} else {
				return Results.notFound();
			}
		} else return Results.status(415);
	}
	
	//---------------------------delete---------------------------------
	
	public Result delete(String id) {
		UUID uuid = null;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
		return badRequest();
		}
		Optional<Proposal> result = service.get(uuid);
		if (result.isPresent()) {
			service.delete(uuid);	
			return ok("Deleted proposal" + " " + uuid);
		} else {
			return Results.notFound();
		}
	}
	
	//---------------------------incRank------------------------------------
	
	@BodyParser.Of(BodyParser.Json.class) // Body parsers play framework
	public Result incRank(String id) {
		UUID uuid = null;
		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			return Results.badRequest();
		}
		Optional<Proposal> p = service.get(uuid);
		if (p.isPresent()) {
			p.get().incrementRank();
			Either<ServiceError, Proposal> result = service.put(p.get());
			if (result.isLeft()) {
				return internalServerError(result.left().toString());
			} else {
				return ok(result.right().get().toJson());
			}
		} else {
			return Results.notFound();
		}
	}

	//---------------------------decRank------------------------------------
	
		@BodyParser.Of(BodyParser.Json.class) // Body parsers play framework
		public Result decRank(String id) {
			UUID uuid = null;
			try {
				uuid = UUID.fromString(id);
			} catch (IllegalArgumentException e) {
				return Results.badRequest();
			}
			Optional<Proposal> p = service.get(uuid);
			if (p.isPresent()) {
				p.get().decrementRank();
				Either<ServiceError, Proposal> result = service.put(p.get());
				if (result.isLeft()) {
					return internalServerError(result.left().toString());
				} else {
					return ok(result.right().get().toJson());
				}
			} else {
				return Results.notFound();
			}
		}
	
}
