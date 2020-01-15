package zipy_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsRecommended {
	
	//buying - Elements 
	// populars(6 elements):
	public static final String populars = "//div[@id='wrapper']/section[*]/div[2]/a[";
	//public static final String populars_6 =	"//div[@id='wrapper']/section[*]/div[2]/a[6]";*/
	
	// dailyDeal(8 elements):
	public static final String dailyDeal = "/html/body/div[1]/div[*]/div/section/div/main/section/div[2]/div/div/div[1]/div/div[";
	//public static final String dailyDeal_8 = "/html/body/div[1]/div[*]/div/section/div/main/section/div[2]/div/div/div[1]/div/div[8]";

	
	// dailyDeal_tst(32 elements):
	public static final String dailyDeal_tst = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[";
//	public static final String dailyDeal_tst_32 = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[32]";


	public static final String dailyDeal_title = "//*[@id=\"wrapper\"]/div[4]/div[1]/a[";
	public static final String populars_title = "//div[@id='wrapper']/section[@class='popularLinksBar']//span[@class='popularLinksBar__title_text']";

	
	public static final String dailyDeal_onPage = "//div[@id='wrapper']//main[@role='main']/section[@class='daily m--plates']/div[@class='daily__slide']/div[1]/a[@href='https://www.zipy.co.il/p/upsale/----/pandy/']";
}
