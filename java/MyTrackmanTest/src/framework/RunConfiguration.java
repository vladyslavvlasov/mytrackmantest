package framework;

public class RunConfiguration {
	
	public String name;
	public String chromedriverpath;
	public String chromeuserprofileargument=null;
	public enum browsernames {CHROME,IE,FIREFOX}
	public browsernames browser;
	
	public RunConfiguration(String name, String chromedriverpath, String chromeuserprofileargument, browsernames browsername)
	{
		this.name = name;
		this.chromedriverpath = chromedriverpath;
		this.chromeuserprofileargument=chromeuserprofileargument;
		this.browser = browsername;
	}

}
