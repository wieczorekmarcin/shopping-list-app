package pl.wsb.error;

public class StoreNotFoundException extends RuntimeException {
	public StoreNotFoundException(Long id) {
		super("Store id not found : " + id);
	}

}