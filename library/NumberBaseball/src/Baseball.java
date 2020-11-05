class Baseball{
	private int casenum;
	
	Baseball()
	{
		
	}
	
	void setNum(int num)
	{
		this.casenum = num;
	}
	
	int getNum()
	{
		return this.casenum;
	}
	
	int[] makeRand()
	{
		int[] arr = new int[this.casenum];
		for(int i=0;i<arr.length;i++)
		{
			int tmp = 0;
			arr[i] = (int)(Math.random()*9)+1;
			while(tmp<i)
			{
				if(arr[tmp] == arr[i])
				{
					arr[i] = (int)(Math.random()*9)+1;
				}
				else
				{
					tmp++;
				}
			}
		}
		
		return arr;
	}
}