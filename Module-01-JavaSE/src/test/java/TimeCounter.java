public class TimeCounter {

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public TimeCounter() {
    }

    long endTime;

    public long start() {
        long stratTime = System.currentTimeMillis();
        return stratTime;
    }


    public void end(long startTime) {
        setEndTime(System.currentTimeMillis());
        System.out.println("Total time: "+(getEndTime()-startTime));
    }
}
