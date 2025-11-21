package com.example.umc9th.global.aws.s3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.umc9th.global.config.AmazonConfig;
import com.example.umc9th.global.entity.Uuid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Manager {

	private final AmazonS3 amazonS3;

	private final AmazonConfig amazonConfig;

	public String uploadFile(String keyName, MultipartFile file) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		try {
			amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName, file.getInputStream(), metadata));
		} catch (IOException e){
			log.error("error at AmazonS3Manager uploadFile : {}", (Object) e.getStackTrace());
		}

		return amazonS3.getUrl(amazonConfig.getBucket(), keyName).toString();
	}

	@Transactional
	public Map<Uuid, String> uploadFileAll(Map<Uuid, String> uuidKeyNameMap, List<MultipartFile> fileList) {
		List<Map.Entry<Uuid, String>> entryList = new ArrayList<>(uuidKeyNameMap.entrySet());
		int size = fileList.size();

		return IntStream.range(0, size)
			.boxed()
			.collect(Collectors.toMap(
				i -> entryList.get(i).getKey(),
				i -> {
					String keyName = entryList.get(i).getValue();
					MultipartFile file = fileList.get(i);
					return this.uploadFile(keyName, file);
				},
				(oldValue, newValue) -> oldValue,
				HashMap::new
			));
	}

	public String generateReviewKeyName(Uuid uuid) {
		return amazonConfig.getReviewPath() + '/' + uuid.getUuid();
	}
}
