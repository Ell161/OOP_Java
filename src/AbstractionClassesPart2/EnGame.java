package AbstractionClassesPart2;

import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            result.add(Character.toString(i));
        }
        return result;
    }
}