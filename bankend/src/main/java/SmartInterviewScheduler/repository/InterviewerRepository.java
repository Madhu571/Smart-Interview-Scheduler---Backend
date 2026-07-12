package SmartInterviewScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SmartInterviewScheduler.entity.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {

}