package SmartInterviewScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SmartInterviewScheduler.entity.Interview;
import SmartInterviewScheduler.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    InterviewService service;

    @PostMapping("/schedule")
    public Interview scheduleInterview(
            @RequestParam Long candidateId,
            @RequestParam Long interviewerId,
            @RequestParam Long slotId){

        return service.scheduleInterview(candidateId,
                interviewerId,
                slotId);
    }

    @GetMapping("/all")
    public List<Interview> getAllInterviews(){
        return service.getAllInterviews();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInterview(@PathVariable Long id){
        return service.deleteInterview(id);
    }

}
