package com.example.uploads3.controller;

import com.example.uploads3.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
  @Autowired
  private AmazonService amazonService;

  @PostMapping("/upload-file")
  public ResponseEntity uploadFile(@RequestPart(value = "file") MultipartFile file) {
    String link = amazonService.uploadFile(file);
    return ResponseEntity.ok(link);
  }
}
