package services.mockup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import models.Proposal;
import play.Logger;
import scala.util.Either;
import services.ServiceError;

public class MockProposalService implements services.ProposalService {

	private static final Map<String, Proposal> DB = new HashMap<>();

	// ------------save proposal in data base--------------

	@Override
	public Either<ServiceError, Proposal> put(final Proposal p) {
		Proposal result = p;
		if (!p.uuid.isPresent()) {
			result = Proposal.withUUID(p); // create a new proposal with uuid
		}
		DB.put(result.uuid.get().toString(), result);
		return scala.util.Right.apply(result);
	}

	@Override
	public Optional<Proposal> get(UUID id) {

		// logInDB();
		Proposal result = DB.get(id.toString());
		// if (result != null) {
		// Logger.info("===============Retreived: " +
		// result.toJson().toString());
		// return Optional.of(result);
		// }
		return Optional.ofNullable(result);
	}

	@Override
	public List<Proposal> list(Optional<Integer> offset, Optional<Integer> size) {

		ArrayList<Proposal> proposalList = new ArrayList<Proposal>();
		ArrayList<Proposal> proposalListChunk = new ArrayList<Proposal>();
		proposalList.addAll(DB.values());
		int numberOfProposals = proposalList.size();
		int n = offset.orElse(0);
		int chunk = size.orElse(numberOfProposals);

		for (int i = n; i < chunk + n; i++)
			if (i >= numberOfProposals)
				break;
			else
				proposalListChunk.add(proposalList.get(i));
		return proposalListChunk;

	}

	private void logInDB() {
		for (Map.Entry<String, Proposal> d : DB.entrySet()) {
			Logger.info("===============Stored: " + d.getKey() + ":" + d.getValue().toJson().toString());

		}
	}

	@Override
	public void delete(UUID id) {
		
	}
}
