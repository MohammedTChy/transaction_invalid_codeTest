import java.util.*;

class Underwriter {
  
  public static String[] identifyInvalidTransactions(String[] transactions) {
    Map<String, List<String[]>> nameToTransactions = new HashMap<>();
    List<String> invalidTransactions = new ArrayList<>();

    for (String transaction : transactions) {
      String[] fields = transaction.split(",");
      String name = fields[0];
      int time = Integer.parseInt(fields[1]);
      int amount = Integer.parseInt(fields[2]);
      String city = fields[3];

      boolean invalid = amount > 2000;

      if (nameToTransactions.containsKey(name)) {
        List<String[]> prevTransactions = nameToTransactions.get(name);
        for (String[] prevTransaction : prevTransactions) {
          int prevTime = Integer.parseInt(prevTransaction[1]);
          int prevAmount = Integer.parseInt(prevTransaction[2]);
          String prevCity = prevTransaction[3];

          if (Math.abs(time - prevTime) <= 60 &&
              !city.equals(prevCity)) {
            invalid = true;
          }

          if (Math.abs(time - prevTime) <= 60 &&
              amount == prevAmount &&
              !city.equals(prevCity)) {
            invalid = true;
          }

          if (time == prevTime &&
              amount == prevAmount &&
              !city.equals(prevCity)) {
            invalid = true;
          }
        }
      }

      if (invalid) {
        invalidTransactions.add(transaction);
      }

      if (!nameToTransactions.containsKey(name)) {
        nameToTransactions.put(name, new ArrayList<>());
      }
      nameToTransactions.get(name).add(fields);
    }

    return invalidTransactions.toArray(new String[0]);
  }
}
