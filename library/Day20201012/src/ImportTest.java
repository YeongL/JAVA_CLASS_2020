import java.text.SimpleDateFormat;
import java.util.Date;
class ImportTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		System.out.println(date.format(today));
		System.out.println(time.format(today));
	}

}
