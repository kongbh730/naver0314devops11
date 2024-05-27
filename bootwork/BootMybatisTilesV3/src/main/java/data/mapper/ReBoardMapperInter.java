package data.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ReBoardDto;

@Mapper
public interface ReBoardMapperInter {
	public int getMaxNum();
	public void updateRestep(Map<String, Integer> map);//regroup, restep
	public void insertBoard(ReBoardDto dto);
}