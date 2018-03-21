package interaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    private Long statusId;
	private Long userId;
	private Long eventId;
    private String status;

    public Status(Long stId, Long uId, Long eId, String st) {
		this.statusId = stId;
		this.userId = uId;
		this.eventId = eId;
		this.status = st;
    }

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long id) {
        this.statusId = id;
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
	
	public String getStatus() {
        return this.status;
    }
	
	public void setStatus(String st) {
        this.status = st;
    }
	
	@Override
    public String toString() {
        return String.format(
                "Status[id=%d, user='%d', event='%d', status='%s']",
                id, userId, eventId, status);
    }
}
