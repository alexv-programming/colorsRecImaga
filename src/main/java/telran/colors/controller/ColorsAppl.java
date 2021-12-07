package telran.colors.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.colors.dto.colorsDto;
//import telran.imagga.dto.ResponseDto;

public class ColorsAppl {
	final static String TOKEN = "Basic YWNjX2ZlMTk5MjY0YmEyNTRkNzo0NDVjYjUyM2NiZjg5MGRiYzAxYTU3YjVhYTFlNzM3Yw==";
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		String httpUrl = "https://api.imagga.com/v2/colors";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(httpUrl)
				.queryParam("image_url", "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg")
				//			.queryParam("language", "ru")
				//			.queryParam("limit", 3)
				;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", TOKEN);
		
		
		
		RequestEntity<String> requestEntity = 
				new RequestEntity<String>(headers , HttpMethod.GET, builder.build().toUri());
		ResponseEntity<colorsDto> responseEntity =
				restTemplate.exchange(requestEntity, colorsDto.class);
		System.out.println("color name \t\tparent color name\t coverage percent");
		responseEntity.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
		responseEntity.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
		responseEntity.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);
	}

}
