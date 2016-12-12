package project2.model.flyweight;

import project2.model.PartOfText;
import project2.model.PartsOfTextKeeper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author kara.vladimir2@gmail.com.
 */

public enum PartsOfTextKeeperImpl implements PartsOfTextKeeper {
    INSTANCE;

    private static HashMap<String, PartOfText> partsMap = new HashMap<>();

    @Override
    public PartOfText lookupPartOfText(Class<? extends PartOfText> clazz, CharSequence charSequence) {
        PartOfText partOfText = null;
        try {
            if (partsMap.containsKey(charSequence)) {
                partOfText = partsMap.get(charSequence);
            } else {
                partOfText = clazz.getDeclaredConstructor().newInstance();
                partOfText.parse(charSequence);
                partsMap.put(charSequence.toString(), partOfText);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return partOfText;
    }

    void removeFromWordKeeper(CharSequence charSequence) {
        partsMap.remove(charSequence.toString());
    }


}
