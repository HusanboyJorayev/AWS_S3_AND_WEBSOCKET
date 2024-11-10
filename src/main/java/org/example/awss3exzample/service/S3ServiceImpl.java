package org.example.awss3exzample.service;


import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    public String bucketName = "bucketName";
    public String endpoint = "endpoint";
    public String accessKey = "accessKey";
    public String secretKey = "secretKey";

    @Override
    public String uploadFile(byte[] bytes) {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();
            String fileName = UUID.randomUUID() + "_" + "image.jpg";
            File file = new File(fileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(bytes);
                System.out.println("Fayl muvaffaqiyatli yozildi: " + file.getAbsolutePath());
                try (InputStream imageStream = new FileInputStream(file)) {
                    PutObjectArgs data = PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .stream(imageStream, file.length(), -1)
                            .build();
                    minioClient.putObject(data);
                    System.out.println("Image uploaded successfully to Minio!");

                    String imageUrl = minioClient.getPresignedObjectUrl(
                            GetPresignedObjectUrlArgs.builder()
                                    .bucket(bucketName)
                                    .object(fileName)
                                    .method(io.minio.http.Method.GET)
                                    .build());
                    System.out.println("Image URL: " + imageUrl);
                    return imageUrl;
                }
            } catch (IOException e) {
                return e.getMessage();
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

