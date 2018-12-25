package com.jp.tradereporting;

import java.io.File;

import com.jp.tradereporting.config.PropertiesReader;
import com.jp.tradereporting.logger.Logger;
import com.jp.tradereporting.service.ReportingService;
import com.jp.tradereporting.service.impl.TradeReportingServiceImpl;

public class MainClass {

	public static void main(String args[]) {
		PropertiesReader propertiesReader = PropertiesReader.getInstance();

		TradeReportingServiceImpl tradeReportingImpl = TradeReportingServiceImpl.getInstance();
		tradeReportingImpl.loadInstructionFile(new File(propertiesReader.getProperty("instruction.filepath")));
		Logger.logMessage(ReportingService.REPORT_DELIMTER_LINE);
		tradeReportingImpl.reportTrades();
	}

}
