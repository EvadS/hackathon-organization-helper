package com.se.hackathon.helper.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends RuntimeException  {
    private final String resourceTypeName;
    private final String name;
    private final String uniqueIdentifier;

    /**
     * Resouce already exists exception
     * @param resourceTypeName Type off resource in String format
     * @param name value to check unique
     * @param uniqueIdentifier columns or value for check unique identifier
     */
    public AlreadyExistException(String resourceTypeName, String name, String uniqueIdentifier) {
        super(String.format("%s with %s '%s' already exists.", resourceTypeName,name, uniqueIdentifier  ));        this.resourceTypeName = resourceTypeName;
        this.name = name;
        this.uniqueIdentifier= uniqueIdentifier;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public String getName() {
        return name;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }
}
