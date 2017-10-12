package com.github.siiilas.testcodeanalyzer.log;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.github.siiilas.testcodeanalyzer.exception.ServiceException;

public class Logger {

    private static final String LOGGER_PREFIX = "[Test Code Analyser] ";

    private Logger() {
    }

    public static void log(String message) {
        System.out.println(LOGGER_PREFIX + message);
    }

    public static void error(String message, Exception e) {
        System.out.println(LOGGER_PREFIX + message + ": " + ExceptionUtils.getStackTrace(e));
    }

    public static void error(String message, ServiceException e) {
        System.out.println(LOGGER_PREFIX + e.getMessage());
    }

}
