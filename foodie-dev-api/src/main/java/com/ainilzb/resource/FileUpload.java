package com.ainilzb.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:file-upload-dev.properties")
public class FileUpload {
    private String imageUserLocation;

    public String getImageUserLocation() {
        return imageUserLocation;
    }

    public void setImageUserLocation(String imageUserLocation) {
        this.imageUserLocation = imageUserLocation;
    }
}
