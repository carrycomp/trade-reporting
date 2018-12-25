package com.jp.tradereporting.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.jp.tradereporting.config.PropertiesReader;
import com.jp.tradereporting.constants.TransactionType;
import com.jp.tradereporting.exception.ApplicationException;
import com.jp.tradereporting.logger.Logger;
import com.jp.tradereporting.service.InstructionService;
import com.jp.tradereporting.util.DateUtil;
import com.jp.tradereporting.vo.CurrencyVO;
import com.jp.tradereporting.vo.EntityVO;
import com.jp.tradereporting.vo.InstructionVO;

public class InstructionServiceImpl implements InstructionService {

	@Override
	public List<InstructionVO> loadInstructions(File instructionFile) {
		List<InstructionVO> instructionList = new ArrayList<>();
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(instructionFile));) {
			instructionList = in.lines().map(line -> {
				InstructionVO instruction = new InstructionVO();
				String[] arr = pattern.split(line);
				EntityVO entity = new EntityVO(arr[0]);
				instruction.setEntity(entity);
				instruction.setTransactionType(TransactionType.valueOf(arr[1]));
				instruction.setFxRate(Float.parseFloat(arr[2]));
				CurrencyVO currency = new CurrencyVO(arr[3]);
				instruction.setCurrency(currency);
				instruction.setInstructionDate(DateUtil.parseDate(arr[4]));
				instruction.setSettlementDate(DateUtil.parseDate(arr[5]));
				instruction.setUnits(Long.parseLong(arr[6]));
				instruction.setPrice(Float.parseFloat(arr[7]));
				return instruction;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			Logger.logException("InstructionParser", "Problem while loading instruction file", e);
			throw new ApplicationException(e);
		}

		PropertiesReader propertiesReader = PropertiesReader.getInstance();
		String nonStandardCurrency = propertiesReader.getProperty("non-standard.settlement.currency");

		instructionList.forEach(instruction -> {
			if (nonStandardCurrency.indexOf(instruction.getCurrency().getCurrencyCode()) >= 0) {
				instruction.setActualSettlementDate(DateUtil.getNextWorkingDate(instruction.getSettlementDate()));
			} else {
				instruction.setActualSettlementDate(instruction.getSettlementDate());
			}
		});
		return instructionList;
	}

}
