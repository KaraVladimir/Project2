package project2.model.entity;

import project2.model.CompositePartOfText;
import project2.model.PartOfText;
import project2.model.PartsOfTextKeeper;
import project2.model.flyweight.PartsOfTextKeeperImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class PunctuationMark implements CompositePartOfText {
    List<PartOfText> list = new ArrayList<>();

    @Override
    public List<PartOfText> getList() {
        return list;
    }

    @Override
    public void parse(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            PartsOfTextKeeper textKeeper = PartsOfTextKeeperImpl.INSTANCE;
            Symbol symbol = (Symbol) textKeeper.lookupPartOfText(Symbol.class,
                    String.valueOf(charSequence.charAt(i)));
            addPart(symbol);
        }
    }
}
