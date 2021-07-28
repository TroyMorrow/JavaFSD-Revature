package com.troymorrow.Day3;

class UserAlreadyLoggedInException extends Exception{

}

class Authentication{

    private boolean isLogged = false;

    public void login(String email, String password) throws UserAlreadyLoggedInException {
        if (!isLogged){
            if (email.equals("admin") && password.equals("123")){
                isLogged = true;
                System.out.println("Login successful");
            }else {
                System.out.println("Login failed! Try again");
            }
        } else{
            throw new UserAlreadyLoggedInException();
        }
    }
}
public class Demo21 {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        try {
            auth.login("admin", "123");
        } catch (UserAlreadyLoggedInException e) {
            e.printStackTrace();
        }

        try {
            auth.login("admin", "123");
        } catch (UserAlreadyLoggedInException e) {
//            e.printStackTrace();
            System.out.println("Hey you have already logged in");
        }
    }
}
