package chapter05;

class StudyNotes implements Runnable{

	private static int notes = 80;
	
	@Override
	public void run() {
		while (true) {
			if (notes > 0) {
				Thread thread = Thread.currentThread();
				String th_name = thread.getName();
				System.out.println(th_name + "正在发倒数第" + notes-- + "本读书笔记");
			}
			
		}
	}
	
}


public class Test03 {

	public static void main(String[] args) {
		
		StudyNotes studyNotes = new StudyNotes();
		
		new Thread(studyNotes, "老师1").start();
		new Thread(studyNotes, "老师2").start();
		new Thread(studyNotes, "老师3").start();
	}

}
