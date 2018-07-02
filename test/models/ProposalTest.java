package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ProposalTest {
	@Test
	public void toAndFromJsonWithoutUUID() {
		Proposal proposal = new Proposal("A name", "A descriptions");
		assertFalse("UUID from start empty", proposal.uuid.isPresent());
		String proposalJsonString = proposal.toJson().toString();
		Proposal proposalFromJson;
		try {
			proposalFromJson = Proposal.fromJson(proposalJsonString);
			assertFalse("UUID at end empty", proposalFromJson.uuid.isPresent());
			assertEquals("Name same", proposal.name, proposalFromJson.name);
			assertEquals("Description same", proposal.description, proposalFromJson.description);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			assertTrue("No exception", false);
		}

	}

	@Test
	public void toAndFromJsonWithUUID() {
		Proposal proposal = new Proposal(UUID.randomUUID(), "A name", "A descriptions", UUID.randomUUID(), "A rank");
		assertTrue("UUID from start present", proposal.uuid.isPresent());
		String proposalJsonString = proposal.toJson().toString();
		Proposal proposalFromJson;
		try {
			proposalFromJson = Proposal.fromJson(proposalJsonString);
			assertTrue("UUID at end present", proposalFromJson.uuid.isPresent());
			assertEquals("UUID same", proposal.uuid, proposalFromJson.uuid);
			assertEquals("Name same", proposal.name, proposalFromJson.name);
			assertEquals("Description same", proposal.description, proposalFromJson.description);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			assertTrue("No exception", false);
		}

	}

	@Test
	public void equalsWithoutUUID() {
		Proposal proposal1 = new Proposal("A name", "A descriptions");
		Proposal proposal2 = new Proposal("A name", "A descriptions");
		assertTrue("Equals", proposal1.equals(proposal2));
	}

	@Test
	public void notEqualsWithoutUUID() {
		Proposal proposal1 = new Proposal("A name", "A descriptions");
		Proposal proposal2 = new Proposal("Another name", "A descriptions");
		assertFalse("Name differs", proposal1.equals(proposal2));

		Proposal proposal1a = new Proposal("A name", "A descriptions");
		Proposal proposal2a = new Proposal("Another name", "Another descriptions");
		assertFalse("Name and description differs", proposal1a.equals(proposal2a));

		Proposal proposal1b = new Proposal("A name", "A descriptions");
		Proposal proposal2b = new Proposal("A name", "Another descriptions");
		assertFalse("Description differs", proposal1b.equals(proposal2b));
	}

	@Test
	public void equalsWithUUID() {
		UUID uuid = UUID.randomUUID();
		Proposal proposal1 = new Proposal(uuid, "A name", "A description");
		Proposal proposal2 = new Proposal(uuid, "A name", "A description");
		assertTrue("Equals", proposal1.equals(proposal2));
	}

	@Test
	public void notEqualsWtihUUID() {
		Proposal proposal1 = new Proposal(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "A name",
				"A description");
		Proposal proposal2 = new Proposal(UUID.fromString("40400000-8cf0-11bd-b23e-10b96e4ef00d"), "A name",
				"A description");
		assertFalse("UUID differs", proposal1.equals(proposal2));
	}
}
