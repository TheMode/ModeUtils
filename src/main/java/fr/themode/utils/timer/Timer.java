package fr.themode.utils.timer;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Timer {

    private TimerRunnable runnable;

    private CopyOnWriteArrayList<Task> taskList;

    private Thread timerThread;

    private int currentTask;

    public Timer() {
        this.runnable = new TimerRunnable(this);
        this.taskList = new CopyOnWriteArrayList<>();
        this.timerThread = new Thread(runnable);
    }

    public void start() {
        this.timerThread.start();
    }

    public void stop() {
        this.runnable.stop();
    }

    public int addTimerTask(Runnable runnable, int time) {
        int id = currentTask++;
        taskList.add(new Task(id, runnable, time, 0));

        return id;
    }

    public int addRepeatingTask(Runnable runnable, int firstRun, int schedule) {
        int id = currentTask++;
        taskList.add(new Task(id, runnable, firstRun, schedule));

        return id;
    }

    public int addRepeatingTask(Runnable runnable, int schedule) {
        return addRepeatingTask(runnable, schedule, schedule);
    }

    public Task getTask(int task) {
        for (Task t : taskList) {
            if (t.getID() == task)
                return t;
        }
        return null;
    }

    public void removeTask(int task) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getID() == task) {
                taskList.remove(i);
                return;
            }
        }
    }

    public void reset() {
        taskList.clear();
    }

    // Runnable
    private class TimerRunnable implements Runnable {

        private Timer timer;
        private volatile boolean exit = false;

        public TimerRunnable(Timer timer) {
            this.timer = timer;
        }

        @Override
        public void run() {
            while (!exit) {
                update();
            }
        }

        public void stop() {
            exit = true;
        }

        private void update() {
            long currentTime = System.currentTimeMillis();

            Iterator<Task> iterator = taskList.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (!task.started) {
                    if (currentTime - task.time >= task.getFirstRun()) {
                        task.getRunnable().run();
                        if (task.getScheduleTime() == 0) {
                            removeTask(task.getID());
                        } else {
                            task.time = currentTime;
                            task.started = true;
                        }
                    }
                } else {
                    if (currentTime - task.time > task.getScheduleTime()) {
                        task.getRunnable().run();
                        task.time = currentTime;
                    }
                }

            }
        }

    }

}
