public class Calculator {
    public int addNumber(int a, int b){
        return a + b;
    }

    public int findMaxNumber(int myArray[]){
        //int max = 0;
        int max = myArray[0];
        for (int i = 0; i < myArray.length; i++){
            if (max < myArray[i])
                max = myArray[i];
        }
        return max;
    }

    public int getCube(int number){
        return number * number * number;
    }

    public int multiplyTwoNumbers(int a, int b){
        return a * b;
    }
}
