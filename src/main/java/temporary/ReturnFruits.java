package temporary;

public class ReturnFruits implements FruitStoreOperations {
    @Override
    public void action(FruitStorage fruitStorage, String[] array) {
        FruitStoreOperations operations = new SupplyFruits();
        operations.action(fruitStorage, array);
    }
}
