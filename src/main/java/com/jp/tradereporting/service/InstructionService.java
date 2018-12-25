package com.jp.tradereporting.service;

import java.io.File;
import java.util.List;

import com.jp.tradereporting.vo.InstructionVO;

public interface InstructionService {

	public List<InstructionVO> loadInstructions(File instructionFile);
	

}
