package AbstractionClassesPart2;

import java.util.ArrayList;
import java.util.List;

public class RuGame  extends AbstractGame {
    @Override
    List<String> generateCharList() {
        String str = "абвгдежзиклмнопрстуфхцчшщъыьэюя";
        List<String> result = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            result.add(String.valueOf(ch));
        }
        return result;
    }
}
