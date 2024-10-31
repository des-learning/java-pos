import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SaleTransaction {
    private LocalDate date;
    private User kasir;
    private int transactionNumber;
    private Map<String, SaleItem> items; // SKU -> SaleItem

    public SaleTransaction(LocalDate date, User kasir, int transactionNumber) {
        this.date = date;
        this.kasir = kasir;
        this.transactionNumber = transactionNumber;
        this.items = new HashMap<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public User getKasir() {
        return kasir;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public Collection<SaleItem> getItems() {
        return items.values();
    }

    public int getItemsCount() {
        return items.size();
    }

    public int getTotalItemsQuantity() {
        int total = 0;
        for (SaleItem i: items.values()) {
            total += i.getQuantity();
        }

        return total;
    }

    public int getGrandTotal() {
        int total = 0;
        for (SaleItem i : items.values()) {
            total += i.getSubtotal();
        }

        return total;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void addItem(SaleItem item) {
        SaleItem existingItem = this.items.getOrDefault(item.getProduct().getSKU(), new SaleItem(item.getProduct(), 0));
        existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        this.items.put(item.getProduct().getSKU(), existingItem);
    }

    @Override
    public String toString() {
        return "SaleTransaction{" +
                "date=" + date +
                ", kasir=" + kasir +
                ", transactionNumber=" + transactionNumber +
                '}';
    }
}
