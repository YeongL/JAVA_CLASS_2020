
public class TimerThread implements Runnable{
	private final int index;
	
	public TimerThread(int index)
	{
		this.index = index;
	}
	
	@Override
	public void run()
	{
		String stopwatch;//스톱워치에 사용할 문자열 변수
		MainScreen.timers[index].Lstopwatch.setVisible(true);//Lstopwatch가 보이지 않게 한다.
		while(true) {//무조건 실행
			
			
			if(MainScreen.timers[index].isActive) {//사용하지 않을때도 스톱워치가 작동하지 않게 하기 위해서 i를 선언했다.
				MainScreen.timers[index].stop++;//msec를 계속 더한다.(sleep가 100이기때문에 10까지만 카운트한다.)
				if(MainScreen.timers[index].stop>=10) { //10이상이면 실행 (10까지만 카운트)
					MainScreen.timers[index].stop=MainScreen.timers[index].stop-10; //10이 넘어가면 다시 0으로 만든다.
					MainScreen.timers[index].ssec++;} //초를 하나 올린다.	
				if(MainScreen.timers[index].ssec>=60) {//60이상이면 실행(60까지만 카운트)
					MainScreen.timers[index].ssec=MainScreen.timers[index].ssec-60;//60이상이면 60을 빼서 다시 0으로 만들어준다.
					MainScreen.timers[index].smin++;}//분을 올린다.
				if(MainScreen.timers[index].smin>=60) {//60이상이면 실행(60까지만 카운트)
					MainScreen.timers[index].smin=MainScreen.timers[index].smin-60;//60이상이면 60을 빼서 다시 0으로 만들어준다.
					MainScreen.timers[index].shour++;}//시간을 올린다. 사실상 몇시간이상 사용할일이 없다고 판단해서 시간의 제한은 넣지않았다.
			}
			
			stopwatch=(String.format("%02d", MainScreen.timers[index].shour)+":"+String.format("%02d", MainScreen.timers[index].smin)+":"+String.format("%02d", MainScreen.timers[index].ssec));//스톱워치의 데이트를 문자열로 만든다
			MainScreen.timers[index].Lstopwatch.setText(stopwatch);//Lstopwatch를 stopwatch(string)으로 설정해준다.
			MainScreen.timers[index].listnum = stopwatch;
			
//			timers[index].timerPanel.add(timers[index].Lstopwatch);//Lstopwatch를 프레임에 추가한다.
			try { //트라이 
				Thread.sleep(100);//0.1초
		    } catch(Exception e) {} //예외처리
		}
		
	}

}
