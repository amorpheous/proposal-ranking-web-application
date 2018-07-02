package modules;

import com.google.inject.AbstractModule;

import services.ProposalService;
import services.mockup.MockProposalService;

public class MockupServices extends AbstractModule {

	@Override
	protected void configure() {
		bind(ProposalService.class).to(MockProposalService.class);
		
	}
	

}
