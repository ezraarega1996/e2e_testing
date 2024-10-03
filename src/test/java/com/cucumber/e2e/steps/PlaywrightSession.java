package com.cucumber.e2e.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.stereotype.Component;

@Component
public class PlaywrightSession {
        private final Browser browser;
        private final Page page;

        public PlaywrightSession() {
            // Initialize Playwright and create a browser instance
            Playwright playwright = Playwright.create();
            browser = playwright.chromium().launch();
            page = browser.newPage();
        }

        public Page getPage() {
            return page;
        }

        public void close() {
            // Close the browser instance
            browser.close();
        }
    }
