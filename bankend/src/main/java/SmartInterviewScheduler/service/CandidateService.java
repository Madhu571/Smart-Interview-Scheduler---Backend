package SmartInterviewScheduler.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartInterviewScheduler.entity.Candidate;
import SmartInterviewScheduler.repository.CandidateRepository;



@Service
public class CandidateService {

    @Autowired
    CandidateRepository repository;

    public Candidate saveCandidate(Candidate candidate) {
        return repository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(candidate.getName());
            existing.setEmail(candidate.getEmail());
            existing.setPhone(candidate.getPhone());
            existing.setSkill(candidate.getSkill());
            existing.setExperience(candidate.getExperience());

            return repository.save(existing);
        }

        return null;
    }

    public String deleteCandidate(Long id) {
        repository.deleteById(id);
        return "Candidate Deleted Successfully";
    }
}
