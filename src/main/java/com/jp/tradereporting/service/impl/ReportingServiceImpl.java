package com.jp.tradereporting.service.impl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jp.tradereporting.constants.TransactionType;
import com.jp.tradereporting.logger.Logger;
import com.jp.tradereporting.service.ReportingService;
import com.jp.tradereporting.vo.EntityVO;
import com.jp.tradereporting.vo.InstructionVO;

public class ReportingServiceImpl implements ReportingService {

	@Override
	public void showIncomingUSDAmountSettled(List<InstructionVO> instructionList) {
		Logger.logMessage("Amount in USD settled incoming everyday ");
		// incoming USD / Sell
		Map<LocalDate, Double> incomingUSDReport = instructionList.stream()
				.filter(instruction -> (TransactionType.S.getCode().equals(instruction.getTransactionType().getCode())))
				.collect(Collectors.groupingBy(InstructionVO::getActualSettlementDate,
						Collectors.summingDouble(InstructionVO::getUSDValue)));
		incomingUSDReport.forEach((key, value) -> {
			Logger.logMessage("SettlementDate : " + key + " Amount : " + value);
		});
	}

	@Override
	public void showOutgoingUSDAmountSettled(List<InstructionVO> instructionList) {
		Logger.logMessage("Amount in USD settled outgoing everyday ");
		// outgoing USD / Buy
		Map<LocalDate, Double> outgoingUSDReport = instructionList.stream()
				.filter(instruction -> (TransactionType.B.getCode().equals(instruction.getTransactionType().getCode())))
				.collect(Collectors.groupingBy(InstructionVO::getActualSettlementDate,
						Collectors.summingDouble(InstructionVO::getUSDValue)));
		outgoingUSDReport.forEach((key, value) -> {
			Logger.logMessage("SettlementDate : " + key + " Amount : " + value);
		});
	}

	@Override
	public void showBusinessGeneratingEntiesByRank(List<InstructionVO> instructionList) {
		List<EntityVO> sortedEntityWiseReport = instructionList.stream()
				.collect(Collectors.groupingBy(InstructionVO::getEntity,
						Collectors.summingDouble(InstructionVO::getUSDValue)))
				.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(Map.Entry::getKey).collect(Collectors.toList());
		Logger.logMessage("Ranking of entities based on incoming and outgoing amount (descending order)");
		sortedEntityWiseReport.forEach(entity -> Logger.logMessage(entity.toString()));
	}

}
