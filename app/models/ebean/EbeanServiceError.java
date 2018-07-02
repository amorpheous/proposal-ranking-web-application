package models.ebean;

import services.ServiceError;


public class EbeanServiceError implements ServiceError {
	public final Throwable e;
	public EbeanServiceError(Throwable e) {
		this.e=e;
	}

}
