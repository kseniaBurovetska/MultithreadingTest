package baker_task.task_standart;

public class Bread {

    private boolean isReady = false;
    private int count = 10;

    boolean isReady(){
        return isReady;
    }

    void setReady(boolean isReady){
        this.isReady = isReady;
    }

    int count(){
        return count;
    }

    void decreaseCount(){
        count--;
    }
}
