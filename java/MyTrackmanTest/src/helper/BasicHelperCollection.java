package helper;

import java.util.ArrayList;

public class BasicHelperCollection implements IHelperCollection{

	public ArrayList<ElementHelper> collection = new ArrayList<ElementHelper>();
	
	public ElementHelper getElementHelper(String name)
	{
		for (ElementHelper elementHelper : collection) {
			if (elementHelper.name.equals(name))
			{
				return elementHelper;
			}
		}
		return null;
	}

}
