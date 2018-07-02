package services.ebean;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import models.Proposal;
import models.ebean.EbeanProposal;
import models.ebean.EbeanServiceError;
import scala.util.Either;
import scala.util.Left;
import scala.util.Right;
import services.ServiceError;

public class EbeanProposalService implements services.ProposalService {

	// ------------update or save proposal in data base--------------

	@Override
	public Either<ServiceError, Proposal> put(Proposal p) {
		if (p.uuid.isPresent()) { // Update of existing proposal
			EbeanProposal inStore = EbeanProposal.findByUUID(p.uuid.get());

			if (inStore.uuid == null) { // No such proposal found!
				Throwable e = new Throwable();
				return Left.apply(new EbeanServiceError(e));
			} else {
				try {
					inStore.updateWith(p, inStore);
					inStore.udate = new Date();
					inStore.update();
					return Right.apply(inStore.asProposal());
				} catch (Throwable e) {
					return Left.apply(new EbeanServiceError(e));
				}
			}
		} else {
			// Adding a new proposal
			EbeanProposal toStore = new EbeanProposal(p);
			if (toStore.udate == null) {
				toStore.udate = new Date();
			}
			try {
				toStore.save();
				return Right.apply(toStore.asProposal());
			} catch (Throwable e) {
				return Left.apply(new EbeanServiceError(e));
			}
		}
	}


	//---------------------get proposal------------------------------
	
	@Override
	public Optional<Proposal> get(UUID uuid) {
		return Optional.ofNullable(EbeanProposal.findByUUID(uuid)).map(p -> p.asProposal());
	}


	//---------------------list proposals----------------------------
	
	@Override
	public List<Proposal> list(Optional<Integer> offset, Optional<Integer> size) {
		List<EbeanProposal> result = null;
		if (size.isPresent()) {
			result = EbeanProposal.find.findPagedList(offset.orElse(0), size.get()).getList();
		} else {
			result = EbeanProposal.find.all();
		}
		return result.stream().map(p -> p.asProposal()).collect(Collectors.toList());
	}
	
	//--------------------------delete proposal----------------------
	
	@Override
	public void delete(UUID uuid) {
		EbeanProposal  proposal = EbeanProposal.findByUUID(uuid);
		proposal.delete();
	}

}
