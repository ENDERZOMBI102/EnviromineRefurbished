package com.enderzombi102.emr.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
	private static final Logger logger = LogManager.getLogger("EnviromineRefurbished");

	public static Logger getlogger() {
		return logger;
	}

	// only text
	public static void debug(Object txt) {
		logger.debug(txt);
	}

	public static void info (Object txt) {
		logger.info(txt);
	}

	public static void warn(Object txt) {
		logger.warn(txt);
	}

	public static void error(Object txt) {
		logger.error(txt);
	}

	public static void fatal(Object txt) {
		logger.fatal(txt);
	}

	// text + 1 object
	public static void debug(String txt, Object obj) {
		logger.debug(txt, obj);
	}

	public static void info (String txt, Object obj) {
		logger.info(txt, obj);
	}

	public static void warn(String txt, Object obj) {
		logger.warn(txt, obj);
	}

	public static void error(String txt, Object obj) {
		logger.error(txt, obj);
	}

	public static void fatal(String txt, Object obj) {
		logger.fatal(txt, obj);
	}

}
