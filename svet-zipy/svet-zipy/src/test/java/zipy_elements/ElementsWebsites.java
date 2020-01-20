package zipy_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsWebsites {
	
// Websites:
public static final String Zipy_il = "https://www.zipy.co.il/?utm_medium=email";				//Israel
public static final String Zipy_ilRu = "https://ru.zipy.co.il/?utm_medium=email";			//Israel russian
public static final String Zipy_gr = "https://www.zipy.gr/?utm_medium=email";				//Greece
public static final String Zipy_gr_ebay = "https://www.zipy.gr/ebay/?utm_medium=email";
public static final String Zipy_gr_amazon = "https://www.zipy.gr/amazon/?utm_medium=email";
public static final String Zipy_cy = "https://www.zipy.com.cy/?utm_medium=email";			//Cypress
public static final String Zipy_cy_ebay = "https://www.zipy.com.cy/ebay/?utm_medium=email";		
public static final String Zipy_cy_amazon = "https://www.zipy.com.cy/amazon/?utm_medium=email";		
public static final String Zipy_ro = "https://www.zipy.ro/?utm_medium=email";				//Romania
public static final String Zipy_ro_ebay = "https://www.zipy.ro/ebay/?utm_medium=email";
public static final String Zipy_ro_amazon = "https://www.zipy.ro/amazon/?utm_medium=email";
public static final String Zipy_it = "https://www.zipy.it/?utm_medium=email";				//Italy
public static final String Zipy_it_ebay = "https://www.zipy.it/ebay/?utm_medium=email";
public static final String Zipy_it_amazon = "https://www.zipy.it/amazon/?utm_medium=email";
public static final String Zipy_py = "https://www.zipy.pt/?utm_medium=email";				//Portugal
public static final String Zipy_py_ebay = "https://www.zipy.pt/ebay/?utm_medium=email";
public static final String Zipy_py_amazon = "https://www.zipy.pt/amazon/?utm_medium=email";

public static final String Zipy_test = "https://zipy:zipy@www.test.zipy.co.il/?utm_medium=email";		//Test 
public static final String Zipy_dev = "https://zipy:zipy@www.dev.zipy.co.il/?utm_medium=email";		//Developers

//TEST Websites:
public static final String TestZipy_il = "https://zipy:zipy@www.test.zipy.co.il/?utm_medium=email";				//Test Israel
public static final String TestZipy_ilRu = "https://zipy:zipy@ru.zipy.co.il/?utm_medium=email";				//Test Israel russian
public static final String TestZipy_gr = "https://zipy:zipy@www.test.zipy.gr/?utm_medium=email";					//Test Greece
public static final String TestZipy_gr_ebay = "https://zipy:zipy@www.test.zipy.gr/ebay/?utm_medium=email";
public static final String TestZipy_gr_amazon = "https://zipy:zipy@www.test.zipy.gr/amazon/?utm_medium=email";
public static final String TestZipy_cy = "https://zipy:zipy@www.test.zipy.com.cy/?utm_medium=email";				//Test Cypress
public static final String TestZipy_cy_ebay = "https://zipy:zipy@www.test.zipy.com.cy/ebay/?utm_medium=email";		
public static final String TestZipy_cy_amazon = "https://zipy:zipy@www.test.zipy.com.cy/amazon/?utm_medium=email";		
public static final String TestZipy_ro = "https://zipy:zipy@www.test.zipy.ro/?utm_medium=email";					//Test Romania
public static final String TestZipy_ro_ebay = "https://zipy:zipy@www.test.zipy.ro/ebay/?utm_medium=email";
public static final String TestZipy_ro_amazon = "https://zipy:zipy@www.test.zipy.ro/amazon/?utm_medium=email";
public static final String TestZipy_it = "https://zipy:zipy@www.test.zipy.it/?utm_medium=email";					//Test Italy
public static final String TestZipy_it_ebay = "https://zipy:zipy@www.test.zipy.it/ebay/?utm_medium=email";
public static final String TestZipy_it_amazon = "https://zipy:zipy@www.test.zipy.it/amazon/?utm_medium=email";
public static final String TestZipy_py = "https://zipy:zipy@www.test.zipy.pt/?utm_medium=email";					//Test Portugal
public static final String TestZipy_py_ebay = "https://zipy:zipy@www.test.zipy.pt/ebay/?utm_medium=email";
public static final String TestZipy_py_amazon = "https://zipy:zipy@www.test.zipy.pt/amazon/?utm_medium=email";


//DEV Websites:
public static final String DevZipy_il = "https://zipy:zipy@www.dev.zipy.co.il/?utm_medium=email";				//Dev Israel
public static final String DevZipy_ilRu = "https://zipy:zipy@ru.zipy.co.il/?utm_medium=email";					//Dev Israel russian
public static final String DevZipy_gr = "https://zipy:zipy@www.dev.zipy.gr/?utm_medium=email";					//Dev Greece
public static final String DevZipy_gr_ebay = "https://zipy:zipy@www.dev.zipy.gr/ebay/?utm_medium=email";
public static final String DevZipy_gr_amazon = "https://zipy:zipy@www.dev.zipy.gr/amazon/?utm_medium=email";
public static final String DevZipy_cy = "https://zipy:zipy@www.dev.zipy.com.cy/?utm_medium=email";				//Dev Cypress
public static final String DevZipy_cy_ebay = "https://zipy:zipy@www.dev.zipy.com.cy/ebay/?utm_medium=email";		
public static final String DevZipy_cy_amazon = "https://zipy:zipy@www.dev.zipy.com.cy/amazon/?utm_medium=email";		
public static final String DevZipy_ro = "https://zipy:zipy@www.dev.zipy.ro/?utm_medium=email";					//Dev Romania
public static final String DevZipy_ro_ebay = "https://zipy:zipy@www.dev.zipy.ro/ebay/?utm_medium=email";
public static final String DevZipy_ro_amazon = "https://zipy:zipy@www.dev.zipy.ro/amazon/?utm_medium=email";
public static final String DevZipy_it = "https://zipy:zipy@www.dev.zipy.it/?utm_medium=email";					//Dev Italy
public static final String DevZipy_it_ebay = "https://zipy:zipy@www.dev.zipy.it/ebay/?utm_medium=email";
public static final String DevZipy_it_amazon = "https://zipy:zipy@www.dev.zipy.it/amazon/?utm_medium=email";
public static final String DevZipy_py = "https://zipy:zipy@www.dev.zipy.pt/?utm_medium=email";					//Dev Portugal
public static final String DevZipy_py_ebay = "https://zipy:zipy@www.dev.zipy.pt/ebay/?utm_medium=email";
public static final String DevZipy_py_amazon = "https://zipy:zipy@www.dev.zipy.pt/amazon/?utm_medium=email";


//deals:
public static final String Zipy_il_deals = "https://www.zipy.co.il/deals/?utm_medium=email";
public static final String Zipy_il_lessThan5 = "https://www.zipy.co.il/fiveshekel/?utm_medium=email";

public static final String TestZipy_il_deals = "https://zipy:zipy@www.test.zipy.co.il/deals/?utm_medium=email";
public static final String TestZipy_il_lessThan5 = "https://zipy:zipy@www.test.zipy.co.il/fiveshekel/?utm_medium=email";
public static final String DevZipy_il_deals = "https://zipy:zipy@www.dev.zipy.co.il/deals/?utm_medium=email";
public static final String DevZipy_il_lessThan5 = "https://zipy:zipy@www.dev.zipy.co.il/fiveshekel/?utm_medium=email";


}
