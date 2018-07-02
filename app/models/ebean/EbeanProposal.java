package models.ebean;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import models.Proposal;

@Entity
public class EbeanProposal extends Model {

	@Id
	public UUID     uuid;
	public String   name;
	public String   description;
	public Date     date;
	public Date     udate;
	public int      rank;

	public EbeanProposal(Proposal p) {
		this.date = new Date();
		this.name = p.name;
		this.description = p.description;
		this.rank = p.rank;
	}

	public EbeanProposal(final String name, final String description, int rank) {
		this.name = name;
		this.description = description;
		this.rank = rank;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof EbeanProposal)) {
			return false;
		}
		EbeanProposal o = (EbeanProposal) other;
		return (uuid.equals(o.uuid) && name.equals(o.name) && description.equals(o.description) && date.equals(o.date));
	}

	public static EbeanProposal findByUUID(UUID uuid) {
		return EbeanProposal.find.where().eq("uuid", uuid).findUnique();
	}

	public Proposal asProposal() {
		return new Proposal(uuid, name, description, date, udate, rank);
	}
	
	public static Finder<Long, EbeanProposal> find = new Finder<Long, EbeanProposal>(EbeanProposal.class);

	public EbeanProposal updateWith(Proposal p, EbeanProposal inStore) {
		
		inStore.name = p.name;
		inStore.description = p.description;
		inStore.udate = p.udate;
		inStore.rank = p.rank;
		
		return inStore;
	} 


}
