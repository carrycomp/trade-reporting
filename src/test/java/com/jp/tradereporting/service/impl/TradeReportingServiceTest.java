package com.jp.tradereporting.service.impl;

import java.io.File;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeReportingServiceTest {

	@InjectMocks
	private TradeReportingServiceImpl service;

	@Mock
	private InstructionServiceImpl instructionService;
	
	@Mock
	private ReportingServiceImpl reportingService;
	
	@Mock
	private CacheServiceImpl cacheService;
	
	@Mock
	private File inputFile;
	
	@Before
	public void runBeforeTestMethod() {
		
	}

	@Test
	public void testLoadInstructionFile() {
		service.loadInstructionFile(inputFile);
		verify(instructionService).loadInstructions(inputFile);
	}

	@Test
	public void testGenerateReport() {
		service.reportTrades();
		verify(reportingService).showBusinessGeneratingEntiesByRank(cacheService.getInstructions());
		verify(reportingService).showIncomingUSDAmountSettled(cacheService.getInstructions());
		verify(reportingService).showOutgoingUSDAmountSettled(cacheService.getInstructions());
	}

}
