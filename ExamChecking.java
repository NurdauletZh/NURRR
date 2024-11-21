public class ExamChecking extends Thread {
    private static int examSheets = 500;
    private int maxIterations;

    public ExamChecking(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxIterations; i++) {
            synchronized (ExamChecking.class) {
                if (examSheets <= 0) {
                    System.out.println("There is no any exam sheet left! All papers were already checked!!!");
                    System.exit(0);
                }
                examSheets -= 50;
                System.out.println(Thread.currentThread().getName() + " finished checking, at: "
                        + java.time.LocalDateTime.now()
                        + ", exam sheet count is now " + examSheets);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExamChecking m = new ExamChecking(6);
        ExamChecking m2 = new ExamChecking(4);

        m.setName("Alibek");
        m2.setName("Dana");
        m2.setPriority(Thread.MAX_PRIORITY);

        m.start();
        m2.start();
    }
}
