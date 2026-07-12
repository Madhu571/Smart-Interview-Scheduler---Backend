package SmartInterviewScheduler.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SmartInterviewScheduler.entity.Candidate;
import SmartInterviewScheduler.service.CandidateService;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateService service;

    @PostMapping("/save")
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        return service.saveCandidate(candidate);
    }

    @GetMapping("/all")
    public List<Candidate> getAllCandidates() {
        return service.getAllCandidates();
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        return service.getCandidateById(id);
    }

    @PutMapping("/update/{id}")
    public Candidate updateCandidate(@PathVariable Long id,
                                     @RequestBody Candidate candidate) {
        return service.updateCandidate(id, candidate);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        return service.deleteCandidate(id);
    }
}
