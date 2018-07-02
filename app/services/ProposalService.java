package services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import models.Proposal;
import scala.util.Either;

public interface ProposalService {

	public Either<ServiceError, Proposal> put(Proposal p);

	public Optional<Proposal> get(UUID id);

	public List<Proposal> list(Optional<Integer> offset, Optional<Integer> size);
	
	public void  delete(UUID id);
	
 
}
