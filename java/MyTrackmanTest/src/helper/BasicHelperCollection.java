package helper;

import java.util.ArrayList;

public class BasicHelperCollection implements IHelperCollection {
    /**
     * Below I decided to change collection variable to static which gave me an opportunity
     * to add ElementHelper elements to 'collection' without erasing already existing ones.
     * Therefore when I initialize each collection(LoginHelperCollection, MainScreenHelperCollection, etc.),
     * their elements are added to the parent BasicHelperCollection static variable.
     */
    protected static ArrayList<ElementHelper> collection;

    public BasicHelperCollection() {
        if (collection == null) {
            collection = new ArrayList<ElementHelper>();
        }
    }

    public ElementHelper getElementHelper(String name) {
        for (ElementHelper elementHelper : collection) {
            if (elementHelper.name.equals(name)) {
                return elementHelper;
            }
        }
        return null;
    }

}
