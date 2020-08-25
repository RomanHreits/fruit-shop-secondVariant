package temporary;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

public interface FruitStoreOperations {
    void action(FruitStorage fruitStorage, String[] array);

    default void duplicateOperations(Map<LocalDate, Integer> map, String[] array) {

    }
}

