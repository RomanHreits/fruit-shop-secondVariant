package temporary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FruitStoreTest {
    private static final String PATH_FILE_WITH_ALL_OPERATIONS = "src/main/resources/allOperations.txt";
    private static final String PATH_REPORT_FILE = "src/main/resources/report.txt";
    private static final String SUPPLY_FILE_PATH = "src/main/resources/fruits.txt";
    private static final String BUY_FILE_PATH = "src/main/resources/buyFruits.txt";
    private FruitStore fruitStore;

    @Before
    public void init() {
        fruitStore = new FruitStore();
    }

    @Test
    public void checkExecuteFileWithCorrectParams() {
        List<String> report = List.of("fruit,quantity\n", "banana, 80\n",
                "orange, 120\n", "apple, 150\n");
        fruitStore.executeFile(PATH_FILE_WITH_ALL_OPERATIONS);
        Assert.assertEquals(report,fruitStore.getStoreInfoFile(PATH_REPORT_FILE));
    }
}