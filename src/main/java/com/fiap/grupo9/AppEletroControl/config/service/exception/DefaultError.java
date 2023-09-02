package com.fiap.grupo9.AppEletroControl.config.service.exception;

import java.time.Instant;

public class DefaultError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public DefaultError() {
    }

    public DefaultError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public DefaultError setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public DefaultError setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public DefaultError setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public DefaultError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public DefaultError setPath(String path) {
        this.path = path;
        return this;
    }
}
