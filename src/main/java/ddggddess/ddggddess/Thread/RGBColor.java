package ddggddess.ddggddess.Thread;

public class RGBColor implements Runnable{
    public Thread t1 = new Thread(this);
    public boolean isStop = false;
    int r = 256;
    int g = 30;
    int b = 30;
    boolean state1 = true;
    boolean state2 = false;
    boolean state3 = false;

    public int getB() {
        return b;
    }
    public int getG() {
        return g;
    }
    public int getR() {
        return r;
    }
    public String getHexColor(){
        String redStr = Integer.toHexString(r);
        String greenStr = Integer.toHexString(g);
        String blueStr = Integer.toHexString(b);
        if(redStr.length() == 1){
            redStr = "0" + redStr;
        }
        if(greenStr.length() == 1){
            greenStr = "0" + greenStr;
        }
        if(blueStr.length() == 1){
            blueStr = "0" + blueStr;
        }
        return ("#" + redStr + greenStr + blueStr).toUpperCase();
    }
    @Override
    public void run() {
        while (!isStop){
            try {
                Thread.sleep(1000/40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(state1){
                r--;
                g++;
                if(r==30&&g==256){
                    state1 = false;
                    state2 = true;
                }
            }
            if(state2){
                g--;
                b++;
                if(g==30&&b==256){
                    state2 = false;
                    state3 = true;
                }
            }
            if(state3){
                b--;
                r++;
                if(b==30&&r==256){
                    state3 = false;
                    state1 = true;
                }
            }
        }
    }
    public void start(){
        t1.start();
    }
    public void stop(){
        this.isStop = true;
    }
}
