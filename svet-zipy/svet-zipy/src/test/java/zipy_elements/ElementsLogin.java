package zipy_elements;

public class ElementsLogin {
	
//// start page: ////////////////////////////////////////////////////////

	public static final String Popup_welcome_close = "//button[@title='Close']";	
	public static final String Popup_welcome_close_gr = "//div[@id='tucson-body']/a[@title='Close']";	

	public static final String Popup_coockies_close = "/html/body//div[@role='dialog']//div[@class='cc-actions']/a[1]";
	public static final String ZipyLogo = "/html/body//a[@title='Zipy - Απλές αγορές']/span[1]";

	public static final String UserTopBar_close = "//span[@class='topbar__forms-close']";
	public static final String UserTopBar = "/html//div[@id='topbar']/div[@class='default']//span[@class='topbar__user-link-no-name']";

	public static final String Start_advertNote_close = "/html//button[@id='onesignal-popover-cancel-button']";

	
	
//// categories: ////////////////////////////////////////////////////////	
	
	public static final String sideCategory1 = "/html//div[@id='topbar']/div[@class='default']//span[@class='topbar-catalogue__btn_icon']";
	public static final String sideCategory1_1 = "/html/body/div[1]/div[5]/div/section/div/aside/section/div/div[2]/ul/li[1]/div/div/div[1]/div[2]/div[1]";
	public static final String sideCategoryUp1 = "/html//div[@id='topbar']/div[@class='default']//span[@class='topbar-catalogue__btn_icon']";
	public static final String sideCategoryUpi = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[";
	public static final String sideCategoryUp1_1 = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[1]/div/div/div[1]/div[2]/div[1]";
	public static final String sideCategoryUp1_i = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[1]/div/div/div[1]/div[2]/div[";
	public static final String sideCategoryUp1_i_secondRow = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[1]/div/div/div[2]/div[2]/div[";
	public static final String sideCategoryUp1_i_thirdRow = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[1]/div/div/div[3]/div[2]/div[";
	public static final String sideCategoryUp2_i = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[2]/div/div/div[1]/div[2]/div[";
	public static final String sideCategoryUp3_i = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[3]/div/div/div[1]/div[2]/div[";
	public static final String sideCategoryUp8_i = "//*[@id=\"topbar\"]/div[2]/div[1]/div/div/section/div/ul/li[8]/div/div/div[1]/div[2]/div[";
	public static final String sideCategoryi = "/html/body/div[1]/div[5]/div/section/div/aside/section/div/div[2]/ul/li[";
	///html/body/div[1]/div[5]/div/section/div/aside/section/div/div[2]/ul/li[i]
	public static final String sideCategoryi_jStart = "/html/body/div[1]/div[5]/div/section/div/aside/section/div/div[2]/ul/li[";
	public static final String sideCategoryi_jMiddle = "]/div/div/div[";
	public static final String sideCategoryi_jEnd = "]/div[2]/div[";
	///html/body/div[1]/div[5]/div/section/div/aside/section/div/div[2]/ul/li[1]/div/div/div[j]/div[2]/div[i]
	

	
//// log in: ////////////////////////////////////////////////////////
	
	public static final String Login_button = "/html//div[@id='topbar']/div[@class='default']/div[3]/div[2]/span[@class='topbar__menu-item-link']/span[@class='ico ico--login']";
	public static final String Login_button_Dev = "/html//div[@id='topbar']/div[@class='default']/div[3]/div[2]/span[@class='topbar__menu-item-link']/span[@class='topbar__menu-item-link--dotted']";
	public static final String Logedin_button = "/html//div[@id='topbar']/div[@class='default']//span[@class='topbar__user-link-no-name']";
	public static final String Login_disconnect = "/html//form[@id='profileForm']//a[@href='/user/logout']/span[@class='topbar__user-dropdown-logout-anchor']";
	public static final String Login_usernameField = "/html//input[@id='i_signin-email']";
	public static final String LoginFrame_close ="/html//div[@id='topbar']/div[@class='default']/div[4]/div[3]//span[@class='ico ico--cross']";
	public static final String Login_close ="//span[@class='topbar__forms-close']";
	public static final String Login_TempUsername = "zipi01@4tmail.com";	//zipi02@4tmail.com , zipi03@4tmail.com  from:https://temp-mail.org/en/
	public static final String Login_discounts_checkVi = "/html//form[@id='registerForm']/fieldset[@class='user-form__fields']/div[@class='field field--submit']/div[1]/label/u[@class='m--big']/span[@class='ico ico--check']";
	public static final String Login_discounts_uncheckVi = "/html//form[@id='registerForm']/fieldset[@class='user-form__fields']/div[@class='field field--submit']/div[1]/label/u[@class='m--big']";
	public static final String Login_terms_uncheckedVi = "/html//form[@id='registerForm']/fieldset[@class='user-form__fields']/div[@class='field field--submit']/div[2]/label/u[@class='m--big']";
	public static final String Login_terms_checkedVi = "/html//form[@id='registerForm']/fieldset[@class='user-form__fields']/div[@class='field field--submit']/div[2]/label/u[@class='m--big']/span[@class='ico ico--check']";

	
	
//// sign up: ////////////////////////////////////////////////////////

	public static final String SignUp_button = "/html//div[@id='topbar']/div[@class='default']/div[3]/div[1]/span[@class='topbar__menu-item-link']";
	public static final String SignUp_field_email = "i_signup-email";
	public static final String SignUp_button_confirm = "/html//form[@id='registerForm']//button[@type='submit']";
	public static final String SignUp_PasswordShown = "/html//form[@id='registerForm']/fieldset/div[3]/div[@class='field__field']/div//span[@class='ico ico--eye']";
	public static final String SignUp_PasswordHiden = "/html//form[@id='registerForm']/fieldset/div[3]/div[@class='field__field']/div//span[@class='ico ico--eye-hide']";
	public static final String SignUp_phone_button = "/html//form[@id='registerForm']//div[@class='button m--fill m--h40 social-phone']/span[@class='button-text']/span[@class='hidden-lte-m']";
	public static final String SignUp_phoneNumber = "/html//input[@id='i_sign-phone']";
	public static final String SignUp_phoneNumber_toSignIn = "/html//form[@id='phoneNumberForm']//a[@class='field__signin-link']";
	public static final String SignIn_phoneNumber_toSignUp = "/html//form[@id='phoneNumberForm']//span[@class='field__signup']/a[@class='field__signup-link']";
	public static final String SignUp_google_button = "/html//form[@id='registerForm']//div[@class='button m--fill m--h40 social-gplus']/span[@class='button-text']/span[@class='hidden-lte-m']";
	public static final String SignUp_google_field = "/html//input[@id='identifierId']";
	public static final String SignUp_googlePassword_field = "/html//div[@id='password']//input[@name='password']";
	public static final String SignUp_fb_button = "/html//form[@id='registerForm']//div[@class='button m--fill m--h40 social-facebook']/span[@class='button-text']/span[@class='hidden-lte-m']";
	public static final String SignUp_fb_field = "//html[@id='facebook']//input[@id='email']";
	public static final String SignUp_fbPassword_field = "//html[@id='facebook']//input[@id='pass']";	
	public static final String SignUp_fb_zipyLogo = "//html[@id='facebook']//form[@id='platformDialogForm']/div[@class='_5l58']/div[@class='_5uz8']/div[@class='_16l6 _396- _3crb']//img";
	public static final String SignUp_fb_userAccept = "//html[@id='facebook']//form[@id='platformDialogForm']//div[@class='_5uz8']//button[@name='__CONFIRM__']";
	public static final String SignUp_phone_pressEnter = "/html//form[@id='phoneNumberForm']//button[@type='submit']";
	public static final String SignUp_phone_fieldCode ="/html//input[@id='i_sign-code']";
	public static final String SignUp_phone_messageExist = "/html//form[@id='phoneNumberForm']//p[.='מספר זה כבר קיים במערכת']";

	
	
//// phone: ////////////////////////////////////////////////////////
	public static final String PhoneNumber = "+97253-9821817"; //from https://miracletele.com/sms/receive/IL/972539822586
	public static final String PhoneNumber_short = "+97253-98218"; 
	public static final String PhoneNumber_long = "+97253-98218171234"; 
	public static final String PhoneNumber_letters = "+97a53-9821817";
	public static final String PhoneNumber_letterF = "a53-9821817";
	public static final String PhoneNumber_signF = "$53-9821817"; 
	public static final String PhoneNumber_emptySpace = "          ";
	public static final String PhoneNumber_wiredPhone = "+9728-6438123"; 
	public static final String PhoneNumber_wiredIllegal = "012345678"; 
	public static final String PhoneNumber_mobileIllegal = "0111111111"; 

	
	
//// email: ////////////////////////////////////////////////////////

	public static final String EmailCredit = "vikos120989@yandex.com";	
	public static final String PasswordCredit = "123456";
	public static final String Email = "test@mail.com";
	public static final String Password = "123456";	
	
	public static final String Email_zipy = "testzipy1@gmail.com";
	public static final String Email_zipy_password = "testzipy1testzipy1";
	public static final String Email_zipy2 = "testzipy2@gmail.com";
	public static final String Email_empty = "  ";
	public static final String Email_domain_withoutAt = "testmail.com";
	public static final String Email_domain_illegal = "test@1#1.com";
	public static final String Email_domain_empty = "test@      .com";
	public static final String Email_ending_withoutDot = "test@mailcom";	
	public static final String Email_ending_empty = "test@111.   ";	
	public static final String Email_ending_illegal = "test@mail.111";
	public static final String Email_name_startWithSign = "'test@mail.com";
	public static final String Email_name_withSpace = "t est@mail.com";
	public static final String Email_name_empty = "@mail.com";
	public static final String Email_domain_oneSignOnly = "t est@mail.com";
	public static final String Email_ending_oneSignOnly = "t est@mail.com";
	public static final String Email_moreThan254signs = "a12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345@mail.com";
	public static final String Email_noGoogle = "test@qwer.com";
	public static final String Email_phone = "050-6000000";

	public static final String Password_short = "123";
	public static final String Password_moreThan100signs = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
	public static final String Password_empty = "  ";

	
	
//// user data: ////////////////////////////////////////////////////////

	public static final String user_personalDataButton = "/html//div[@id='topbar']/div[@class='default']//span[@class='topbar__user-link-no-name']";
	public static final String user_changePassword = "/html//form[@id='profileForm']//a[@href='#popup_password-changing']";
	public static final String user_changePassword_currentPassField = "/html//input[@id='i_profile-password-current']";
	public static final String user_changePassword_newPassField = "/html//input[@id='i_profile-password-new']";
	public static final String user_changePassword_newPassAgainField = "/html//input[@id='i_profile-password-repeat']";
	public static final String user_changePassword_succesMessageVi = "/html/body/div[@aria-labelledby='popup_heading']//*[@class='ico ico--success']";
	public static final String user_changePassword_succesMessageClose = "/html/body/div[@aria-labelledby='popup_heading']//*[@class='ico ico--close']";
	public static final String user_changePassword_mobile = "/html//div[@id='topbar']/div[3]/div/label[5]/span[@class='ico ico--lock']";
	public static final String user_recoverPassword = "/html//form[@id='loginForm']//div[@class='field__bottom']/a[1]";
	public static final String user_recoverPassword_field = "/html//input[@id='i_forgot-phone-email']";
	public static final String user_recoverPassword_reconnect = "/html//form[@id='forgotForm']//div[@class='field--success']//a";
	public static final String user_recoverPassword_help = "/html//form[@id='forgotForm']/fieldset//a[@href='https://www.zipy.co.il/contact-us']";
	public static final String user_changeEmail = "/html//form[@id='profileForm']//a[@href='#popup_email-changing']";
	public static final String user_changeEmail_newEmaiField = "/html//input[@id='i_profile-email']";
	public static final String user_changeEmail_mobile = "/html//div[@id='topbar']//span[@class='ico ico--email']";

	
	
////findzip (index): ////////////////////////////////////////////////////////

	
	public static final String index_correctIndex1 = "8425137"; //באר שבע, אביגדור המאירי  27  (index_cityField_data_BS +  index_streetField_data1 + index_houseField_data1)
	public static final String index_correctIndex2 = "8477712"; // 27 באר שבע, שד' ירושלים (index_cityField_data_BS +  index_streetField_data2 + index_houseField_data1)
	public static final String index_correctIndex3 = "8428392"; // באר שבע, תל חי 27 א    (index_cityField_data_BS +  index_streetField_data3 + index_houseField_data1 + index_entryField_1)
	public static final String index_correctIndex4 = "8428393"; // באר שבע, תל חי 27 ב    (index_cityField_data_BS +  index_streetField_data3 + index_houseField_data1 + index_entryField_2)
	public static final String index_correctIndex5 = "6941309"; // תל אביב , אביגדור המאירי  9 (index_cityField_data_TA +  index_streetField_data1 + index_houseField_data2)
	public static final String index_correctIndex6 = "8425138"; //באר שבע, אביגדור המאירי  29 (index_cityField_data_BS +  index_streetField_data1 + index_houseField_data3) 
	public static final String index_correctIndex7 = "8486227"; //באר שבע, הר כנען 27      (index_cityField_data_BS +  index_streetField_data4 + index_houseField_data1) 
	public static final String index_correctIndex8 = "8486209"; //באר שבע, הר כנען 9      (index_cityField_data_BS +  index_streetField_data4 + index_houseField_data2) 
	public static final String index_correctIndex9 = "8477703"; //באר שבע, שד' ירושלים 9      (index_cityField_data_BS +  index_streetField_data2 + index_houseField_data2) 
	public static final String index_correctIndex10 = "8414001"; //באר שבע, ת.ד. 4023       (index_cityField_data_BS +  index_postboxField_data1) 

	public static final String index_cityField = "/html//input[@id='location']";
	public static final String index_cityField_partData = "באר";
	public static final String index_cityField_data_BS = "באר שבע";
	public static final String index_cityField_data_TA = "תל אביב";
	public static final String index_cityField_data_1 = "/html//form[@id='address2zip-form']/div[@class='txt__calc-fields']/div[1]/div[@class='field__field']/div/div/span[@class='autocomplete-link']";
	public static final String index_city_mapList = "//div[@id='wrapper']//main[@role='main']//a[@href='https://www.zipy.co.il/zipmap']";
	public static final String index_city_mapList_BS = "/html//div[@id='wrapper']//main[@role='main']/section[@class='txt']//a[@alt='איתור מיקוד באר שבע']";
	
	public static final String index_streetField = "/html//input[@id='street']";
	public static final String index_streetField_data1 = "אביגדור המאירי";
	public static final String index_streetField_data2 = "שד' ירושלים";
	public static final String index_streetField_data3 = "תל חי";
	public static final String index_streetField_data4 = "הר כנען";

	public static final String index_houseField = "/html//input[@id='house']";
	public static final String index_houseField_data1 = "27";
	public static final String index_houseField_data2 = "9";
	public static final String index_houseField_data3 = "29";
	
	public static final String index_entryField = "/html//form[@id='address2zip-form']/div[@class='txt__calc-fields']/div[@class='narrow']//div[@class='field field--default field--entrance']/div[@class='field__field']/div//div[@class='selectric']//span[@class='selectric-option-text']";
	public static final String index_entryField_1 = "/html//form[@id='address2zip-form']//div[@class='field field--default field--entrance']/div[@class='field__field']/div/div[1]/div[@class='selectric-items']//ul/li[2]//span[@class='selectric-option-text']";
	public static final String index_entryField_2 = "/html//form[@id='address2zip-form']//div[@class='field field--default field--entrance']/div[@class='field__field']/div/div[1]/div[@class='selectric-items']//ul/li[3]//span[@class='selectric-option-text']";
	
	public static final String index_postboxField = "/html//input[@id='pob']";
	public static final String index_postboxField_data1 = "4023";

	public static final String index_foundByZipy = "/html//form[@id='address2zip-form']//span[@class='zip-value']";

	public static final String index_history1 = "//*[@id='wrapper']/div[2]/main/section/div[2]/div[2]/div/div[1]/button/span";
	public static final String index_history2 = "//*[@id='wrapper']/div[2]/main/section/div[2]/div[2]/div/div[2]/button/span";
	public static final String index_history_i = "//*[@id='wrapper']/div[2]/main/section/div[2]/div[2]/div/div["; // + i + "]/button/span"

	public static final String index_searchButton = "/html//form[@id='address2zip-form']//button[@type='submit']";
	public static final String index_clearButton = "/html//form[@id='address2zip-form']//div[@class='buttons__down']/button[@type='button']";
	public static final String index_infoIcon = "//form[@id='address2zip-form']//span[@class='ico ico--info']";

	
}
