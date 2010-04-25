package shooting.GameMode.Stage;

import java.util.*;
import shooting.GameMode.*;
import shooting.GameMode.Stage.basic.*;

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
public abstract class Stage extends Thread{
  public static final long INTERVAL = (1000 / GameFrame.RefreshRate) / 2;
  public static final int END_KEY_PRESSED_COUNT_INTERVAL = 30;
  public static final int NUMBER_OF_LAYERS = 7;//レイヤの数
  public static final int BACK = 0;
  public static final int LND = 1;
  public static final int FRIEND_BULL = 2;
  public static final int FRIEND_CHR = 3;
  public static final int ENEMY_CHR = 4;
  public static final int ENEMY_BULL = 5;
  public static final int SCORE = 6;
  /**
   * ここを呼んでスタートです．
   */
  public abstract void run();
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
  public abstract LinkedList[] getLayers();

  /**
   * オブジェクトを追加します．
   * 弾の発生時などに使います．
   * @param o Object
   * @param Layer int
   */
  public abstract void addObj(object o, int Layer);

  /**
   * 入力を返します
   *   1:↑
   *   2:↓
   *   4:→
   *   8:←
   *  16:ボタン１
   *  32:ボタン２
   *  64:ボタン３
   * @return boolean
   */
  public abstract byte getInput();

  /**
   * 自機の残機を返します．
   * @return int
   */
  public abstract int getShips();

  /**
   * 残機を増やしたり減らしたりします．
   * @param n int
   */
  public abstract void addShips(int n);

  /**
   * 自機のポイントを返します
   * @return point
   */
  public abstract point getShipPoint();

  /**
   * スコアを加えます．
   * @param score int
   */
  public abstract void addScore(int score);

  /**
   * スコアをもらいます．
   * @return int
   */
  public abstract int getScore();

  /**
   * オブジェクトの数を返します．
   * @return int
   */
  public abstract int getObjects();

  /**
   * ゲームオーバか否かを返します．
   * @return boolean
   */
  public abstract boolean isGameOver();
  /**
   * 今の時間を返します
   * @return long
   */
  public abstract long getNowTime();
  /**
   * フレームカウントを返します．
   * @return long
   */
  public abstract long getFrameCount();
  /**
   * ランクを返します
   * @return int
   */
  public abstract int getRank();
  }
