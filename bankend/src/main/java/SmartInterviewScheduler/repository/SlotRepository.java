package SmartInterviewScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SmartInterviewScheduler.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {

}