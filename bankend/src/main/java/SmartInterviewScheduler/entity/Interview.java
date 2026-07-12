package SmartInterviewScheduler.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name="interviewer_id")
    private Interviewer interviewer;

    @OneToOne
    @JoinColumn(name="slot_id")
    private Slot slot;

    private String status;

    public Interview() {
    }

    public Interview(Long id, Candidate candidate, Interviewer interviewer, Slot slot, String status) {
        this.id = id;
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.slot = slot;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}