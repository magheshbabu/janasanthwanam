package com.gsr.janasanth.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsr.janasanth.config.ApplicationProperties;
import com.gsr.janasanth.service.FileService;

@Service
@Transactional
public class FileServiceImpl implements FileService{
	
	private final ApplicationProperties properties;
	public FileServiceImpl(ApplicationProperties properties){
		this.properties = properties;
	}
	

	@Override
	public void saveBytestoDisk(byte[] content, String path, String fileName) throws IOException {
		
		File file = new File(properties.getFileRoot() + path + fileName);
		file.getParentFile().mkdirs();
		
		IOUtils.write(content, new FileOutputStream(file));
		
	}

	@Override
	public byte[] readBytesFromDisk(String path, String fileName) throws FileNotFoundException, IOException {
		
		File file = new File(properties.getFileRoot() + path + fileName);
		if(file.exists()){
			return IOUtils.toByteArray(new FileInputStream(file));
		}
		
		return null;
	}

}
