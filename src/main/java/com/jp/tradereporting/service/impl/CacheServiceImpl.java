package com.jp.tradereporting.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jp.tradereporting.service.CacheService;
import com.jp.tradereporting.vo.InstructionVO;

public class CacheServiceImpl implements CacheService {
	private List<InstructionVO> instructions = new ArrayList<>();

	@Override
	public void persist(List<InstructionVO> instructions) {
		this.instructions.addAll(instructions);
	}

	@Override
	public List<InstructionVO> getInstructions() {
		return Collections.unmodifiableList(instructions);
	}

}
