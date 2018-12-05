/**
 * Created by sreedhar.d on 07 Aug,2018.
 */
public class SampleClass5 {
    public static void main(String[] args) {
        String className = "com.bankbazaar.MP.Loans.P1.CustomerLoginServiceWebFunctionalTest";
        String packageName = "com.bankbazaar.tatests.tests.webtest.MP.Loans.P1.PersonalLoanTest";

        System.out.println(getClassName(className));
        System.out.println(getClassName(packageName));
        String[] arr = packageName.split("\\.");
        int arrLength = arr.length;
        System.out.println(arr[arrLength - 1]);
        System.out.println(arr[arrLength - 2]);
        System.out.println(arr[arrLength - 3]);
        System.out.println(arr[arrLength - 4]);
    }

    private static String getClassName(String packageName)
    {
        String className = null;
        if(packageName != null && !packageName.equals(""))
        {
            int index = packageName.lastIndexOf(".");
            className = index == -1 ? packageName: packageName.substring(index + 1);
        }
        return className;
    }
}
