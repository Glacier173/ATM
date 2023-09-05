import java.io.BufferedReader;
import java.io.FileReader;

public class Tester {
    public static void main(String[] args) throws Exception
    {
        ATM b = new ATM();
        b.openAccount("user1", 1000.0);
        b.openAccount("user2", 250.0);
        System.out.println(b.checkBalance("user1"));
        System.out.println(b.checkBalance("user2"));
        b.transferMoney("user1", "user2", 50.0);
        System.out.println(b.checkBalance("user1")); //950
        System.out.println(b.checkBalance("user2")); //300
        BufferedReader br = new BufferedReader(new FileReader("AccountAudit.txt"));
        b.audit();
        if (br.readLine().equals ("UserID: user1; Amount: 950.0") && br.readLine().equals("UserID: user2; Amount: 300.0"))
        {
            System.out.println("Audit works");
        }
        br.close();
    }
}
