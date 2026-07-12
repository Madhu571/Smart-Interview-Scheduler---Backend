package SmartInterviewScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SmartInterviewScheduler.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

}