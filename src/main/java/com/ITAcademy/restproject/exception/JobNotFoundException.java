package com.ITAcademy.restproject.exception;

public class JobNotFoundException extends RuntimeException {

public JobNotFoundException(String job) {

super("Could not find matches " + job);

}

}
