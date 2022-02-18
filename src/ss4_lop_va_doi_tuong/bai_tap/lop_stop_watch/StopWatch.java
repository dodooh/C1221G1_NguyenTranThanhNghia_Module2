package ss4_lop_va_doi_tuong.bai_tap.lop_stop_watch;

import java.util.Date;

public class StopWatch {
    // UML diagram
    /*******************************************
     *                 StopWatch               *
     -------------------------------------------
     * -startTime : long                       *
     * -endTime: long                          *
     * +StopWatch()                            *
     * +getStartTime(): long                   *
     * +getEndTime(): long                     *
     * +start(): long                          *
     * +stop(): long                           *
     * +getElapsedTime(): long                 *
     ******************************************/
    private long startTime;
    private long endTime;

    StopWatch() {
        Date date = new Date();
        startTime = date.getTime();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void start() {
        Date date = new Date();
        startTime = date.getTime();
    }

    public void stop() {
        Date date = new Date();
        endTime = date.getTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}
