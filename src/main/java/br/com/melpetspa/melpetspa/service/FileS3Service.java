package br.com.melpetspa.melpetspa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class FileS3Service {

    private final S3Client s3Client;

    @Value("${autosafe.s3.bucket-name}")
    private String bucketName;

    @Value("${cloud.aws.region.static}")
    private String region;

    public String uploadImage(MultipartFile file) throws IOException {
        String contentType = file.getContentType();

        if (!isImage(contentType)) {
            throw new IllegalArgumentException("Apenas arquivos JPG, JPEG e PNG são permitidos.");
        }

        String extension = contentType.equals("image/png") ? ".png" : ".jpg";
        String fileName = UUID.randomUUID().toString() + extension;

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, fileName);
    }

    private boolean isImage(String contentType) {
        return contentType != null &&
                (contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/jpg"));
    }

    public void deleteFileByUrl(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            String host = url.getHost();
            String objectKey = url.getPath().startsWith("/") ? url.getPath().substring(1) : url.getPath();

            if (!host.contains(bucketName)) {
                throw new IllegalArgumentException("A URL informada não pertence ao bucket autorizado.");
            }

            DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            s3Client.deleteObject(deleteRequest);
            log.info("Arquivo deletado com sucesso do S3. Bucket: {}, Key: {}", bucketName, objectKey);

        } catch (S3Exception e) {
            log.error("Erro ao deletar do S3: {}", e.awsErrorDetails().errorMessage());
            throw new RuntimeException("Erro ao deletar o arquivo do S3", e);
        } catch (Exception e) {
            log.error("Erro ao processar a URL do arquivo: {}", fileUrl, e);
            throw new IllegalArgumentException("URL inválida ou malformada: " + fileUrl);
        }
    }
}
