package com.example.umc9th.domain.review.service.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.umc9th.domain.review.dto.req.ReviewReqDto;

public interface ReviewCommandService {
	void addReview(ReviewReqDto.AddReview reviewReqDto, List<MultipartFile> imageList);
}
