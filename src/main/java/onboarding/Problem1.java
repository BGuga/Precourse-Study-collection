package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = getGameResult(pobi, crong);
        return answer;
    }

    private static int getGameResult(List<Integer> userA, List<Integer> userB){
        if(!(userValidation(userA)&&userValidation(userB))){
            return -1;
        }

        int userAPoint = getMaxPoint(userA);
        int userBPoint = getMaxPoint(userB);

        if (userAPoint>userBPoint) {
            return 1;
        } else if (userAPoint<userBPoint) {
            return 2;
        } else if (userAPoint == userBPoint) {
            return 0;
        }
        return -1;
    }

    private static int getMaxPoint(List<Integer> user){
        int leftMaxPoint = maxPageValue(user.get(0));
        int rightMaxPoint = maxPageValue(user.get(1));

        if(leftMaxPoint>rightMaxPoint){
            return leftMaxPoint;
        } else {
            return rightMaxPoint;
        }


    }

    private static boolean userValidation(List<Integer> user){
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        if(user.size()!=2) {
            return false;
        }

        if(leftPage != rightPage-1){
            return false;
        }

        if(leftPage==1 || rightPage==400){
            return false;
        }

        if (leftPage<1 || rightPage>400) {
            return false;
        }
        return true;
    }

    private static int maxPageValue(Integer a){
        int mult = multValue(a);
        int sum = sumValue(a);
        if(mult>sum){
            return mult;
        } else{
            return sum;
        }
    };

    private static int multValue(Integer a){
        int number = a;
        int result = 1;
        while(number!=0){
            result*=(number%10);
            number/=10;
        }

        return result;
    };
    private static int sumValue(Integer a){
        int number = a;
        int result = 0;
        while(number!=0){
            result+=(number%10);
            number/=10;
        }

        return result;
    };

}