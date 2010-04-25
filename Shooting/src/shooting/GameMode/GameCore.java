package shooting.GameMode;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.eachStage.*;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: </p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class GameCore
    extends Thread {
  public static final int NOTHING=-1;
  public static final int GAME_START=0;
  public static final int CONFIG=1;
  public static final int RANKING=2;
  public static final int EXIT = 3;

  protected int stageNumber; //ステージナンバー
  GameFrame GF;
  private int whatToDo;
  public GameCore(GameFrame gf) {
    this.stageNumber = 1; //最初のステージから
    this.GF = gf;
    //init();
  }
  /*
    public void init(){//描写開始
   while(true){
     Graphics g = GameFrame.getBuff().getDrawGraphics(); //グラフィック取得
     g.fillRect(0, 0, 400, 400);
     g.drawString("HelloWorld", 10, 10);
     GameFrame.getBuff().show();
     g.dispose();
     System.out.println("Hello");
   }
     }
   */
  /*ダブルバッファのテスト用ソース
    public void run(){
   long count = 0;
   while(true){
     count++;
     Graphics g = GameFrame.getBuff().getDrawGraphics(); //グラフィック取得
     if(!GameFrame.getBuff().contentsLost()){
       g.setColor(Color.white);
       g.fillRect(0, 0, GameFrame.Width, GameFrame.Height);
       g.setColor(Color.black);
       g.setFont(new Font("Helvetica", Font.PLAIN, 64));
       g.drawString("HelloWorld : " + count, 20, 200);
       GameFrame.getBuff().show();
       g.dispose();
       try{
         Thread.sleep(0);
       }catch(Exception e){}
     }
     //System.out.println("Hello");
   }
    }
   */
  public void run() { //いろいろモードに分けて実行します．
    this.waitForGameFrame(); //ゲームフレームが準備完了するまで待つ
    //基本的にはモード別スレッドを動かしてjoinとする
    while(true){
      Stage modeSelect = new ModeSelect(this);
      modeSelect.start();
      try {
        modeSelect.join();
      }
      catch (InterruptedException e) {}
      switch(whatToDo){
        case GameCore.GAME_START:
        Stage st = new SampleStage();
        st.start();
        try {
          st.join();
        }
        catch (InterruptedException e) {}
        break;
        case GameCore.EXIT:
        System.exit(0);
      }
    }
  }

  public synchronized void waitForGameFrame() {
    while (!GF.isReady()) {
      try {
        this.wait(10);
      }
      catch (InterruptedException e) {}
    }
  }

  public synchronized void wait2sec() {
      try {
        this.wait(2000);
      }
      catch (InterruptedException ie) {}
  }
  public void setWhatToDo(int code,int stage){
    whatToDo = code;
  }
}
