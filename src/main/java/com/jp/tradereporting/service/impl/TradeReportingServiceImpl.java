package com.jp.tradereporting.service.impl;

import java.io.File;

import com.jp.tradereporting.logger.Logger;
import com.jp.tradereporting.service.ReportingService;
import com.jp.tradereporting.service.TradeReportingService;

public class TradeReportingServiceImpl implements TradeReportingService {

	private static TradeReportingServiceImpl instance = new TradeReportingServiceImpl();
	
	private InstructionServiceImpl instructionService;
	private CacheServiceImpl cacheService;
	private ReportingServiceImpl reportingService;
	
	private TradeReportingServiceImpl(){
		this.instructionService = new InstructionServiceImpl();
		this.cacheService = new CacheServiceImpl();
		this.reportingService = new ReportingServiceImpl();
	}

	public static TradeReportingServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public void loadInstructionFile(File inputFile) {
		cacheService.persist(instructionService.loadInstructions(inputFile));		
	}

	@Override
	public void reportTrades() {
		reportingService.showIncomingUSDAmountSettled(cacheService.getInstructions());
		Logger.logMessage(ReportingService.REPORT_DELIMTER_LINE);
		reportingService.showOutgoingUSDAmountSettled(cacheService.getInstructions());
		Logger.logMessage(ReportingService.REPORT_DELIMTER_LINE);
		reportingService.showBusinessGeneratingEntiesByRank(cacheService.getInstructions());
		Logger.logMessage(ReportingService.REPORT_DELIMTER_LINE);
	}

}
