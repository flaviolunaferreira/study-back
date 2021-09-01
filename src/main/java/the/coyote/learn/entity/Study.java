package the.coyote.learn.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String stack;
	
	@Column(nullable = false, length = 100)
	private String subject;
	
	@Column(length = 255)
	private String description;
	
	@Column(name = "research_source")
	private String researchSource;
	
	@Builder.Default
	@OneToMany(mappedBy = "study")
	private List<Example> example = new ArrayList<Example>();

	@Builder.Default
	@OneToMany(mappedBy = "study")
	private List<Videos> videos = new ArrayList<Videos>();
	
	@Builder.Default
	private LocalDate createdAt = LocalDate.now();
	
	private LocalDate UpdatedAt;

	public Study(String stack, String subject, String description, String researchSource) {
		super();
		this.stack = stack;
		this.subject = subject;
		this.description = description;
		this.researchSource = researchSource;
	}
	
	
}
