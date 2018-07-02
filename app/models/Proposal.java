package models;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;

public class Proposal {

	public final Optional<UUID> uuid;
	public final String name;
	public final String description;
	public final Date   date;
	public       Date   udate;
	public       int    rank;
	

	public Proposal(final String name, final String description) {
		this.uuid = Optional.empty();
		this.name = name;
		this.description = description;
		this.date = null;
		this.udate = null;
		this.rank = 0;
	}

	// för kommunikation mellan klient och server
	@JsonCreator
	public Proposal(@JsonProperty("uuid") final UUID uuid, @JsonProperty("name") final String name,
			@JsonProperty("description") final String description, @JsonProperty("date") final Date date, @JsonProperty("udate") Date udate, @JsonProperty("rank") int rank)  {
		this.uuid = Optional.ofNullable(uuid);
		this.name = name;
		this.description = description;
		this.date = date;
		this.udate = udate;
		this.rank = rank;
	}

	public Proposal(Proposal p) {
		this.uuid = p.uuid;
		this.name = p.name;
		this.description = p.description;
		this.date = p.date;
		this.udate = p.udate;
		this.rank = p.rank;
	}

	public static Proposal withUUID(Proposal p) {
		assert !p.uuid.isPresent();
		return new Proposal(UUID.randomUUID(), p.name, p.description, p.date, p.udate, p.rank);
	}

	public static Proposal fromJson(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.treeToValue(Json.parse(json), Proposal.class);
		/*
		 * catch (JsonProcessingException e) { e.printStackTrace(); return null;
		 * }
		 */
	}

	public static List<Proposal> fromJsonList(String jsonList) throws IOException {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(jsonList, new TypeReference<List<Proposal>>() {
			}); // deserializing to arraylist<pojo>
		} catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}

	public Proposal asProposal() {
		return new Proposal(uuid.get(), name, description, date, udate, rank);
	}

	public JsonNode toJson() { // to parse & write Json file
		JsonNode result = Json.toJson(this); // toJson returns a copy of the
												// attributes as an object
		return result;
	}
	
	public void incrementRank() {
		this.rank = this.rank+1;
	}

	public void decrementRank() {
		this.rank = this.rank-1;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Proposal)) {
			return false;
		}
		Proposal o = (Proposal) other;
		return (uuid.equals(o.uuid) && name.equals(o.name) && description.equals(o.description));
	}

//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		Proposal other = (Proposal) o;
//		return Integer.compare(rank, other.rank);
//	}

}
