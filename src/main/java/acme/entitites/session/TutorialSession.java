
package acme.entitites.session;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entitites.tutorial.Tutorial;
import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TutorialSession extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 75)
	protected String			tittle;

	@NotBlank
	@Length(max = 100)
	protected String			summary;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@PastOrPresent
	protected Date				creationMoment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				endDate;

	@URL
	protected String			link;

	//Relations -----------------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne
	protected Tutorial			tutorial;

}
