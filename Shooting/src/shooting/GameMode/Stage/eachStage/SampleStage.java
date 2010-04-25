package shooting.GameMode.Stage.eachStage;

import shooting.GameMode.*;
import java.util.*;
import java.awt.*;
import shooting.GameMode.Stage.eachObject.myShip.*;
import shooting.GameMode.Stage.eachObject.back.*;
import shooting.GameMode.Stage.eachObject.enemy.*;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.enemyBorn;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: サンプルステージです．テスト用．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class SampleStage
    extends shooting.GameMode.Stage.Stage {
  private LinkedList[] Layers;
  private Graphics g;
  private int Ships = 3; //残機数は３
  private int Score = 0;
  private boolean endFlag = false;
  private int Objects = 0;
  private long nowTime; //今の時間
  private boolean isAlive = true; //自機が生きているか，死んでいるか
  private int endKeyPressedCount; //終了してから，「Press shot Button」の表示が出るまで
  private boolean endKeyState = false; //一回ニュートラルになってから，再度押すこと．
  private chr myShip; //自機を保存しておく．もちろん，LinkedListにものせるよ．
  private long frameCount = 0;
  private boolean isGameOver = false;
  private Random rnd = new Random();
  private enemyBorn enemy = new enemyBornSample(this);
  public SampleStage() {
    setPriority(MAX_PRIORITY);//優先度は最高に設定しておきます．
    endKeyPressedCount = this.END_KEY_PRESSED_COUNT_INTERVAL;
    Layers = new LinkedList[NUMBER_OF_LAYERS];
    for (int i = 0; i < Layers.length; i++) {
      Layers[i] = new LinkedList();
    }
  }

  /**
   * 主にフレーム管理．実際のゲームに関しては別の方で行います．
   */
  public void run() {
    gameInit(); //ゲーム開始処理
    nowTime = getNowTime();
    while (!endFlag) {
      frameCount++; //フレームを１すすめる
      g = GameFrame.getBuff().getDrawGraphics(); //グラフィック取得
      if (!GameFrame.getBuff().contentsLost()) {
        game(); //ゲームの実際の処理（１フレーム分）
        if (endKeyPressedCount <= 0) {
          if ( (GameFrame.getInput() & 16) == 0) {
            endKeyState = true;
          }
          if (endKeyState) {
            if ( (GameFrame.getInput() & 16) != 0) {
              //ゲーム終了
              end();
            }
          }
        }
        frameWait(); //描写を待ちます
        GameFrame.getBuff().show(); //見せる
//        g.dispose(); //廃棄
        nowTime = getNowTime();
      }
    }
  }

  /**
   * ゲーム開始の処理
   */
  private void gameInit() {
    this.addObj(new FillBlack(), this.BACK);
    //this.addObj(new DrawLine(), this.BACK);
    this.addObj(new DrawStar(), this.BACK);
    this.addObj(new Score(this), this.SCORE);
    myShipBorn();
  }

  /**
   * 実際のゲームの処理（１フレーム分）
   */
  private void game() {
    enemy.run();//敵の発生
    deadCheck(); //自機が死んでしまったかどうかのチェックです．
//    enemy
    /*動かします*/
    for (int i = 0; i < Layers.length; i++) {
      Iterator it = Layers[i].listIterator();
      while (it.hasNext()) {
        ( (object) (it.next())).Move();
      }
    }
    /*当たり判定*/

    if (!isGameOver) { //ゲームオーバーなら判定しない
      Iterator it = Layers[this.ENEMY_BULL].listIterator(); //敵弾と
      while (it.hasNext()) {
        object obj = (object) it.next();
        obj.judge(myShip); //自機
      }
    }
    Iterator it2 = Layers[this.FRIEND_BULL].listIterator(); //自弾と
    while (it2.hasNext()) {
      object obj = (object) it2.next();
      Iterator it3 = Layers[this.ENEMY_CHR].listIterator(); //敵機
      while (it3.hasNext()) {
        object obj2 = (object) it3.next();
        obj.judge(obj2);
      }
    }
    /*生死の判定です*/
    for (int i = this.FRIEND_BULL; i <= this.ENEMY_BULL; i++) {
      Iterator it = Layers[i].listIterator();
      while (it.hasNext()) {
        chr obj = (chr) it.next();
        if (! (obj.isAlive())) { //死んでいるなら，削除します．
          obj.Destroy(); //ここでスコアなり何なりしてください．
          if (obj.getCode() == object.CODE_FRIEND_CHR) {
            this.isAlive = false;
          }
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
  }

  private void end() {
    endFlag = true;
  }

  public long getNowTime() {
    return (new Date().getTime());
  }

  /**
   * 次のフレームに移るまで待機します．
   */
  private synchronized void frameWait() {
    float interval = INTERVAL;
    /*
    int obj = this.getObjects();
    if (obj > 150) {
      interval += INTERVAL;
      if (obj > 200) {
        interval += INTERVAL;
      }
    }*/
    while ( (getNowTime() - nowTime) < interval) { //１フレーム分時間が経過するまで，まつ．
      try {
        wait(1);
      }
      catch (InterruptedException e) {}

    }
  }

  /**
   * 自機を生みます．
   */
  private void myShipBorn() {
    addShips( -1);
    this.addObj(myShip = new myShip01(this), this.FRIEND_CHR);
  }

  /**
   * 自機が死んだかどうかのチェックです．
   */
  private void deadCheck() {
    if (!isAlive) { //自機なし
      if (getShips() > 0) { //残機があるなら
        deleteAllObject(this.ENEMY_BULL); //弾をけします．
        deleteAllObject(this.ENEMY_CHR); //敵を消します
        myShipBorn();
        isAlive = true;
      }
      else { //ゲームオーバーです
        if (!isGameOver) { //まだゲームオーバーでない
          Layers[this.SCORE].add(new GameOver(this)); //ゲームオーバーレイヤ
          isGameOver = true;
        }
        else {
          if (endKeyPressedCount >= 0) {
            endKeyPressedCount--;
          }
        }
      }
    }
  }

  private void deleteAllObject(int Layer) {
    Objects -= Layers[Layer].size();
    Layers[Layer] = null;
    Layers[Layer] = new LinkedList();
  }

  /**
   * 敵等を生みます
   */
  /*
  public void enemyBorn() {
    this.addObj( (new enemy01(this,new point(point.getWidthSize() >> 2, -10 , 0, 0))),this.ENEMY_CHR);
    this.addObj( (new enemy01(this,new point((point.getWidthSize() >> 2) * 3, -10 , 0, 0))),this.ENEMY_CHR);

      case 1:
        this.addObj( (new enemy01(this,
                                  new point(rnd.nextInt(point.
            getWidthSize()), rnd.nextInt(point.getHeightSize() / 2), 0, 0))),
                    this.ENEMY_CHR);
        break;
      case 2:
        this.addObj( (new enemy02(this,
                                  new point(rnd.nextInt(point.
            getWidthSize()), rnd.nextInt(point.getHeightSize() / 2), 0, 0))),
                    this.ENEMY_CHR);
    }
  }*/

  /**
   * オブジェクトの入ったリンクリストを返します
   * [0]:back
   * [1]:lnd
   * [2]:friend_bull
   * [3]:friend_chr
   * [4]:enemy_bull
   * [5]:enemy_chr
   * [6]:score
   * @return LinkedList[]
   */
  public LinkedList[] getLayers() {
    return Layers;
  }

  /**
   * 入力を返します
   * @return byte
   */
  public byte getInput() {
    return GameFrame.getInput();
  }

  /**
   * 残機を返します
   * @return int
   */
  public int getShips() {
    return Ships;
  }

  /**
   * 残機を増やしたり減らしたり．
   * @param n int
   */
  public void addShips(int n) {
    Ships += n;
  }

  /**
   * オブジェクトを追加します．
   * 弾の発生時などに使います．
   * @param o Object
   * @param Layer int
   */
  public void addObj(object o, int Layer) {
    if (o.getCode() == object.CODE_ENEMY_CHR ||
        o.getCode() == object.CODE_ENEMY_BULL) {
      if (Objects < 245) {
//      if (Objects < 3000) {
        Objects++;
        Layers[Layer].addLast(o);
      }
    }
    else {
      Objects++;
      Layers[Layer].addLast(o);
    }
  }

  public point getShipPoint() {
    return myShip.getPoint();
  }

  /**
   * スコアを加えます．
   * @param score int
   */
  public void addScore(int score) {
    Score += score;
  }

  /**
   * スコアをもらいます．
   * @return int
   */
  public int getScore() {
    return Score;
  }

  public int getObjects() {
    return Objects;
  }

  public boolean isGameOver() {
    return isGameOver;
  }
  public long getFrameCount(){
    return frameCount;
  }
  /**
   * ランクを返します
   * @return int
   */
  public int getRank(){
    return (int)(frameCount / 600);
  }
}
