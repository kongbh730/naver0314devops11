package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import data.dto.ReBoardDto;
import data.mapper.ReBoardMapperInter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReBoardService {
	@NonNull
	private ReBoardMapperInter boardMapper;
	
	public int getMaxNum()
	{
		return boardMapper.getMaxNum();
	}
	
	public void updateRestep(int regroup, int restep)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		boardMapper.updateRestep(map);
	}
	
	public void insertBoard(ReBoardDto dto)//계층형 구조 로직 
	{
		int num = dto.getNum();
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		 
		if(num == 0)
		{
			regroup = boardMapper.getMaxNum() + 1;
			restep = 0;
			relevel = 0;
		}
		else
		{
			//전달받는 restep 보다 큰 restep 은 모두 + 1 하기
			this.updateRestep(regroup, restep);
			//전달 받은 restep, reslevel에 + 1
			restep += 1;
			relevel += 1;
		}
		//dto에 변경된 값 넣기
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//db에 insert
		boardMapper.insertBoard(dto);
	}
	
	public int getTotalCount()
	{
		return boardMapper.getTotalCount();
	}
	
	public List<ReBoardDto> getPagingList(int start, int perpage)
	{
		Map <String, Integer> map= new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return boardMapper.getPagingList(map);
	}
	
	public void updateReadCount(int num)
	{
		boardMapper.updateReadCount(num);
	}
	
	public ReBoardDto getData(int num)
	{
		return boardMapper.getData(num);
	}
	
	public void updateBoard(ReBoardDto dto)
	{
		boardMapper.updateBoard(dto);
	}
	
	public void deleteBoard(int num)
	{
		boardMapper.deleteBoard(num);
	}
}
