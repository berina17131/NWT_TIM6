package interaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Grade {

    private Long gradeId;
	private Long userId;
	private Long eventId;
    private Long grade;

    public Grade(Long gId, Long uId, Long eId, Long gr) {
		this.gradeId = gId;
		this.userId = uId;
		this.eventId = eId;
		this.grade = gr;
    }

    public Long getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Long id) {
        this.gradeId = id;
    }
	
	public Long getUserId() {
        return this.userId;
    }

    public void setUserID(Long uId) {
        this.userId = uId;
    }
	
	public Long getEventId() {
        return this.eventId;
    }
	
	public void setEventID(Long eId) {
        this.eventId = eId;
    }
	
	public Long getGrade() {
        return this.grade;
    }
	
	public void setGrade(Long gr) {
        this.grade = gr;
    }
	
	@Override
    public String toString() {
        return String.format(
                "Grade[id=%d, user='%d', event='%d', grade='%d']",
                id, userId, eventId, grade);
    }
}
