package com.jp.tradereporting.service;

import java.io.File;

public interface TradeReportingService {
	
	public void loadInstructionFile(File inputFile);
	
	public void reportTrades();
}
