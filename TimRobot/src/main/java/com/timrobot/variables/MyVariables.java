package com.timrobot.variables;

import org.openqa.selenium.By;

public class MyVariables {
	

	/**************************************************************************************************************************/
	/*******************************************           timbusiness.it             *****************************************/
	/**************************************************************************************************************************/
	
	//CSV FILE
	public static String csvfileT = "C:\\Users\\devi\\Desktop\\PUNA\\user-passT.csv";
	
	//URL LINK
	public static String urlTim = "https://www.timbusiness.it/";
	
	//cookie
	public static By cookieTim = By.xpath("//a[@id='cookie-bar-accept']");
	
	//user login
	public static By areaClientiTim = By.xpath("//a[@id='loginButton']");
	public static By usernameTim 	= By.xpath("//input[@id='inputEmailPro']");
	public static By passwordTim 	= By.xpath("//input[@id='inputPasswordPro']");
	public static By checkBoxTim 	= By.xpath("//span[@class='ta-checkbox__custom']");
	public static By vaiButtonTim 	= By.xpath("//button[@id='buttonSubmitPro']");
	
	
	//consumi e report
	
	public static By dropDownMenuTim = By.xpath("//li[@id='Pagina-guarda']");
	public static By consumiReportTim = By.xpath("//a[@href='https://areaclienti.timbusiness.it/areaclienti/guarda/report']");
	
	public static By vaiAlReportTim = By.xpath("//b[@id='label_Report_TastoVaiAiReport_Ref']");
	
	
	//FATURE - LE MIE FATURE
	public static By fatureTim = By.xpath("//a[@href='stmtrpt.do?reportId=nlf_olf_stat_lastBills']");
	public static By leMieFatureTim = By.xpath("//a[@class='subtabcopy'][@href='stmtrpt.do?reportId=nlf_olf_stat_lastBills']");
	
	public static By selezionaAccNr = By.xpath("//select[@id='accountNumber']");
	
	//FATURE - DOCUMENTAZIONE DEL TRAFICO
	public static By documDelTraffico = By.xpath("//a[@href='listReportTim.do?forwardName=F&amp;reportType=^fatt_']");
	
	public static By fatturato = By.xpath("//a[@href='listReportTim.do?reportType=^fatt_&amp;forwardName=F']");
	public static By analitico = By.xpath("//a[@href='report.do?reportId=fatt_ana_003&amp;forwardName=F']");
	
	
	public static By ricaricaBussines = By.xpath("//a[@href='listReportTim.do?reportType=^RICBUS_&amp;forwardName=RB']");
	public static By ricaricaBussinesAnalitic = By.xpath("//a[@href='report.do?reportId=RICBUS_ana_001&amp;forwardName=RB']");
	
	//user fature logout
	public static By logoutFatureTim = By.xpath("//a[@href='/ebilling_IS/j_acegi_logout']");
	
	//user logout
	public static By logoutTim = By.xpath("//a[@id='logout_image_id']");
	
	
	/************************************************************************************************************************/
	/******************************************         mybusiness.it        ************************************************/
	/************************************************************************************************************************/

	//CSV FILE
	public static String csvfileM = "C:\\Users\\devi\\Desktop\\PUNA\\user-passM.csv";
	
	//URL LINK
	public static String urlMyBusiness = "https://www.mybusiness.it/";
	public static By closeCookieMy = By.xpath("//a[@class='close-cookie-banner']");
	
		
	public static By usernameMy = By.xpath("//input[@id='edit-username']");
	public static By passwordMy = By.xpath("//input[@id='edit-password']");
	public static By accediMy = By.xpath("//input[@id='edit-submit']");
	
	
	//dropdown menu mybusiness
	public static By dropDownMenuMy = By.xpath("//li[@id='menu-48-1']");
	public static By telefoniaMobMy = By.xpath("//a[@href='/web/fatturazione-traffico/telefonia-mobile']");
	
	public static By fatureAziendaliMy = By.xpath("//a[@class='menu__link']");
	
	
	
	
	
	public static By bimestreMy = By.xpath("//a[@href='/web/fatturazione-traffico/telefonia-mobile/fatture-aziendali/fattura-html/2021/02/20210211']");
	
	


}
