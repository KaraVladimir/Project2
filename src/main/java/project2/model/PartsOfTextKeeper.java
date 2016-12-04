package project2.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author kara.vladimir2@gmail.com.
 */

public enum PartsOfTextKeeper {
    INSTANCE;

    private static HashMap<String, PartOfText> wordMap = new HashMap<>();

    public boolean isWordExist(CharSequence charSequence) {
        return wordMap.containsKey(charSequence);
    }

    public PartOfText lookupInWordKeeper(Class<? extends PartOfText> clazz, CharSequence charSequence) {
        PartOfText partOfText = null;
        try {
            if (wordMap.containsKey(charSequence)) {
                partOfText = wordMap.get(charSequence);
            } else {
                partOfText = clazz.getDeclaredConstructor(CharSequence.class).
                        newInstance(charSequence);
                wordMap.put(charSequence.toString(), partOfText);
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
        wordMap.remove(charSequence.toString());
    }


}
