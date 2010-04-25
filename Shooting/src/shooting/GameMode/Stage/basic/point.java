package shooting.GameMode.Stage.basic;

import shooting.GameMode.*;
import java.util.Random;
import shooting.GameMode.Stage.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 座標(とサイズ)を表すオブジェクトです</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class point {
  private int X;
  private int Y;
  private int X_size;
  private int Y_size;

  /**
   * 同じ時間に初期化すると，同じ結果しか返しません．
   * よって「static」宣言をすること！
   * またひとつ頭よくなったね☆
   */
  private static Random rnd = new Random(); //ランダム要素を加えます．

  /**
   * 座標を作成します．
   * @param x int
   * @param y int
   * @param x_size int
   * @param y_size int
   */
  public point(int x, int y, int x_size, int y_size) {
    X = x;
    Y = y;
    X_size = x_size;
    Y_size = y_size;
  }

  /**
   * 左上座標のX座標を設定します．
   * @param x int
   */
  public void setX(int x) {
    X = x;
  }

  /**
   * 左上座標のX座標を返します．
   * @return int
   */
  public int getX() {
    return X;
  }

  /**
   * 左上座標のY座標を設定します．
   * @param y int
   */
  public void setY(int y) {
    Y = y;
  }

  /**
   * 左上座標のY座標を返します．
   * @return int
   */
  public int getY() {
    return Y;
  }

  /**
   * X座標のサイズを設定します
   * @param x_size int
   */
  public void setX_size(int x_size) {
    this.X_size = x_size;
  }

  /**
   * X座標のサイズを返します
   * @return int
   */
  public int getX_size() {
    return X_size;
  }

  /**
   * Y座標のサイズを設定します
   * @param y_size int
   */
  public void setY_size(int y_size) {
    this.Y_size = y_size;
  }

  /**
   * Y座標のサイズを返します
   * @return int
   */
  public int getY_size() {
    return Y_size;
  }

  /**
   * 右下座標のX座標を返します
   * @return int
   */
  public int get_endX() {
    return X + X_size;
  }

  /**
   * 右下座標のY座標を返します
   * @return int
   */
  public int get_endY() {
    return Y + Y_size;
  }

  /**
   * フレーム内でのX座標を返します．
   * 16:9を考えてます．
   * @return int
   */
  public int getXinFrame() {
    return X + ( (GameFrame.Width - (GameFrame.Height * 9 >> 4)) >> 1);
  }

  /**
   * フレーム内でのY座標を返します．
   * @return int
   */
  public int getYinFrame() {
    return Y;
  }

  /**
   * フレーム内での右下座標のX座標を返します
   * @return int
   */
  public int get_endXinFrame() {
    return getXinFrame() + X_size;
  }

  /**
   * フレーム内での右下座標のY座標を返します
   * @return int
   */
  public int get_endYinFrame() {
    return getYinFrame() + Y_size;
  }

  /**
   * ゲーム画面のX座標のサイズを返します．
   * @return int
   */
  public static int getWidthSize() {
    return (GameFrame.Height * 9) >> 4;
  }

  /**
   * ゲーム画面のY座標のサイズを返します．
   * @return int
   */
  public static int getHeightSize() {
    return GameFrame.Height;
  }

  /**
   * ゲームの画面エリアが始まるX座標を返します．
   * @return int
   */
  public static int getGameAreaStartX() {
    return (GameFrame.Width - getWidthSize()) >> 1;
  }

  /**
   * ゲームの画面エリアが始まるY座標を返します．
   * @return int
   */
  public static int getGameAreaStartY() {
    return (GameFrame.Height - getHeightSize()) >> 1;
  }

  /**
   * ゲームの画面エリアが終わるX座標を返します．
   * @return int
   */
  public static int getGameAreaEndX() {
    return getGameAreaStartX() + getWidthSize();
  }

  /**
   * ゲームの画面エリアが終わるY座標を返します．
   * @return int
   */
  public static int getGameAreaEndY() {
    return getGameAreaStartY() + getHeightSize();
  }

  /**
   * X座標の中心を返します．
   * @return int
   */
  public int getCenterX() {
    return getX() + (getX_size() >> 1);
  }

  /**
   * Y座標の中心を返します
   * @return int
   */
  public int getCenterY() {
    return getY() + (getY_size() >> 1);
  }

  /**
   * 中心の座標を設定します．
   * @param x int
   */
  public void setCenterX(int x) {
    X = x - (X_size >> 1);
  }

  /**
   * 中心の座標を設定します．
   * @param y int
   */
  public void setCenterY(int y) {
    Y = y - (Y_size >> 1);
  }

  /**
   * X座標をフレーム内での話に変換します．
   * @param x int
   * @return int
   */
  public static int getInFrameX(int x) {
    return x + getGameAreaStartX();
  }

  /**
   * Y座標をフレーム内での話に変換します．
   * @param y int
   * @return int
   */
  public static int getInFrameY(int y) {
    return y + getGameAreaStartY();
  }

  /**
   * 角度をずらした方向を作ります．
   * @param angle float
   * @param isAngleRandom boolean
   * @param oldDirection float[]
   * @param isSpeedRandom boolean
   * @return float[]
   */
  public static float[] getNewDirection(float angle,boolean isAngleRandom,float[] oldDirection,boolean isSpeedRandom) {
    if(isAngleRandom){
      angle = (float)(angle * (rnd.nextFloat() * 2 - 1));
    }
    float rad = (float)(Math.PI / 180 * angle);
    float cos = (float)Math.cos(rad);
    float sin = (float)Math.sin(rad);
    float Direction[] = new float[2];
    Direction[0] = (float)(oldDirection[0]*cos - oldDirection[1] * sin);
    Direction[1] = (float)(oldDirection[0]*sin + oldDirection[1] * cos);
    if(isSpeedRandom){
      float Speed = (float)(rnd.nextFloat()+ 0.5);
      Direction[0] *= Speed;
      Direction[1] *= Speed;
    }
    return Direction;
  }

  /**
   * 角度から方向を求めます．
   * @param angle float
   * @param Speed float
   * @param isSpeedRandom boolean
   * @return float[]
   */
  public static float[] getDirection(float angle,float Speed,boolean isSpeedRandom) {
    if(isSpeedRandom){
      Speed = (float)( Speed * (rnd.nextFloat() * 2 - 1));
    }
    float Direction[] = new float[2];
    float rad = (float)(Math.PI / 180 * angle);
    Direction[0] = (float) Math.cos(rad) * Speed;
    Direction[1] = (float) Math.sin(rad) * Speed;
    return Direction;
  }
  /**
   * 自機への方向を求めます
   * @param isGameOver boolean
   * @param bullPoint point
   * @param stg Stage
   * @param Speed float
   * @param isSpeedRandom boolean
   * @return float[]
   */

  public static float[] getDirectionToShip(boolean isGameOver,point bullPoint,Stage stg,float Speed,boolean isSpeedRandom) {
    if(isSpeedRandom){
      Speed = (float)( Speed * (rnd.nextFloat() + 0.5));
    }
    if (!isGameOver) { //ゲームオーバーでないなら
      float d = 0;
      int X = stg.getShipPoint().getCenterX() -
          bullPoint.getCenterX();
      d += X * X;
      int Y = stg.getShipPoint().getCenterY() -
          bullPoint.getCenterY();
      d += Y * Y;
      d = (float) Math.sqrt(d);
      if (d > 0) {
        float[] dir = {
            ( (X / d) * Speed), (Y / d * Speed)};
        return dir;
      }
      else {
        float[] dir = {
            0, Speed};
        return dir;
      }
    }
    else {
      float dir[] = {
          (float) 0, (float) Speed};
      return dir;
    }
  }
}
