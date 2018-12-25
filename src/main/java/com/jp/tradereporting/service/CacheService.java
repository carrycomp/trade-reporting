package com.jp.tradereporting.service;

import java.util.List;

import com.jp.tradereporting.vo.InstructionVO;

public interface CacheService {

	public void persist(List<InstructionVO> instructions);

	public List<InstructionVO> getInstructions();

}
