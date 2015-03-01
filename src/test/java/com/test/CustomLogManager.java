package com.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogManager extends LogManager {
	// private static Logger LOGGER = LogManager.getLogger();
	// private static final Logger LOGGER = CustomStatusLogger.getLogger();
	private static Logger logger = null;

	private CustomLogManager() {
		// logger = new CustomLogger();
	}

	public static Logger create(Class cl) {
		if (logger == null)
			logger = new CustomLogManager().getLogger(cl);
		return logger;
	}

	final Level STEP = Level.forName("STEP", 10);

	public void step(String logMsg) {
		logger.log(STEP, logMsg);
	}

}
