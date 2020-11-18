
public class TimerThread implements Runnable{
	private final int index;
	
	public TimerThread(int index)
	{
		this.index = index;
	}
	
	@Override
	public void run()
	{
		String stopwatch;//�����ġ�� ����� ���ڿ� ����
		MainScreen.timers[index].Lstopwatch.setVisible(true);//Lstopwatch�� ������ �ʰ� �Ѵ�.
		while(true) {//������ ����
			
			
			if(MainScreen.timers[index].isActive) {//������� �������� �����ġ�� �۵����� �ʰ� �ϱ� ���ؼ� i�� �����ߴ�.
				MainScreen.timers[index].stop++;//msec�� ��� ���Ѵ�.(sleep�� 100�̱⶧���� 10������ ī��Ʈ�Ѵ�.)
				if(MainScreen.timers[index].stop>=10) { //10�̻��̸� ���� (10������ ī��Ʈ)
					MainScreen.timers[index].stop=MainScreen.timers[index].stop-10; //10�� �Ѿ�� �ٽ� 0���� �����.
					MainScreen.timers[index].ssec++;} //�ʸ� �ϳ� �ø���.	
				if(MainScreen.timers[index].ssec>=60) {//60�̻��̸� ����(60������ ī��Ʈ)
					MainScreen.timers[index].ssec=MainScreen.timers[index].ssec-60;//60�̻��̸� 60�� ���� �ٽ� 0���� ������ش�.
					MainScreen.timers[index].smin++;}//���� �ø���.
				if(MainScreen.timers[index].smin>=60) {//60�̻��̸� ����(60������ ī��Ʈ)
					MainScreen.timers[index].smin=MainScreen.timers[index].smin-60;//60�̻��̸� 60�� ���� �ٽ� 0���� ������ش�.
					MainScreen.timers[index].shour++;}//�ð��� �ø���. ��ǻ� ��ð��̻� ��������� ���ٰ� �Ǵ��ؼ� �ð��� ������ �����ʾҴ�.
			}
			
			stopwatch=(String.format("%02d", MainScreen.timers[index].shour)+":"+String.format("%02d", MainScreen.timers[index].smin)+":"+String.format("%02d", MainScreen.timers[index].ssec));//�����ġ�� ����Ʈ�� ���ڿ��� �����
			MainScreen.timers[index].Lstopwatch.setText(stopwatch);//Lstopwatch�� stopwatch(string)���� �������ش�.
			MainScreen.timers[index].listnum = stopwatch;
			
//			timers[index].timerPanel.add(timers[index].Lstopwatch);//Lstopwatch�� �����ӿ� �߰��Ѵ�.
			try { //Ʈ���� 
				Thread.sleep(100);//0.1��
		    } catch(Exception e) {} //����ó��
		}
		
	}

}
