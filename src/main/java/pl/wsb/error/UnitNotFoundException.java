package pl.wsb.error;

public class UnitNotFoundException extends RuntimeException {
	public UnitNotFoundException(Long id) {
		super("Unit id not found : " + id);
	}

}