package com.example.ecommerce.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.file.Paths;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public String uploadFile(MultipartFile file) throws IOException {
        String key = Paths.get(file.getOriginalFilename()).getFileName().toString();

        s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(key).build(),
                RequestBody.fromBytes(file.getBytes()));

        return s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toExternalForm();
    }
}

