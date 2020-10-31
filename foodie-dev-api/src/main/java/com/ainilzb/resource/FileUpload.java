package com.ainilzb.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:file-upload-prod.properties")
public class FileUpload {
    private String imageUserLocation;
    private String imageServerUrl;

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }

    public String getImageUserLocation() {
        return imageUserLocation;
    }

    public void setImageUserLocation(String imageUserLocation) {
        this.imageUserLocation = imageUserLocation;
    }
}
