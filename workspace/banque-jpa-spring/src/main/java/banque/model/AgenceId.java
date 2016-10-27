package banque.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;


@SuppressWarnings("serial")
@Embeddable
public class AgenceId implements Serializable {
	private Integer numBanque;
	private Integer numAgence;

	public AgenceId() {
		super();
	}

	public AgenceId(Integer numBanque, Integer numAgence) {
		super();
		this.numBanque = numBanque;
		this.numAgence = numAgence;
	}

	@NotNull(message="{AgenceId.numBanque.null}")
	public Integer getNumBanque() {
		return numBanque;
	}

	public void setNumBanque(Integer numBanque) {
		this.numBanque = numBanque;
	}

	@NotNull(message="{AgenceId.numAgence.null}")
	public Integer getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(Integer numAgence) {
		this.numAgence = numAgence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numAgence == null) ? 0 : numAgence.hashCode());
		result = prime * result + ((numBanque == null) ? 0 : numBanque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgenceId other = (AgenceId) obj;
		if (numAgence == null) {
			if (other.numAgence != null)
				return false;
		} else if (!numAgence.equals(other.numAgence))
			return false;
		if (numBanque == null) {
			if (other.numBanque != null)
				return false;
		} else if (!numBanque.equals(other.numBanque))
			return false;
		return true;
	}

}
