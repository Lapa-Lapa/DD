# DD

SUT-TUT.BY
Used:Java8,Selenium WebDriver,Junit,Cucumber,Log4j,Appium
Patterns:Singletone,PO,Static Factory Method

In this Test Automation Framework were used next Design Patterns:

1. Singleton Design Pattern -

2. PO -

3.Static Factory Method Design Pattern -

Use: -Dbrowser=chrome/etc. - for running

My Pain:

org.junit annotations not work when you @RunWith(Cucumber.class)
so be careful with imports and use only cucumber.api.java annotations!

glue = {"glue_visibility"} - without this Cucumber Option non of step definition will be found
and non @annotation will be executed out of folder "glue_visibility"

https://seleniumjava.com/2015/12/12/how-to-make-selenium-webdriver-scripts-faster/-How?
The browser  instance can be shared by all test scripts if we use different annotations:
@BeforeClass instead of @Before for the setUp() method
@AfterClass instead of @After for the tearDown() method

Appium is an open source automation tool for running scripts and testing native applications,
mobile-web applications and hybrid applications on Android or iOS using a webdriver.