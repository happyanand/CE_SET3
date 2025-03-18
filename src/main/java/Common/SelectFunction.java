package Common;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains different functions of select functionality.
 * 
 * @author arun.chettur
 *
 */
public class SelectFunction {

	public static void selectVisibletext(WebElement element, String visibletextvalue) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletextvalue);
	}

	public static void selectbyValue(WebElement element, int visibletextvalue) {
		Select sel = new Select(element);
		List<WebElement> listElemts = sel.getOptions();
		listElemts.get(visibletextvalue).click();

	}

	public static void selectbyIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(0);
		

	}
}
