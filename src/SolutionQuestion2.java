import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionQuestion2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, k,flag=0,index=-1;
        int numberOfTestCases = Integer.parseInt(br.readLine());
        long temp;
        long[] numberOfInputs = new long[numberOfTestCases];
        long[][] arrayToBeSorted = new long[100][100];
        for (i = 0; i < numberOfTestCases; i++) {
            numberOfInputs[i] = Integer.parseInt(br.readLine());
            String n = br.readLine();
            String tempArray[] = n.split(" ");
            for (j = 0; j < numberOfInputs[i]; j++) {
                arrayToBeSorted[i][j] = Integer.parseInt(tempArray[j]);
            }
        }


        for (i = 0; i < numberOfTestCases; i++) {
            flag=0;
            for (j = 0; j < numberOfInputs[i]; j++) {
                for (k = 2; k < numberOfInputs[i] - j; k++) {
                    if (arrayToBeSorted[i][k - 2] > arrayToBeSorted[i][k]) {
                        //swap elements
                        temp = arrayToBeSorted[i][k - 2];
                        arrayToBeSorted[i][k-2] = arrayToBeSorted[i][k];
                        arrayToBeSorted[i][k] = temp;
                    }
                }


            }

            for (j=0;j<numberOfInputs[i]-1;j++)
            {
                if (arrayToBeSorted[i][j]>arrayToBeSorted[i][j+1])
                {
                    flag=1;
                    index = j;
                    break;
                }
            }if(flag==0)
            System.out.println("Case #" + (i+1) +": OK");
            else
                System.out.println("Case #" + (i+1) +": " + index);
        }
    }
}
