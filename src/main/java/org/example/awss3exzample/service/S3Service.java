package org.example.awss3exzample.service;

import org.springframework.stereotype.Component;

@Component
public interface S3Service {
    String uploadFile(byte[] bytes);
}
