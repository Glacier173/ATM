import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ATM
{
    private HashMap<String, Double> hMap = new HashMap<String, Double>();
    public void openAccount(String userID, Double amount) throws Exception
    {
        if (hMap.containsKey(userID))
        {
            throw new Exception("User already exists");
        }
        hMap.put(userID, amount);
    }
    public void closeAccount(String userID) throws Exception
    {
        if (hMap.containsKey(userID))
        {
            throw new Exception("Account has a balance, please remove balance before deleting the account");
        }
        hMap.remove(userID);
    }
    public double depositMoney(String userID, double amount) throws Exception
    {
        if (!hMap.containsKey(userID))
        {
            throw new Exception ("Sorry, you're broke AF");
        }
        hMap.put(userID, hMap.get(userID)+amount);
        return amount;
    }
    public double withdrawMoney(String userID, double amount) throws Exception
    {
        if (!hMap.containsKey(userID))
        {
            throw new Exception ("Sorry, you're broke AF");
        }
        if (hMap.get(userID) <= amount)
        {
            hMap.put(userID, hMap.get(userID)-amount);
        }
        else
        {
            throw new Exception ("Sorry, you're broke AF");
        }
        return amount;
    }
    public boolean transferMoney (String fromAccount, String toAccount, double amount)
    {
        if (amount <= hMap.get(fromAccount))
        {
            hMap.put(fromAccount, hMap.get(fromAccount) - amount);
            hMap.put(toAccount, hMap.get(toAccount) + amount);
            return true;
        }
        return false;
    }
    public void audit() throws IOException
    {
        FileWriter fileWriter = new FileWriter("AccountAudit.txt", false);
        PrintWriter pw = new PrintWriter(fileWriter);
        for (String key: hMap.keySet())
        {
            pw.write("UserID: " + key + "; Amount: " + hMap.get(key) + "\n");
        }
        pw.close();
    }
}