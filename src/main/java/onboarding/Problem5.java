package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!checkValidation(money)){
            return null;
        }
        answer = getListOfBill(money);;
        return answer;
    }

    private static boolean checkValidation(int money){
        if(1<=money && money<=1000000){
            return true;
        }
        return false;
    }

    private static List<Integer> getListOfBill(int money){
        List<Integer> listOfMoney = getListOfMoney();
        List<Integer> billsOfMoney = getLeastBills(money, listOfMoney);
        return billsOfMoney;
    }

    private static List<Integer> getListOfMoney(){
        return List.of(50000,10000,5000,1000,500,100,50,10,1);
    }

    private static List<Integer> getLeastBills(int money, List<Integer> moneyList){
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> billStorage = new HashMap<>();
        moneyList.iterator().forEachRemaining(a -> billStorage.put(a,0));
        calculateLeastBill(money,billStorage);
        billStorage.keySet().stream().sorted(Comparator.reverseOrder()).forEach(a-> result.add(billStorage.get(a)));
        return result;
    }

    private static void calculateLeastBill(int money, Map moneyStorage){
        List<Integer> listOfUsableBill = new ArrayList<>(moneyStorage.keySet());
        Collections.sort(listOfUsableBill, Collections.reverseOrder());
        while(money!=0){
            for(int i=0; i<listOfUsableBill.size(); i++){
                int bill = listOfUsableBill.get(i);
                moneyStorage.put(bill, money/bill);
                money%=bill;
            }
        }
    }
}
