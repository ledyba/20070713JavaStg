package shooting.GameMode.Stage.eachStage;

import shooting.GameMode.Stage.Stage;
import shooting.GameMode.*;
import shooting.GameMode.Stage.eachObject.back.*;
import shooting.GameMode.Stage.basic.object;
import java.util.LinkedList;
import java.util.*;
import java.awt.*;
import shooting.GameMode.Stage.basic.point;
import shooting.GameMode.Stage.basic.chr;

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
public class ModeSelect
    extends Stage {
  private LinkedList[] Layers;
  private int Objects = 0;
  private int whatToDo = GameCore.NOTHING;;
  private int nextStage;
  private Timer timer;
  private TimerTask task;
  boolean modeEndFlag = false;
  private long frameCount = 0;
  private GameCore gc;
  public ModeSelect(GameCore gc) {
    super();
    this.gc = gc;
    modeEndFlag = false;
  }

  public void run() {
    task = new TimerTask() {
      public void run() {
        if(whatToDo != GameCore.NOTHING){
          switch(whatToDo){
            case GameCore.GAME_START:
            case GameCore.EXIT:
              gc.setWhatToDo(whatToDo,0);
              modeEndFlag = true;
              break;
            case GameCore.RANKING:
            case GameCore.CONFIG:
              whatToDo = GameCore.NOTHING;
              break;
            default:
          }
        }else{
          frameCount++;
          //終わるときはmodeEndFlagをたてるだけ．
          Graphics g = GameFrame.getBuff().getDrawGraphics(); //グラフィック取得
          /*動かします*/
          for (int i = 0; i < Layers.length; i++) {
            Iterator it = Layers[i].listIterator();
            while (it.hasNext()) {
              ( (object) (it.next())).Move();
            }
          }
          /*生死の判定です*/
          for (int i = 1; i <= Stage.ENEMY_CHR; i++) {
            Iterator it = Layers[i].listIterator();
            while (it.hasNext()) {
              chr obj = (chr) it.next();
              if (! (obj.isAlive())) { //死んでいるなら，削除します．
                Objects--;
                it.remove();
              }
            }
          }
          /*描きます*/
          for (int i = 0; i < Layers.length; i++) {
            Iterator it = Layers[i].listIterator();
            while (it.hasNext()) {
              ( (object) (it.next())).draw(g, (byte) 3);
            }
          }
          GameFrame.getBuff().show(); //見せる
        }
      }
    };
    timer = new Timer();
    initFirst();//初期化して
    timer.schedule(task, 0, Stage.INTERVAL);//処理開始
    this.setPriority(MIN_PRIORITY);//待機するだけなので
    while (!modeEndFlag) {
      wait10ms();
    }
    task.cancel();
  }
  /**
   * 最初に使われる初期化です．
   */
  private void initFirst(){
    whatToDo = GameCore.NOTHING;
    Layers = new LinkedList[NUMBER_OF_LAYERS];
    for (int i = 0; i < Layers.length; i++) {
      Layers[i] = new LinkedList();
    }
    addObj(new FillBlack(), Stage.BACK);
    addObj(new DrawLine(), Stage.BACK);
    addObj(new Score(this), Stage.SCORE);
    addObj(new ModeSelect_Title(),Stage.FRIEND_CHR);
    addObj(new ModeSelect_Menu(this),Stage.FRIEND_CHR);
  }
  private synchronized void wait10ms(){
    try {
      wait(10);
    }
      catch (InterruptedException e) {}
  }
  /**
   *
   * @param o Object
   * @param Layer int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public void addObj(object o, int Layer) {
    Objects++;
    Layers[Layer].addLast(o);
  }

  /**
   *
   * @param score int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public void addScore(int score) {
  }

  /**
   *
   * @param n int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public void addShips(int n) {
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public byte getInput() {
    return GameFrame.getInput();
  }

  /**
   *
   * @return LinkedList[]
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public LinkedList[] getLayers() {
    return Layers;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public int getObjects() {
    return 0;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public int getScore() {
    return 0;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public point getShipPoint() {
    return null;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public int getShips() {
    return 0;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.Stage メソッドを実装
   */
  public boolean isGameOver() {
    return false;
  }
  public long getFrameCount(){
    return frameCount;
  }
  public int getRank(){
    return 0;
  }
  public long getNowTime() {
    return (new Date().getTime());
  }
  public void setWhatToDo(int Code,int stage){
    whatToDo = Code;
    nextStage = stage;
  }

}
