package com.ReportUtils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager  {

    private static ExtentReports extent;

    public static ExtentReports createInstance(String reportName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\dhivy\\eclipse-workspace\\PlaywriteAutomation\\target\\Report" + reportName + ".html");
        reporter.config().setDocumentTitle("Automation Test Report");
        reporter.config().setReportName("Playwright UI Test Execution");
        reporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sathish");
        extent.setSystemInfo("Environment", "QA");
        return extent;
    }
}
