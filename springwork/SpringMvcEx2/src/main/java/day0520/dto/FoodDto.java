package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {
	private String foodname;//폼 태그의 name과 같아야 한다.
	private String foodphoto;
	private int price;
	private int cnt;
}
