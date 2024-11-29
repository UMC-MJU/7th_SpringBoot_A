package umc.spring.service.Review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.repository.reviewImage.ReviewImageRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewImageServiceImpl implements ReviewImageService{

    private final String uploadDir = "/uploads/reviews"; // 저장 디렉토리 경로

    private final ReviewImageRepository reviewImageRepository;

    @Override
    public String addReviewImage(MultipartFile image, Review review) {
        try {
            // 1. 고유 파일 이름 생성
            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();

            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

            Files.createDirectories(filePath.getParent());

            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            ReviewImage reviewImage = ReviewImage.builder()
                    .imageURL(filePath.toString())
                    .review(review)
                    .build();

            return reviewImageRepository.save(reviewImage).toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
