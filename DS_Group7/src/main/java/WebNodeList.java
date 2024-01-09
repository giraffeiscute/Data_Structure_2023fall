import java.util.ArrayList;

public class WebNodeList
{
	private ArrayList<WebNode> lst;

	public WebNodeList()
	{
		this.lst = new ArrayList<WebNode>();
	}

	public void add(WebNode webnode)
	{
		lst.add(webnode);
	}
	public int size(){
	
		return lst.size();
	}
	public WebNode get(int i){
		
		return lst.get(i);
	}
	
	//檢查是否整個list的score都是0
	public boolean is_zero(){
		int check_zero = 0;
        for (int i=0;i<lst.size();i++) {
			if (lst.get(i).nodeScore >0) {
				check_zero+=1;
			}
        }
        if (check_zero==0) {
        	return true;
        }
        else {
        	return false;
        }
	}
	public void sort()
	{
		if (lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else
		{
			quickSort(0, lst.size() - 1);
		}
	}

	
	private void quickSort(int leftbound, int rightbound)
	{
		if (leftbound >= rightbound ) {
		return;
		}
		else {
			int j = leftbound;
			int k = rightbound-1;
			Double pivot = lst.get(rightbound).nodeScore;
			while(j<k) {
				while (lst.get(j).nodeScore>=pivot & j <= k) {
					j+=1;
					}
				while(lst.get(k).nodeScore<pivot & j <= k &  k>0) {
					k-=1;
					}
				//System.out.println("SortError");
				//System.out.println(j+" and "+k);
				if(j<k) {
					swap(j, k);
			}
			}
			if (lst.get(j).nodeScore<pivot) {
				swap(j, rightbound);
			}
			quickSort(leftbound, j-1);
			quickSort(j+1, rightbound);
		}
	}

	private void swap(int aIndex, int bIndex)
	{
		WebNode temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
		//System.out.println(aIndex+" switch "+bIndex);
	}

	public void output()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("rank0: ");
		for (int i = 0; i < lst.size(); i++)
		{	
			//String k1 = lst.get(i).webPage.name;
			double k2 = lst.get(i).nodeScore;
			if (i > 0)
				sb.append(" rank"+i+": ");
			//sb.append(k1.toString());
			String s = String.format("%f", k2);
			sb.append(lst.get(i).webPage.name+" "+s);
		}

		System.out.println(sb.toString());
	}
}