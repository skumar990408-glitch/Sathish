package com.utils;

import com.microsoft.playwright.Playwright;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaywrightSetup {

    // Run this before tests to ensure Playwright & browsers are ready
    public static void ensurePlaywrightSetup() {
        System.out.println("🔍 Checking Playwright setup...");

        try {
            // Check if browsers are already installed
            if (!areBrowsersInstalled()) {
                System.out.println("⚙️  Playwright browsers not found. Installing...");
                installPlaywrightBrowsers();
            } else {
                System.out.println("✅ Playwright browsers already installed.");
            }
        } catch (Exception e) {
            System.err.println("❌ Error during Playwright setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Verify if Playwright browsers are installed by launching a minimal instance
    private static boolean areBrowsersInstalled() {
        try (Playwright playwright = Playwright.create()) {
            playwright.chromium().launch(); // Try to launch a browser
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Automatically installs browsers using Playwright CLI
    private static void installPlaywrightBrowsers() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args=install");
        builder.redirectErrorStream(true);
        Process process = builder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("✅ Playwright browsers installed successfully.");
        } else {
            System.err.println("❌ Failed to install Playwright browsers. Exit code: " + exitCode);
        }
    }
}
