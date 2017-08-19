package com.gsr.janasanth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to JHipster.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
	String fileRoot;
	ApekshaConfig apeksha;
	
	public void setApeksha(ApekshaConfig apeksha) {
		this.apeksha = apeksha;
	}

	public String getFileRoot() {
		return fileRoot;
	}

	public void setFileRoot(String fileRoot) {
		this.fileRoot = fileRoot;
	}
	
	public ApekshaConfig getApeksha() {
		return apeksha;
	}
}
