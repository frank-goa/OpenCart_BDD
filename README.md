# OpenCart BDD Project - Cucumber, JUnit5


### Folder Structure




```shell


automation-testing-cucumber/                     ← 📁 Project root
│
├── 📁 src/
│   ├── 📁 main/
│   │   └── 📁 java/
│   │       └── 📦 utilities/                   ← ConfigReader, DriverFactory, ExtentReportManager, ScreenshotUtil
│   │
│   └── 📁 test/
│       ├── 📁 java/
│       │   ├── 📦 stepdefinitions/             ← Cucumber step definitions
│       │   ├── 📦 testrunners/                 ← Cucumber test runner classes
│       │   ├── 📦 pageobjects/                 ← Page Object Model classes
│       │   ├── 📦 hooks/                       ← Setup/teardown hooks (e.g., for Extent and WebDriver)
│       │   └── 📦 tests/                       ← (Optional) for test suite classes or tags
│       │
│       └── 📁 resources/
│           ├── 📁 features/                    ← Gherkin `.feature` files
│           │   └── login.feature
│           │
│           ├── 📁 config/
│           │   └── config.properties          ← Environment and browser config
│           │
│           ├── 📁 testdata/
│           │   ├── loginData.xlsx
│           │   └── userProfiles.json
│           │
│           ├── 📁 extent-config/
│           │   └── extent-config.xml          ← Extent report theme/config
│           │
│           └── 📁 log4j2.xml                   ← Logging configuration
│
├── 📁 drivers/                                 ← WebDriver binaries (if needed)
│
├── 📁 reports/                                 ← Reports folder
│   └── 📁 extent/                              ← Extent HTML reports and screenshots
│       ├── ExtentReport.html
│       └── 📁 screenshots/
│           ├── login_pass.png
│           └── login_fail.png
│
├── 📁 logs/                                    ← Runtime log files (e.g., `test.log`)
│
├── 📁 target/                                  ← Maven-generated build artifacts
│
├── pom.xml                                     ← Maven build file with dependencies
│
└── README.md                                   ← Project setup and instructions
```