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
}