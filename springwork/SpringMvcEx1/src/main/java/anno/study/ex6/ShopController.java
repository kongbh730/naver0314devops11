package anno.study.ex6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("shopcont")//자동아이디 말고 아이디 지정해주기
@AllArgsConstructor //만약 멤버변수가 dao외에 많다면 @RequiredArgsConstructor를 하는게 좋다
public class ShopController 
{
	ShopDao dao;
	
	public void insert(String sang, int su, int dan)
	{
		ShopDto dto = new ShopDto(sang, su, dan);
		dao.insert(dto);
		
		dao.selectAll();
	}
	
	public void delete(String sang)
	{
		dao.delete(sang);
		
		dao.selectAll();
	}
	
	public void update(String sang, int su, int dan)
	{
		ShopDto dto = new ShopDto();
		dto.setSang(sang);
		dto.setSu(su);
		dto.setDan(dan);
		dao.update(dto);
		
		dao.selectAll();
	}
}
