package testData;

import org.testng.annotations.DataProvider;

public class userTestData {

    @DataProvider
    public static Object[][] signInData()
    {
        Object[][] userData = new Object[1][2];
        //Valid Business user credentials
        userData[0][0] = "wallet-dev@assurdly.com"; userData[0][1] = "Password12$";
        //Valid User credentials
        //userData[0][0] = "wallet-sub@assurdly.com"; userData[0][1] = "6wqpjmz3cgxzxupxmu1o";

        return userData;
    }
    @DataProvider
    public static Object[][] signUpData()
    {
        Object[][] userData = new Object[1][2];
        //Valid user credentials
        userData[0][0] = "amarachi@mailinator.com"; userData[0][1] = "Password123@";
        return userData;
    }


    @DataProvider
    public static Object[][] subWalletData()
    {
        Object[][] sWalletData = new Object[1][4];
        //Create sub-wallet data
        sWalletData[0][0] = "Wallet";
        sWalletData[0][1] = "Test";
        sWalletData[0][2] = "newsubwallettest@yahoo.com";
        sWalletData[0][3] = "09052020";
        return sWalletData;
    }

    @DataProvider
    public static Object[][] fundWalletData()
    {
        Object[][] fundData = new Object[1][2];
        //fund sub-wallet data
        fundData[0][0] = "3000"; fundData[0][1] = "1234";
        return fundData;
    }

    @DataProvider
    public static Object[][] withdrawFromWalletData()
    {
        Object[][] withdrawData = new Object[1][1];
        //withdraw from sub-wallet data
        withdrawData[0][0] = "3000";
        return withdrawData;
    }

    @DataProvider
    public static Object[][] requestMoneyData()
    {
        Object[][] reqMoneyData = new Object[1][5];
        //Create sub-wallet data
        reqMoneyData[0][0] = "Final Test";
        reqMoneyData[0][1] = "final.com";
        reqMoneyData[0][2] = "1000";
        reqMoneyData[0][3] = "Thank you my customer";
        reqMoneyData[0][4] = "Nice domain";
        return reqMoneyData;
    }

    @DataProvider
    public static Object[][] requestLinkData()
    {
        Object[][] linkID = new Object[1][1];
        linkID[0][0] = 1;
        return linkID;
    }

    @DataProvider
    public static Object[][] buyAirtimeData()
    {
        Object[][] purchaseAirtimeData = new Object[1][4];
        //Create sub-wallet data
        purchaseAirtimeData[0][0] = 2;
        purchaseAirtimeData[0][1] = "08030783791";
        purchaseAirtimeData[0][2] = "1000";
        purchaseAirtimeData[0][3] = "1234";
        return purchaseAirtimeData;
    }

    @DataProvider
    public static Object[][] userProfileData()
    {
        Object[][] profileData = new Object[1][2];
        //Valid user credentials
        profileData[0][0] = "Round Estate";
        profileData[0][1] = "Chinatown";
        return profileData;
    }

    @DataProvider
    public static Object[][] userPasswordData()
    {
        Object[][] passwordData = new Object[1][3];
        //Valid user credentials
        passwordData[0][0] = "Password12$"; //Old password
        passwordData[0][1] = "12345678";    //New password
        passwordData[0][2] = "12345678";    //Confirm new password
        return passwordData;
    }

    @DataProvider
    public static Object[][] userPinData()
    {
        Object[][] pinData = new Object[1][3];

        pinData[0][0] = "1234"; //Old user pin
        pinData[0][1] = "4321"; //New user pin
        pinData[0][2] = "4321"; //Confirm new pin
        return pinData;
    }

    @DataProvider
    public static Object[][] userCategoryData()
    {
        Object[][] categoryData = new Object[2][1];
        //Transaction categories
        categoryData[0][0] = "Bank Transfer Charges";
        categoryData[1][0] = "Wallet Transfer";
        return categoryData;
    }

    @DataProvider
    public static Object[][] transactionData()
    {
        Object[][] transactionDateData = new Object[1][2];

        transactionDateData[0][0] = "12051998"; //Start date
        transactionDateData[0][1] = "12051999"; //End date
        return transactionDateData;
    }

    @DataProvider
    public static Object[][] reasonData()
    {
        Object[][] reason = new Object[1][1];

        reason[0][0] = "I recharged but I didn't not get credited";
        return reason;
    }
}
