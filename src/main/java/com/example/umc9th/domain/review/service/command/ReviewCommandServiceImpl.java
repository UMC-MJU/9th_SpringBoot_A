package com.example.umc9th.domain.review.service.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.converter.ReviewImageConverter;
import com.example.umc9th.domain.review.dto.req.ReviewReqDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.entity.ReviewImage;
import com.example.umc9th.domain.review.repository.ReviewImageRepository;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.domain.shop.exception.ShopException;
import com.example.umc9th.domain.shop.exception.code.ShopErrorCode;
import com.example.umc9th.domain.shop.repository.ShopRepository;
import com.example.umc9th.global.aws.s3.AmazonS3Manager;
import com.example.umc9th.global.converter.UuidConverter;
import com.example.umc9th.global.entity.Uuid;
import com.example.umc9th.global.repository.UuidRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

	private final ReviewRepository reviewRepository;
	private final ReviewImageRepository reviewImageRepository;
	private final MemberRepository memberRepository;
	private final ShopRepository shopRepository;
	private final UuidRepository uuidRepository;

	private final AmazonS3Manager s3Manager;

	@Override
	@Transactional
	public void createReview(ReviewReqDto.CreateReview reviewReqDto, List<MultipartFile> imageList) {
		Member member = memberRepository.findById(reviewReqDto.getMemberId())
			.orElseThrow(() -> new MemberException(MemberErrorCode.BAD_REQUEST));

		Shop shop = shopRepository.findById(reviewReqDto.getShopId())
			.orElseThrow(() -> new ShopException(ShopErrorCode.BAD_REQUEST));

		Review review = ReviewConverter.toReview(reviewReqDto, member, shop);
		reviewRepository.save(review);

		createReviewImageList(review, imageList);
	}

	private void createReviewImageList(Review review, List<MultipartFile> imageList) {

		List<Uuid> uuidList = IntStream.range(0, imageList.size())
			.mapToObj(i -> UUID.randomUUID().toString())
			.map(UuidConverter::toUuid)
			.collect(Collectors.toList());

		uuidList = uuidRepository.saveAll(uuidList);

		Map<Uuid, String> uuidKeyNameMap = uuidList.stream()
			.collect(Collectors.toMap(
				uuid -> uuid,
				s3Manager::generateReviewKeyName,
				(oldValue, newValue) -> oldValue,
				HashMap::new
			));

		Map<Uuid, String> urlList = s3Manager.uploadFileAll(uuidKeyNameMap, imageList);

		List<ReviewImage> reviewImageList = new ArrayList<>();
		urlList.forEach((key, value) ->
			reviewImageList.add(ReviewImageConverter.toReviewImage(value, review, key)));
		reviewImageRepository.saveAll(reviewImageList);
	}
}
