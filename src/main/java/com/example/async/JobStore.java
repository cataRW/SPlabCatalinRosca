package com.example.async;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class JobStore {
    private final AtomicLong seq = new AtomicLong(0);
    private final Map<Long, JobView> jobs = new ConcurrentHashMap<>();

    public long newJob() {
        long id = seq.incrementAndGet();
        jobs.put(id, new JobView(id, JobStatus.PENDING, null, null));
        return id;
    }

    public JobView get(long id) {
        return jobs.get(id);
    }

    public void running(long id) {
        jobs.computeIfPresent(id, (k, v) -> { v.setStatus(JobStatus.RUNNING); return v; });
    }

    public void complete(long id, Object result) {
        jobs.computeIfPresent(id, (k, v) -> { v.setStatus(JobStatus.COMPLETED); v.setResult(result); return v; });
    }

    public void fail(long id, String error) {
        jobs.computeIfPresent(id, (k, v) -> { v.setStatus(JobStatus.FAILED); v.setError(error); return v; });
    }
}
