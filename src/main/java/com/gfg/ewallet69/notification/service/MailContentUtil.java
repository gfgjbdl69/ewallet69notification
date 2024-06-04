package com.gfg.ewallet69.notification.service;



public class MailContentUtil {

    public static String getSuccessSenderEmailContent(String userName, Double amount){
        StringBuilder builder=new StringBuilder();
        builder.append("Hi "+userName+"\n");
        builder.append("Your account is debited of "+amount);
        return builder.toString();
    }

    public static String getSuccessReceiverEmailContent(String userName, Double amount){
        StringBuilder builder=new StringBuilder();
        builder.append("Hi "+userName+"\n");
        builder.append("Your account is credited with "+amount+"  successful\n");
        return builder.toString();
    }

    public static String getFailureEmailContent(String userName, Double amount){
        StringBuilder builder=new StringBuilder();
        builder.append("Hi "+userName+"\n");
        builder.append("Your transaction of "+amount+" is failed\n");
        return builder.toString();
    }

    public static String getSubjectTransactionSuccessful(){
        return "Transaction Successful!";
    }

    public static String getSubjectTransactionFailure(){
        return "Transaction Failure!";
    }
}
