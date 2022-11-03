import java.util.ArrayList;

/**
 * @author Rom Harel Noy Biton
 * Class Shared Data  - Define the data that the threads share's
 *
 */
public class SharedData 
{
	private ArrayList<Integer> array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/**
	 * @param array 
	 * @param b
	 * 
	 * constructor 
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**
	 * @return
	 * getter
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * @param winArray
	 * getter
	 */
	public void setWinArray(boolean [] winArray) {
		this.winArray = winArray;
	}

	/**
	 * @return
	 * getter for array
	 */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}

	/**
	 * @return
	 * getter for b
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return]
	 * getter for flag
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * @param flag
	 * setter for flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
