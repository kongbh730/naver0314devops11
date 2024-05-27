package data.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

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
}
