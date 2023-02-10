package com.mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mypackage.helper.FileUpload;

@Controller
public class FileUploadController {

	@Autowired
	FileUpload f;

	@PostMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "cannot upload an empty file";
		} else {
			f.upload(file);
			return "file uploaded successfully";
		}
	}

	@GetMapping("/home")
	public String home() {
		return "Upload.html";
	}
}
