package SmartInterviewScheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartInterviewScheduler.entity.*;
import SmartInterviewScheduler.repository.*;

@Service
public class InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    InterviewerRepository interviewerRepository;

    @Autowired
    SlotRepository slotRepository;

    public Interview scheduleInterview(Long candidateId,
                                       Long interviewerId,
                                       Long slotId) {

        Candidate candidate =
                candidateRepository.findById(candidateId).orElse(null);

        Interviewer interviewer =
                interviewerRepository.findById(interviewerId).orElse(null);

        Slot slot =
                slotRepository.findById(slotId).orElse(null);

        if(candidate == null || interviewer == null || slot == null) {
            return null;
        }

        if(!slot.getStatus().equalsIgnoreCase("AVAILABLE")) {
            return null;
        }

        Interview interview = new Interview();

        interview.setCandidate(candidate);
        interview.setInterviewer(interviewer);
        interview.setSlot(slot);
        interview.setStatus("SCHEDULED");

        slot.setStatus("BOOKED");
        slotRepository.save(slot);

        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public String deleteInterview(Long id) {
        interviewRepository.deleteById(id);
        return "Interview Deleted Successfully";
    }
}