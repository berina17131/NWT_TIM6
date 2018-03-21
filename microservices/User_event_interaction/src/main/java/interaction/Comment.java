package interaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    private Long commentId;
	private Long userId;
	private Long eventId;
    private String comment;

    public Comment(Long cId, Long uId, Long eId, String co) {
		this.commentId = cId;
		this.userId = uId;
		this.eventId = eId;
		this.comment = co;
    }

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long id) {
        this.commentId = id;
    }
	
	public String getUserId() {
        return this.userId;
    }

    public void setUserID(Long uId) {
        this.userId = uId;
    }
	
	public String getEventId() {
        return this.eventId;
    }
	
	public void setEventID(Long eId) {
        this.eventId = eId;
    }
	
	public String getComment() {
        return this.comment;
    }
	
	public void setGrade(String co) {
        this.comment = co;
    }
	
	@Override
    public String toString() {
        return String.format(
                "Comment[id=%d, user='%d', event='%d', comment='%s']",
                id, userId, eventId, comment);
    }
}
