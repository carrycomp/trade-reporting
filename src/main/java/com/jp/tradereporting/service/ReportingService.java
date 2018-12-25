package com.jp.tradereporting.service;

import java.util.List;

import com.jp.tradereporting.vo.InstructionVO;

public interface ReportingService {
	
	public final String REPORT_DELIMTER_LINE = "----------------------------------------------------";

	public void showIncomingUSDAmountSettled(List<InstructionVO> instructionList);

	public void showOutgoingUSDAmountSettled(List<InstructionVO> instructionList);

	public void showBusinessGeneratingEntiesByRank(List<InstructionVO> instructionList);

}
