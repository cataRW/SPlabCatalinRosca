package com.example.async;

public class JobView {
    private long id;
    private JobStatus status;
    private Object result;
    private String error;

    public JobView() { }

    public JobView(long id, JobStatus status, Object result, String error) {
        this.id = id; this.status = status; this.result = result; this.error = error;
    }

    public long getId() {
        return id;
    }

    public JobStatus getStatus() {
        return status;
    }

    public Object getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setError(String error) {
        this.error = error;
    }
}
