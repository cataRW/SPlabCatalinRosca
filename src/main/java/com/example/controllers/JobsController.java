package com.example.controllers;

import com.example.async.JobStore;
import com.example.async.JobView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    private final JobStore jobs;

    public JobsController(JobStore jobs) {
        this.jobs = jobs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobView> get(@PathVariable long id) {
        JobView job = jobs.get(id);
        return (job == null) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(job);
    }
}
