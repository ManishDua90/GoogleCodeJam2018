import java.util.Scanner;

public class Solution {
    int numberOfTestCases;
    long damageThreshold[];
    static String program[];
    long shoot=-1;
    static int count = 0;
    static  int shootTemp = 100;
    long shootIn = Long.MAX_VALUE;
     static int flag = 0;
    public static void main(String[] args) {
        new Solution().getInputsAndCalculate();
    }

    private  void getInputsAndCalculate() {
        Scanner scanner = new Scanner(System.in);
        numberOfTestCases = scanner.nextInt();
        damageThreshold = new long[numberOfTestCases];
        program = new String[numberOfTestCases];
        for (int i =0 ;i<numberOfTestCases ;i++)
        {
            damageThreshold[i] = scanner.nextInt();
            program[i] = scanner.next();}
        for (int i =0 ;i<numberOfTestCases ;i++)
        {
            flag = 0;
            count=0;
            shootTemp = 0;
            shoot =calculate(program[i],damageThreshold[i],program[i].length());
            if (damageThreshold[i]>=shoot)
            System.out.println("Case #" + (i+1) +": 0" );
            else {

                int caseNumber = changeProgram(program[i],damageThreshold[i],program[i].length());
                if(caseNumber==-1)
                    System.out.println("Case #" + (i+1) +": " + "IMPOSSIBLE" );
                else
                System.out.println("Case #" + (i+1) +": " + caseNumber );
            }
        }
    }

    private int changeProgram(String program, long damageThreshold, int length) {

        int charge = 1;
        int firstChargeIndex=-1;
        char temp,temp1;
        shootTemp = 0;
        if (flag==1)
            return count;

        for (int i = 0;i<length;i++)
        {
            if (program.charAt(i)=='C')
            {
                charge = charge*2;
            }
            else
            {
                shootTemp = shootTemp + charge;
            }
            if (damageThreshold<shootTemp) {
                for (int j = i; j > 0; j--) {
                    if (program.charAt(j) == 'S' && program.charAt(j - 1) == 'C' && flag == 0) {
                        count++;
                        temp = program.charAt(j);
                        temp1 = program.charAt(j - 1);
                        program = program.substring(0, j - 1) + temp + temp1 + program.substring(j + 1, length);
                        shootIn = calculate(program, damageThreshold, length);
                        if (shootIn <= damageThreshold) {
                            flag = 1;
                            return count;
                        } else {
                            count = changeProgram(program, damageThreshold, length);
                            return count;
                        }
                    }
                }
            }
        }
        return  -1;
    }

    private  long calculate(String program, long damageThreshold, int length)
    {
        int shoot = 0,charge = 1;
        int firstChargeIndex=-1;
        for (int i = 0;i<length;i++)
        {
            if (program.charAt(i)=='C')
            {
                charge = charge*2;
            }
            else
            {
                shoot = shoot + charge;
            }
        }
        return shoot;
    }
}
