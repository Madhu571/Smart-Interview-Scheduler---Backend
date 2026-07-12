package SmartInterviewScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SmartInterviewScheduler.entity.Slot;
import SmartInterviewScheduler.service.SlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    SlotService service;

    @PostMapping("/save")
    public Slot saveSlot(@RequestBody Slot slot) {
        return service.saveSlot(slot);
    }

    @GetMapping("/all")
    public List<Slot> getAllSlots() {
        return service.getAllSlots();
    }

    @GetMapping("/{id}")
    public Slot getSlot(@PathVariable Long id) {
        return service.getSlotById(id);
    }

    @PutMapping("/update/{id}")
    public Slot updateSlot(@PathVariable Long id,
                           @RequestBody Slot slot) {
        return service.updateSlot(id, slot);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSlot(@PathVariable Long id) {
        return service.deleteSlot(id);
    }
}