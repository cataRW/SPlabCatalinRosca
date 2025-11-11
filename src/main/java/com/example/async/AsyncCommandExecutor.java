package com.example.async;

import com.example.commands.Command;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsyncCommandExecutor {
    private final ExecutorService pool = Executors.newFixedThreadPool(4);
    private final JobStore jobs;

    public AsyncCommandExecutor(JobStore jobs) {
        this.jobs = jobs;
    }

    public <R> long submit(Command<R> command) {
        long jobId = jobs.newJob();
        pool.submit(() -> {
            jobs.running(jobId);
            try {
                R result = command.execute();
                jobs.complete(jobId, result);
            } catch (Exception e) {
                jobs.fail(jobId, e.getMessage());
            }
        });
        return jobId;
    }
}
