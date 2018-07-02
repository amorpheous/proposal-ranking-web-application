package modules;

import com.google.inject.AbstractModule;

import services.ProposalService;
import services.ebean.EbeanProposalService;

public class EbeanServices extends AbstractModule {

	@Override
	protected void configure() {
		bind(ProposalService.class).to(EbeanProposalService.class);

	}

}
