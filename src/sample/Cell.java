package sample;

public class Cell {
    private int mines;
    Cell(int x, int y, boolean mine, boolean visibility, boolean flag){
        this.mine = mine;
        this.visibility = visibility;
        this.flag = flag;
        this.x = x;
        this.y = y;
    }

    private boolean mine;
    private boolean visibility;
    private boolean flag;
    private int x;
    private int y;



    public boolean getVisibility(){
        return visibility;
    }

    public boolean getFlag(){
        return flag;
    }

    public boolean getMine(){
        return mine;
    }

    public void setVisible(){
        if(!visibility) visibility = true;
    }

    public void setFlag(){
        flag = !flag;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
