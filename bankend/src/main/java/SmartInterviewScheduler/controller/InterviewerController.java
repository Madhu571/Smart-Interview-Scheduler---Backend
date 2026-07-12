package SmartInterviewScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SmartInterviewScheduler.entity.Interviewer;
import SmartInterviewScheduler.service.InterviewerService;

@RestController
@RequestMapping("/interviewer")
public class InterviewerController {

    @Autowired
    InterviewerService service;

    @PostMapping("/save")
    public Interviewer saveInterviewer(@RequestBody Interviewer interviewer) {

        return service.saveInterviewer(interviewer);
    }

    @GetMapping("/all")
    public List<Interviewer> getAllInterviewers() {

        return service.getAllInterviewers();
    }

    @GetMapping("/{id}")
    public Interviewer getInterviewer(@PathVariable Long id) {

        return service.getInterviewerById(id);
    }

    @PutMapping("/update/{id}")
    public Interviewer updateInterviewer(@PathVariable Long id,
                                         @RequestBody Interviewer interviewer) {

        return service.updateInterviewer(id, interviewer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInterviewer(@PathVariable Long id) {

        return service.deleteInterviewer(id);
    }

}