package zipy_elements;

public class ElementsRecommended {
	
	//buying - Elements 
	// populars(6 elements):
	public static final String populars = "//div[@id='wrapper']/section[*]/div[2]/a[";
	//public static final String populars_6 =	"//div[@id='wrapper']/section[*]/div[2]/a[6]";*/
	
	// dailyDeal(8 elements):
	public static final String dailyDeal = "/html/body/div[1]/div[*]/div/section/div/main/section/div[2]/div/div/div[1]/div/div[";
	public static final String dailyDeal_3 = "/html/body/div[1]/div[*]/div/section/div/main/section/div[2]/div/div/div[1]/div/div[3]";

	public static final String dailyDeal_dev_3 = "//*[@id=\"wrapper\"]/div[*]/div[1]/a[3]";
	
	// dailyDeal_tst(32 elements):
	public static final String dailyDeal_tst = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[";
	public static final String dailyDeal_tst_3 = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[3]";

	public static final String dailyDeal_title = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[";
	public static final String populars_title = "//div[@id='wrapper']/section[@class='popularLinksBar']//span[@class='popularLinksBar__title_text']";

	public static final String dailyDeal_onPage_3 = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]";
	public static final String dailyDeal_onPage_3_title = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/a";
	
	public static final String Product_PinThumbIcon = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin']";
	public static final String Product_PinThumbIcon_Selected = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin m--active']";
	public static final String Product_PinThumbIcon_colorUnselected = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin']/span";
	public static final String Product_PinThumbIcon_colorSelected = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin m--active']/span";

	
	// search
	public static final String search_3 = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]";
	public static final String search_3_title = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/a";
	public static final String Product_search_3_PinThumbIcon = "//*[@id=\"wrapper\"]/div[*]/main/section[2]/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin']";

	// less-than-5 tab
	public static final String lessThan5_3 = "//*[@id=\"wrapper\"]/div[2]/main/section[2]/div[2]/div[3]";
	public static final String lessThan5_3_title = "//*[@id='wrapper']/div[2]/main/section[2]/div[2]/div[3]/a";
	public static final String lessThan5_3_PinThumbIcon = "//*[@id=\"wrapper\"]/div[2]/main/section[2]/div[2]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin']";

	//side categories
	public static final String category_3 = "//div[@id='wrapper']//main[@role='main']/section/div[3]/div[3]";
	public static final String category_3_title = "//div[@id='wrapper']//main[@role='main']/section/div[3]/div[3]/a";
	public static final String category_3_PinThumbIcon = "//div[@id='wrapper']//main[@role='main']/section/div[3]/div[3]/div/div[@class='daily__item-info']/button[@class='daily__item-pin']";
	public static final String category_linksStart = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[";
	// + num + "]/div//*[@href]
	public static final String category_mainCategoryStart = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[";
	//  + num + "]/a/span[2]"
	
	
}
