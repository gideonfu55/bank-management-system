import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import constants.AccountType;
import constants.Transaction;
import model.account.Chequing;
import model.account.Credit;
import model.account.Savings;
import repository.AccountRepository;
import service.AccountService;
import service.ChequingService;
import service.CreditService;
import service.SavingsService;

public class App {

    static Path[] paths = new Path[] { Paths.get("data/accounts.txt"), Paths.get("data/transactions.txt") };
    static AccountRepository accountRepository = new AccountRepository();
    static ChequingService chequingService = new ChequingService(accountRepository);
    static CreditService creditService = new CreditService(accountRepository);
    static SavingsService savingsService = new SavingsService(accountRepository);

    public static void main(String[] args) {

        Chequing thomasShelbyChequing = new Chequing("f1e31491-1120-4fcb-a73f-04fddd433979", "thomasshelby@peakyblinders.com", "Thomas Michael Shelby", "graceshelby4ever", new BigDecimal(10000000.00));
        chequingService.createAccount(thomasShelbyChequing);

        System.out.println(chequingService.retrieveAccount(thomasShelbyChequing.getId()));
        chequingService.deposit(thomasShelbyChequing.getId(), new BigDecimal(1000000.00));
        System.out.println(chequingService.retrieveAccount(thomasShelbyChequing.getId()).getBalance());

        Savings sherlockHolmesSavings = new Savings("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "sherlockholmes@gmail.com", "Sherlock Holmes", "bakerstree&watson", new BigDecimal(500000));
        savingsService.createAccount(sherlockHolmesSavings);
        System.out.println(savingsService.retrieveAccount(sherlockHolmesSavings.getId()));
        savingsService.withdraw(sherlockHolmesSavings.getId(), new BigDecimal(10000000));
        System.out.println(savingsService.retrieveAccount(sherlockHolmesSavings.getId()).getBalance());

        Credit albusDumbledoreCredit = new Credit("48910e55-0b73-40be-b1e6-6355d08013c3", "albusheadmaster@hogwarts.edu.uk", "Albus Percival Wulfric Brian Dumbledore", "sherbetlemonislife", new BigDecimal(1000));
        creditService.createAccount(albusDumbledoreCredit);
        System.out.println(creditService.retrieveAccount(albusDumbledoreCredit.getId()));
        creditService.withdraw(albusDumbledoreCredit.getId(), new BigDecimal(200000));
        System.out.println(creditService.retrieveAccount(albusDumbledoreCredit.getId()).getCredit());

    }

}
