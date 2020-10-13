package com.patrick.bankdemo.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.patrick.bankdemo.services.exceptions.FileException;

@Service
public class S3service {

	private Logger LOG = LoggerFactory.getLogger(S3service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartFile) {		
		try {
		String filename = multipartFile.getOriginalFilename();
		InputStream inputStream = multipartFile.getInputStream();
		String contentType = multipartFile.getContentType();
		return uploadFile(inputStream, filename, contentType);					
		} catch (IOException e) {
			throw new FileException("IO error: " + e.getMessage());
		}
			
	}

	public URI uploadFile(InputStream inputStream, String fileName, String contentType) {
		try {
			ObjectMetadata objectMetadata = new ObjectMetadata();		
			LOG.info("starting uploading");
			s3client.putObject(bucketName, fileName, inputStream, objectMetadata);
			LOG.info("finish");
			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Error converting URL to URI");
		}
	}
	
}
