package com.stackroute.muzixapp.exception;

public class TrackNotFoundException extends Exception {

private String message;

    public TrackNotFoundException() {
    }

    public TrackNotFoundException(String message) {
        this.message = message;
    }
}
