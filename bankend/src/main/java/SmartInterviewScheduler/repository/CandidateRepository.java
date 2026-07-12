package SmartInterviewScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SmartInterviewScheduler.entity.Candidate;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
