package ar.edu.info.unlp.bd2.etapa2.model;

public enum ReservationStatus {
	
	CONFIRMATION_PENDING("A Confirmar"),
	CONFIRMED("Confirmada"),
	CANCELED("Cancelada"),
	FINISHED("Terminada");
	
	private String description;

	private ReservationStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}