import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * manage sale transactions
 */
public class SaleTransactionManager {
    private Map<Integer,SaleTransaction> transactions;

    public SaleTransactionManager() {
        this.transactions = new HashMap<>();
    }

    private int nextTransactionId() {
        if (transactions.isEmpty()) {
            return 1;
        }

        return Collections.max(transactions.keySet()) + 1;
    }

    public SaleTransaction newTransaction(LocalDate date, User kasir) {
        return new SaleTransaction(date, kasir, 0);
    }

    public void store(SaleTransaction saleTransaction) {
        int id = nextTransactionId();
        saleTransaction.setTransactionNumber(id);
        transactions.put(id, saleTransaction);
    }
}
