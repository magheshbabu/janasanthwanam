package com.gsr.janasanth.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface FileService {
	void saveBytestoDisk(byte[] content, String path, String fileName) throws IOException;
	byte[] readBytesFromDisk(String path, String fileName) throws FileNotFoundException, IOException;
}
