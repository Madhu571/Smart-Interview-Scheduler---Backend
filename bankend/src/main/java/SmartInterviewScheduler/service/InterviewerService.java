package SmartInterviewScheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartInterviewScheduler.entity.Interviewer;
import SmartInterviewScheduler.repository.InterviewerRepository;

@Service
public class InterviewerService {

    @Autowired
    InterviewerRepository repository;

    public Interviewer saveInterviewer(Interviewer interviewer) {
        return repository.save(interviewer);
    }

    public List<Interviewer> getAllInterviewers() {
        return repository.findAll();
    }

    public Interviewer getInterviewerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Interviewer updateInterviewer(Long id, Interviewer interviewer) {

        Interviewer existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(interviewer.getName());
            existing.setEmail(interviewer.getEmail());
            existing.setDepartment(interviewer.getDepartment());
            existing.setSpecialization(interviewer.getSpecialization());

            return repository.save(existing);
        }

        return null;
    }

    public String deleteInterviewer(Long id) {

        repository.deleteById(id);

        return "Interviewer Deleted Successfully";
    }

}