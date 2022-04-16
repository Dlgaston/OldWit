package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.repository.ImageRepository;

@Controller
public class ImageController {
	
	
	@Autowired
	ImageRepository imageRepository;

}
