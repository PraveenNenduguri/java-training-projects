package interfaces;

public interface PaymentOperations {

    double cardPayment(double amount);

    double upiPayment(double amount);

    double walletPayment(double amount);

}