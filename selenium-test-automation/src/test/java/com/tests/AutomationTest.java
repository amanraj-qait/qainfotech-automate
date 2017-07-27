package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.script.ExecuteAutomation;
import com.connections.PropertyFileReader;

public class AutomationTest {
	ExecuteAutomation automate;
	PropertyFileReader reader;

	/**
	 * Initialise objects
	 * 
	 * @throws Exception
	 */
	@BeforeTest
	public void initiate_Automation() throws Exception {
		automate = new ExecuteAutomation();
		reader = new PropertyFileReader();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void test_carrer_tab() throws Exception {
		Assert.assertEquals(reader.read_property("result_url1"), automate.click_on_careers_tab());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void test_check_dropdownmenu() throws Exception {
		Assert.assertTrue(automate.hover_mouse_button_on_tab());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void test_click_team_tab() throws Exception {
		Assert.assertTrue(automate.display_nonvisible_data());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4)
	public void test_page_opened() throws Exception {
		Assert.assertEquals(reader.read_property("result_url2"), automate.navigate_to_content_page());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5)
	public void test_search_result() throws Exception {
		Assert.assertEquals(reader.read_property("result_url3"), automate.search_word());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6)
	public void test_check_lack_of_dropdownmenu() throws Exception {
		Assert.assertTrue(automate.check_for_absent_dropdown_menu());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(priority = 7)
	public void test_link_to_new_tab() throws Exception {
		Assert.assertEquals(reader.read_property("result_url4"), automate.open_new_window_on_click());
	}

	/**
	 * end test
	 */
	@AfterTest
	public void finish_test() {
		automate.end_automation();
	}
}
