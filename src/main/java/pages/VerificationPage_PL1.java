package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerificationPage_PL1 extends StartupPage {

	public VerificationPage_PL1(WebDriver driver) {
		super(driver);
	}

	// Write all the required locators here.
	private By emailInput = By.cssSelector("input#username_id");
	private By passwordInput = By.cssSelector("#password");
	private By signInButton = By.cssSelector("#login");

	public By a() {
		return By.xpath("//a[@href='#/Verification']");
	}

	public By b(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}

	public By c(String buttonName) {
		return By.xpath("//button[contains(text(),'" + buttonName + "')]");
	}

	public By d() {
		return By.id("quickFilterInput");
	}

	public By e() {
		return By.cssSelector("td [data-hover='dropdown']");
	}

	public By f() {
		return By.xpath("(//input[@id='date'])[1]");
	}

	public By g() {
		return By.xpath("(//input[@id='date'])[2]");
	}

	public By h() {
		return By.xpath("//i[contains(@class,'icon-favourite')]/..");
	}

	public By i(String subNavName) {
		return By.xpath("//div[@class=\"sub-navtab\"]/ul/li/a[text()='" + subNavName + "']");
	}

	public By j() {
		return By.xpath("//button[@class='btn green btn-success']");
	}

	public By k(String radioButtonName) {
		return By.xpath("//input[@value='" + radioButtonName + "']/../span");
	}

	public By l() {
		return By.xpath("//div[@col-id=\"RequisitionDate\"]/span[not(contains(@class,'hidden'))]");
	}

	public By m() {
		return By.xpath("//i[contains(@class,'icon-favourite')]");
	}

	/**
	 * About this method login()
	 *
	 * @param : null
	 * @description : This method performs the login action by entering the email,
	 *              password, and clicking the sign-in button.
	 * @return : void
	 * @throws : Exception - if there is an issue interacting with the email input,
	 *           password input, or sign-in button.
	 */

	public boolean login() {
		driver.findElement(emailInput).sendKeys("admin");
		driver.findElement(passwordInput).sendKeys("pass123");
		driver.findElement(signInButton).click();
		return true; // or any success condition
	}

	/**
	 * @Test1.1 @Test2.1 @Test3.1 @Test4.1 @Test5.1 @Test6.1 @Test7.1 @Test8.1 @Test9.1 @Test10.1
	 * about this method openVerificationMenu() *
	 * 
	 * @param : null
	 * @description : This method scrolls to the verification menu using JavaScript
	 *              and clicks on it.
	 * @return : void
	 * @throws InterruptedException
	 * @throws :                    Exception - if there is an issue locating,
	 *                              scrolling to, or clicking the verification menu.
	 */

	public boolean openVerificationMenu() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement verificationTab = driver.findElement(a());
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", verificationTab);
		verificationTab.click();
		return true; // success
	}

	/**
	 * @Test1.2 @Test2.2 @Test3.2 @Test4.2 @Test4.4 @Test5.2 @Test8.2 @Test9.2 @Test10.2
	 * about this method successfullNavigation(String module)
	 *
	 * @param : module - The expected substring to verify in the current URL.
	 * @description : This method verifies that the current URL contains the
	 *              specified module substring after navigation and logs the result.
	 * @return : void
	 * @throws : InterruptedException - if the thread sleep is interrupted.
	 *           AssertionError - if the expected substring is not found in the URL.
	 */

	public boolean successfullNavigation(String module) throws InterruptedException {
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();

		if (currentURL.contains(module)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Test2.3 @Test2.4 @Test3.3 @Test3.4 about this method
	 * verifyButtonPresentWithText(String text)
	 *
	 * @param : text - The text of the button to verify its presence.
	 * @description : This method checks if a button with the specified text is
	 *              displayed on the page and fails the test if the button is not
	 *              visible.
	 * @return : void
	 * @throws : AssertionError - if the button with the specified text is not
	 *           visible.
	 */

	public boolean verifyButtonPresentWithText(String text) {
		WebElement element = driver.findElement(b(text));
		return element.isDisplayed();
	}

	/**
	 * @Test3.5 @Test4.3 @Test5.3 @Test8.6 @Test8.7about this method
	 * clickOnButtonByText(String text)
	 *
	 * @param : text - The text of the button to be clicked.
	 * @description : This method locates a button with the specified text and
	 *              performs a click action on it.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the button.
	 */

	public boolean clickOnButtonByText(String text) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(b(text)).click();
		return true;
	}

	/**
	 * @Test3.6 about this method verifyVerificationComponentsAreVisible()
	 *
	 * @param : null
	 * @description : This method verifies the visibility of multiple verification
	 *              components such as navigation buttons, date range fields, and
	 *              sub-navigation tabs, and highlights each component during the
	 *              check.
	 * @return : boolean - Returns true if all components are visible, otherwise
	 *         false.
	 * @throws : Exception - if any component is not visible or an error occurs
	 *           during the verification process.
	 */

	public boolean verifyVerificationComponentsAreVisible() throws InterruptedException {
		Thread.sleep(5000);

		List<WebElement> options = Arrays.asList(driver.findElement(c("First")), driver.findElement(c("Previous")),
				driver.findElement(c("Next")), driver.findElement(c("Last")), driver.findElement(d()),
				driver.findElement(e()), driver.findElement(f()), driver.findElement(g()), driver.findElement(h()),
				driver.findElement(i("Requisition")), driver.findElement(i("Purchase Request")),
				driver.findElement(i("Purchase Order")), driver.findElement(i("GR Quality Inspection")));

		for (WebElement option : options) {
			if (!option.isDisplayed())
				return false;
		}
		return true;
	}

	/**
	 * @Test6.2 @Test8.3 about this method chooseDate(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in the format "DD-MM-YYYY". toDate - The
	 *          end date in the format "DD-MM-YYYY".
	 * @description : This method sets the "from" and "to" dates by locating and
	 *              interacting with date dropdowns.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or interacting with the
	 *           date dropdowns or buttons.
	 */

	public boolean chooseDate(String fromDate, String toDate) {
		String[] f = fromDate.split("-");
		String[] t = toDate.split("-");

		driver.findElement(f()).sendKeys(f[0], f[1], f[2]);
		driver.findElement(g()).sendKeys(t[0], t[1], t[2]);
		driver.findElement(j()).click();

		return true;
	}

	/**
	 * @Test6.3 @Test10.3 @Test10.4 @Test10.5 @Test10.6 @Test10.7 @Test10.8 @Test10.9 @Test10.10 @Test10.11
	 * about this method selectRadioButton(String radioButtonText)
	 *
	 * @param : radioButtonText - The text associated with the radio button to be
	 *          selected.
	 * @description : This method locates and clicks on a radio button based on the
	 *              provided text.
	 * @return : boolean - Returns true if the radio button is successfully clicked.
	 * @throws : Exception - if there is an issue locating or clicking the radio
	 *           button.
	 */

	public boolean selectRadioButton(String radioButtonText) {
		driver.findElement(k(radioButtonText)).click();
		return true;
	}

	/**
	 * @Test6.4 @Test8.5 @Test9.4 about this method clickOkButton()
	 *
	 * @param : null
	 * @description : This method locates and clicks the "OK" button.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the "OK"
	 *           button.
	 */

	public boolean clickOkButton() {
		driver.findElement(j()).click();
		return true;
	}

	/**
	 * @Test6.5 @Test9.5 about this method verifyDateRange(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in "dd-MM-yyyy" format. toDate - The end
	 *          date in "dd-MM-yyyy" format.
	 * @description : This method verifies that all dates after applying the filter
	 *              are within the specified date range.
	 * @return : void
	 * @throws : AssertionError - if any date is outside the specified date range or
	 *           fails to parse.
	 */

	public boolean verifyDateRange(String fromDate, String toDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		List<WebElement> actualDatesAfterFilterApplied = driver.findElements(l());
		LocalDate from = LocalDate.parse(fromDate, formatter);
		LocalDate to = LocalDate.parse(toDate, formatter);

		for (WebElement dateElement : actualDatesAfterFilterApplied) {
			String dateText = dateElement.getText();
			LocalDate date = LocalDate.parse(dateText, inputFormatter);
			LocalDate newDate = LocalDate.parse(date.format(formatter), formatter);

			if (newDate.isBefore(from) || newDate.isAfter(to)) {
				Assert.fail("Date is out of range: " + dateText);
				return false;
			}
		}

		return true;
	}

	/**
	 * @Test7.2 about this method verifyToolTipText()
	 *
	 * @param : null
	 * @description : This method retrieves and returns the tooltip text (title
	 *              attribute) of the star icon.
	 * @return : String - Returns the tooltip text of the star icon.
	 * @throws : Exception - if there is an issue locating the tooltip or retrieving
	 *           its text.
	 */

	public String verifyToolTipText() {
		WebElement toolTip = driver.findElement(m());
		String toolTipValue = commonEvents.highlight(toolTip).getAttribute(toolTip, "title");
		System.out.println("Tool tip title : " + toolTipValue);
		return toolTipValue;
	}

	/**
	 * @Test8.4 about this method clickTooltip()
	 *
	 * @param : null
	 * @description : This method locates and clicks the tooltip element, which is
	 *              identified by the star icon.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the tooltip
	 *           element.
	 */

	public boolean clickTooltip() {
		WebElement toolTip = driver.findElement(h());
		toolTip.click();
		return true;
	}

	/**
	 * @Test8.8 about this method verifyDateRangeforReq(String fromDate, String
	 * toDate)
	 *
	 * @param : fromDate - The start date in "DD-MM-YYYY" format. toDate - The end
	 *          date in "DD-MM-YYYY" format.
	 * @description : This method verifies if the actual date range matches the
	 *              provided from and to dates.
	 * @return : void
	 * @throws : AssertionError - if the actual date range does not match the
	 *           expected range.
	 */

	public boolean verifyDateRangeforReq(String fromDate, String toDate) {
		String actualFromDate = String.join("-", fromDate.split("-"));
		String actualToDate = String.join("-", toDate.split("-"));

		if (actualFromDate.equals(fromDate) && actualToDate.equals(toDate)) {
			return true;
		}

		Assert.fail("Date is out of range: Expected from " + fromDate + " to " + toDate + ", but got from "
				+ actualFromDate + " to " + actualToDate);
		return false;
	}

	/**
	 * @Test9.3 about this method chooseDateRange(String range)
	 *
	 * @param : range - The text of the date range option to be selected.
	 * @description : This method clicks on the date range button, selects a
	 *              specified range, and then closes the dropdown.
	 * @return : void
	 * @throws : Exception - if there is an issue locating or clicking the date
	 *           range elements.
	 */

	public boolean chooseDateRange(String range) {
		WebElement dateRangeButton = driver.findElement(f());
		dateRangeButton.click();

		WebElement valueToSelectElement = driver.findElement(b(range));
		valueToSelectElement.click();

		dateRangeButton.click();
		valueToSelectElement.click();

		return true;
	}

}
