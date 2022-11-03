import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rom Harel
 * 
 * The program shows how, with the help of two threads, you can perform 2
The tests on the 1-an organ (and only it) at the same time when:
1. The first one who finds a solution reports to the second thread that it is a solution
available.
2. Each thread checks if the other thread found a solution at all
Performing a recursive call.
3. When a thread finds a solution, it reports through a complete array or
Boolean chosen which members are in the solution.
4. From the moment one of the threads finds a solution and starts writing it down
The second thread will not write about the solution either.


The solution relies on the fact that exactly two threads will be executed.
 *
 */
public class TestThreadCheckArray {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			Thread thread1, thread2;
			System.out.println("Enter array size");
			int num  = input.nextInt();
			ArrayList<Integer> array = new ArrayList<>();
			System.out.println("Enter numbers for array");
			
			for (int index = 0; index < num; index++) 
				array.add(index, input.nextInt());
			
			System.out.println("Enter number");
			num = input.nextInt();
			
			SharedData sd = new SharedData(array, num);
			
			thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
			thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
			thread1.start();
			thread2.start();
			try 
			{
				thread1.join();
				thread2.join();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (!sd.getFlag())
			{
				System.out.println("Sorry");
				return;
			}
			System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().size());
			System.out.print("I:    ");
			for(int index = 0; index < sd.getArray().size() ; index++)
				System.out.print(index + "    ");
			System.out.println();
			System.out.print("A:    ");
			for (int index : sd.getArray())
			{
				System.out.print(index);
				int counter = 5;
				while (true)
				{
					index = index / 10;
					counter--;
					if (index == 0)
						break;
				}
				for (int i = 0; i < counter; i++)
					System.out.print(" ");
			}

			System.out.println();
			System.out.print("C:    ");
			for (boolean index : sd.getWinArray())
			{
				if (index)
					System.out.print("1    ");
				else
					System.out.print("0    ");	
			}
		}
	}

}
