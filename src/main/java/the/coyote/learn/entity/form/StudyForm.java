package the.coyote.learn.entity.form;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.coyote.learn.entity.Study;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyForm {

	@Column(nullable = false, length = 50)
	private String stack;
	
	@Column(nullable = false, length = 100)
	private String subject;
	
	@Column(length = 255)
	private String description;
	
	@Column(name = "research_source")
	private String researchSource;

	public Study newStudy() {
		return new Study(stack, subject, description, researchSource );
	}
	
}
