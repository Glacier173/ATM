import java.util.HashMap;

public class ATM
{
    private static HashMap<String, Double> hMap = new HashMap<String, Double>();
    public void openAccount(String userID, Double amount) throws Exception
    {
        if (hMap.containsKey(userID))
        {
            throw new Exception("User already exists");
        }
        hMap.put(userID, amount);
    }
}