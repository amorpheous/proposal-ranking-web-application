import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;

import models.Proposal;
import play.Application;
import play.ApplicationLoader.Context;
import play.Environment;
import play.Logger;
import play.inject.guice.GuiceApplicationBuilder;
import play.inject.guice.GuiceApplicationLoader;
import play.libs.ws.WS;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Http;
import play.test.Helpers;
import services.ProposalService;
import services.mockup.MockProposalService;

public class IntegrationTest {

	@Inject
	Application application;

	/**
	 * add your integration test here in this example we just check if the
	 * welcome page is being shown
	 */

	// Injecting test (play framework)
	@Before
	public void setup() {
		com.google.inject.Module testModule = new AbstractModule() {
			@Override
			public void configure() {
				bind(ProposalService.class).to(MockProposalService.class);
			}
		};

		GuiceApplicationBuilder builder = new GuiceApplicationLoader().builder(new Context(Environment.simple()))
				.overrides(testModule);
		Guice.createInjector(builder.applicationModule()).injectMembers(this);

		Helpers.start(application);
	}

	@After
	public void teardown() {
		Helpers.stop(application);
	}

	// -------------------------Get when there is no proposal-------------------

	@Test
	public void testGetInServer() throws Exception {
		// play framework - test with a server
		int testServerPort = play.api.test.Helpers.testServerPort();
		play.test.TestServer server = play.test.Helpers.testServer(testServerPort);
		Assert.assertTrue(server != null);
		play.test.Helpers.running(server, () -> {
			try {
				try (WSClient ws = WS.newClient(testServerPort)) {
					CompletionStage<WSResponse> completionStage = ws
							.url("/proposal/fb0daecc-243c-11e7-93ae-92361f002671").get();
					WSResponse response = completionStage.toCompletableFuture().get();
					Assert.assertEquals(Http.Status.NOT_FOUND, response.getStatus());
				}
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		});
	}

	@Test
	public void testPosttInServer() throws Exception {
		int testServerPort = play.api.test.Helpers.testServerPort();
		play.test.TestServer server = play.test.Helpers.testServer(testServerPort);
		Assert.assertTrue(server != null);
		play.test.Helpers.running(server, () -> {
			try {
				try (WSClient ws = WS.newClient(testServerPort)) {

					// ------------------save-----------------------

					Proposal clientProposal = new Proposal("Name", "Description");
					Assert.assertFalse("No UUID in client input", clientProposal.uuid.isPresent());
					CompletionStage<WSResponse> completionStagePost = ws.url("/proposal/")
							.post(clientProposal.toJson());
					WSResponse postResponse = completionStagePost.toCompletableFuture().get();
					Assert.assertEquals("Post of proposal returns OK", Http.Status.OK, postResponse.getStatus());
					Proposal postResponseProposal = Proposal.fromJson(postResponse.getBody());
					Assert.assertNotNull("Proposal in post response", postResponseProposal);
					Assert.assertTrue("UUID in post response", postResponseProposal.uuid.isPresent());
					Assert.assertEquals("Name is same", clientProposal.name, postResponseProposal.name);
					Assert.assertEquals("Description is same", clientProposal.description,
							postResponseProposal.description);

					// -------------------get-------------------------

					UUID uuid = postResponseProposal.uuid.get();

					CompletionStage<WSResponse> completionStageGet = ws.url("/proposal/" + uuid.toString()).get();
					WSResponse getResponse = completionStageGet.toCompletableFuture().get();
					Assert.assertEquals("Get of proposal returns OK", Http.Status.OK, getResponse.getStatus());

					Proposal getResponseProposal = Proposal.fromJson(getResponse.getBody());
					Assert.assertNotNull("Proposal in get response", getResponseProposal);
					Assert.assertEquals("Post -> Get", postResponseProposal, getResponseProposal);

				}
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		});
	}

	@Test
	public void testPutInServer() throws Exception {
		int testServerPort = play.api.test.Helpers.testServerPort();
		play.test.TestServer server = play.test.Helpers.testServer(testServerPort);
		Assert.assertTrue(server != null);
		play.test.Helpers.running(server, () -> {
			try {
				try (WSClient ws = WS.newClient(testServerPort)) {

					// ------------------save-----------------------

					Proposal clientProposal = new Proposal("Name", "Description");
					Assert.assertFalse("No UUID in client input", clientProposal.uuid.isPresent());
					CompletionStage<WSResponse> completionStagePost = ws.url("/proposal/")
							.post(clientProposal.toJson());
					WSResponse postResponse = completionStagePost.toCompletableFuture().get();
					Assert.assertEquals("Post of proposal returns OK", Http.Status.OK, postResponse.getStatus());
					Proposal postResponseProposal = Proposal.fromJson(postResponse.getBody());
					Assert.assertNotNull("Proposal in post response", postResponseProposal);
					Assert.assertTrue("UUID in post response", postResponseProposal.uuid.isPresent());
					Assert.assertEquals("Name is same", clientProposal.name, postResponseProposal.name);
					Assert.assertEquals("Description is same", clientProposal.description,
							postResponseProposal.description);

					// -------------------update--------------------

					UUID uuid = postResponseProposal.uuid.get();

					Proposal changedClientProposal = new Proposal(uuid, "changedName", "Changed description", "date", "rank");
					CompletionStage<WSResponse> completionStagePut = ws.url("/proposal/")
							.put(changedClientProposal.toJson());
					WSResponse putResponse = completionStagePut.toCompletableFuture().get();
					Assert.assertEquals("Put of changed proposal returns OK", Http.Status.OK, putResponse.getStatus());
					Proposal putResponseProposal = Proposal.fromJson(putResponse.getBody());
					Assert.assertNotNull("Proposal in put response", putResponseProposal);
					Assert.assertTrue("UUID in put response", putResponseProposal.uuid.isPresent());
					Assert.assertEquals("Name is same", changedClientProposal.name, putResponseProposal.name);
					Assert.assertEquals("Description is same", changedClientProposal.description,
							putResponseProposal.description);

					// -------------------get-------------------------

					UUID changedProp_uuid = putResponseProposal.uuid.get();

					CompletionStage<WSResponse> completionStageGet = ws.url("/proposal/" + changedProp_uuid.toString())
							.get();
					WSResponse getResponse = completionStageGet.toCompletableFuture().get();
					Assert.assertEquals("Get of proposal returns OK", Http.Status.OK, getResponse.getStatus());

					Proposal getResponseProposal = Proposal.fromJson(getResponse.getBody());
					Assert.assertNotNull("Proposal in get response", getResponseProposal);
					Assert.assertEquals("Put -> Get", putResponseProposal, getResponseProposal);

				}
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		});
	}

	@Test
	public void testPutInServerNouuid() throws Exception {
		int testServerPort = play.api.test.Helpers.testServerPort();
		play.test.TestServer server = play.test.Helpers.testServer(testServerPort);
		Assert.assertTrue(server != null);
		play.test.Helpers.running(server, () -> {
			try {
				try (WSClient ws = WS.newClient(testServerPort)) {

					// ------------------save-----------------------

					Proposal clientProposal = new Proposal("Name", "Description");
					Assert.assertFalse("No UUID in client input", clientProposal.uuid.isPresent());
					CompletionStage<WSResponse> completionStagePost = ws.url("/proposal/")
							.post(clientProposal.toJson());
					WSResponse postResponse = completionStagePost.toCompletableFuture().get();
					Assert.assertEquals("Post of proposal returns OK", Http.Status.OK, postResponse.getStatus());
					Proposal postResponseProposal = Proposal.fromJson(postResponse.getBody());
					Assert.assertNotNull("Proposal in post response", postResponseProposal);
					Assert.assertTrue("UUID in post response", postResponseProposal.uuid.isPresent());
					Assert.assertEquals("Name is same", clientProposal.name, postResponseProposal.name);
					Assert.assertEquals("Description is same", clientProposal.description,
							postResponseProposal.description);

					// -----------update with non-valid UUID--------------

					ObjectNode propNode = (ObjectNode) clientProposal.toJson(); // type
																				// casting
					propNode.put("uuid", "this is not an UUID");
					CompletionStage<WSResponse> completionStagePut = ws.url("/proposal/").put(propNode);
					WSResponse putResponse = completionStagePut.toCompletableFuture().get();
					Assert.assertEquals("Put of rough proposal returns Bad request", Http.Status.BAD_REQUEST,
							putResponse.getStatus());

				}
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		});
	}

	@Test
	public void testListFunction() throws Exception {
		int testServerPort = play.api.test.Helpers.testServerPort();
		play.test.TestServer server = play.test.Helpers.testServer(testServerPort);
		Assert.assertTrue(server != null);
		play.test.Helpers.running(server, () -> {
			try {
				try (WSClient ws = WS.newClient(testServerPort)) {

					// ------------------save-----------------------

					for (int i = 0; i < 200; i++) {
						Proposal clientProposal = new Proposal("Name" + i, "Description" + i);
						Assert.assertFalse("No UUID in client input", clientProposal.uuid.isPresent());
						CompletionStage<WSResponse> completionStagePost = ws.url("/proposal/")
								.post(clientProposal.toJson());
						WSResponse postResponse = completionStagePost.toCompletableFuture().get();
						Assert.assertEquals("Post of proposal returns OK", Http.Status.OK, postResponse.getStatus());
						Proposal postResponseProposal = Proposal.fromJson(postResponse.getBody());
						Assert.assertNotNull("Proposal in post response", postResponseProposal);
						Assert.assertTrue("UUID in post response", postResponseProposal.uuid.isPresent());
						Assert.assertEquals("Name is same", clientProposal.name, postResponseProposal.name);
						Assert.assertEquals("Description is same", clientProposal.description,
								postResponseProposal.description);
					}

					// -------------------list-------------------------

					CompletionStage<WSResponse> completionStageGet = ws.url("/proposal/?offset=50&size=10").get();
					WSResponse listResponse = completionStageGet.toCompletableFuture().get();
					Assert.assertEquals("Get of proposal returns OK", Http.Status.OK, listResponse.getStatus());
					Logger.debug(">>>>>>" + listResponse.getBody() + "\n");
					List<Proposal> listResponseProposal = Proposal.fromJsonList(listResponse.getBody());
					Assert.assertNotNull("Proposals in post deserializable", listResponseProposal);
					Assert.assertFalse("Proposals in post response", listResponseProposal.isEmpty());
					// for (Proposal p : listResponseProposal) {
					// Logger.debug("++>>>>>>" + p.toJson().toString());
					// }

				}
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
			}
		});
	}
}
