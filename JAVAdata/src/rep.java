import java.util.Timer;
import java.util.TimerTask;

public class rep {
	
	
	if(date == date) {
	
		static int x = 0;
	
		public static void main(String[] args) {
	
			//
			Timer timer = new Timer();
		
			TimerTask tarea = new TimerTask() {
				@Override
				public void run() {
					System.out.println("Time: " + x);
					x = x +1 ;
				}		
			};
	
			// This is to say how much time 
			timer.schedule(tarea, 0,1000);
		
		}
	
	}
	
}



