package com.mypackage.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	String folderPath = "F:\\documents";

	@RequestMapping("/")
	public String showFiles(Model model) {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		model.addAttribute("files", listOfFiles);
		return "showFiles";

	}

	@RequestMapping("/file/{fileName}")
	@ResponseBody
	public void show(@PathVariable("fileName") String fileName, HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			try (FileInputStream fis = new FileInputStream(folderPath + fileName)) {
				int len;
				while ((len = fis.read()) != -1) {
					bos.write(len);
				}
			}
			bos.close();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
