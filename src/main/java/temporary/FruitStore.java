package temporary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStore {
    FileExecutor executor;
    Map<String, FruitStoreOperations> operationsMap;
    Map<String, FruitStorage> storageMap;

    public FruitStore() {
        executor = new FileExecutor();
        this.operationsMap = new HashMap<>();
        operationsMap.put("s", new SupplyFruits());
        operationsMap.put("b", new BuyFruits());
        operationsMap.put("r", new ReturnFruits());
        storageMap = new HashMap<>();
        storageMap.put("banana", BananaStorage.getInstance());
        storageMap.put("orange", OrangeStorage.getInstance());
        storageMap.put("apple", AppleStorage.getInstance());
    }

    public void executeFile(String filepath) {
        for (String string : executor.fileExecutor(filepath)) {
            String[] inputLine = string.split(",");
            String name = inputLine[1];
            operationsMap.get(inputLine[0]).action(storageMap.get(name), inputLine);
        }
    }

    public List<String> getStoreInfoFile(String filepath) {
        if (filepath.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameter filepath!");
        }
        return executor.createInfoFile(storageMap, filepath);
    }
}
