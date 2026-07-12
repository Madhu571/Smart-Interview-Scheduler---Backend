package SmartInterviewScheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartInterviewScheduler.entity.Slot;
import SmartInterviewScheduler.repository.SlotRepository;

@Service
public class SlotService {

    @Autowired
    SlotRepository repository;

    public Slot saveSlot(Slot slot) {
        return repository.save(slot);
    }

    public List<Slot> getAllSlots() {
        return repository.findAll();
    }

    public Slot getSlotById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Slot updateSlot(Long id, Slot slot) {

        Slot existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setDate(slot.getDate());
            existing.setStartTime(slot.getStartTime());
            existing.setEndTime(slot.getEndTime());
            existing.setStatus(slot.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    public String deleteSlot(Long id) {
        repository.deleteById(id);
        return "Slot Deleted Successfully";
    }
}