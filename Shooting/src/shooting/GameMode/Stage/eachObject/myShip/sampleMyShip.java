package shooting.GameMode.Stage.eachObject.myShip;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.*;
import shooting.GameMode.Stage.*;
import java.awt.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 自機01をあらわすクラスです．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class sampleMyShip
    implements chr {
  private static final int SPEED = GameFrame.Width /
      (int) (GameFrame.RefreshRate * 2);
  private int Damage = 1;
  private int noDamageCount = 0;
  private boolean isAlive = true;
  private boolean isVisible = true;
  private point Point = null;
  private Stage St;
  private int[] keyPressedTime = new int[GameFrame.KEY.length];
  private int keyPressedInterval = GameFrame.RefreshRate / 60; //このフレーム数以上入力しないと，動きません．
  private int shotInterval = 2; //このフレーム以上押してないとショットでません．
  private int shotTimeCount = 0; //何フレーム押したか
  private Color shipColor = new Color( (float) 0.3, (float) 0.3, (float) 1,
                                      (float) 0.7);
  private Color hitDispColor = new Color( (float) 1.0, (float) 0.3, (float) 0.3,
                                         (float) 0.7);
  public sampleMyShip(Stage stg) {
    /*ポイント製作．当たり判定，5ドット．*/
    Point = new point(point.getWidthSize() * 1 / 2,
                      point.getHeightSize() * 4 / 5, 5, 5);
    St = stg;
    noDamageCount = GameFrame.RefreshRate * 2; //2秒間無敵．
  }

  /**
   * 動かします（弾の発生含む）
   */
  public void Move() {
    if (noDamageCount >= 0) {
      noDamageCount--;
    }
    /**入力です．
     *   1:↑
     *   2:↓
     *   4:→
     *   8:←
     *  16:ボタン１
     *  32:ボタン２
     *  64:ボタン３
     */


    int speed = SPEED; //一応設定
    /*遅くなる機能実装のため，キー２だけ先に処理*/
    if ( (GameFrame.getInput() & 32) != 0) { //動きが遅くなります．
      speed /= 2;
    }

    /*あまりのキーの処理*/
    if ( (GameFrame.getInput() & 1) != 0) {
      keyPressedTime[0]++;
      if (keyPressedTime[0] >= keyPressedInterval) {
        keyPressedTime[0] = 0;
        movePoint(0, -speed);
      }
    }
    if ( (GameFrame.getInput() & 2) != 0) {
      keyPressedTime[1]++;
      if (keyPressedTime[1] >= keyPressedInterval) {
        keyPressedTime[1] = 0;
        movePoint(0, speed);
      }
    }
    if ( (GameFrame.getInput() & 4) != 0) {
      keyPressedTime[2]++;
      if (keyPressedTime[2] >= keyPressedInterval) {
        keyPressedTime[2] = 0;
        movePoint(speed, 0);
      }
    }
    if ( (GameFrame.getInput() & 8) != 0) {
      keyPressedTime[3]++;
      if (keyPressedTime[3] >= keyPressedInterval) {
        keyPressedTime[3] = 0;
        movePoint( -speed, 0);
      }
    }
    if ( (GameFrame.getInput() & 16) != 0) { //ショットを撃ちます．
      shot();
    }
    else {
      shotTimeCount = 0;
    }
  }

  /**
   * 自機を移動させます．
   * @param x int
   * @param y int
   */
  private void movePoint(int x, int y) {
    int changedX = Point.getX() + x;
    int changedY = Point.getY() + y;
    if (0 <= changedX && changedX + Point.getX_size() <= point.getWidthSize()) {
      Point.setX(changedX);
    }
    if (10 <= changedY &&
        changedY + Point.getY_size() <= point.getHeightSize() - 10) {
      Point.setY(changedY);
      //System.out.println("("+Point.getX()+","+Point.getY()+")");
    }
  }

  /**
   * 弾を撃ちます．
   */
  private void shot() {
    shotTimeCount++;
    if (shotTimeCount >= shotInterval) {
      shotTimeCount = 0;
      St.addObj(new myShot01(new point(Point.getCenterX() - 11,
                                       Point.getCenterY() - 30, 0, 0), St), 2);
      St.addObj(new myShot01(new point(Point.getCenterX() + 7,
                                       Point.getCenterY() - 30, 0, 0), St), 2);
    }
  }

  /**
   * そのキャラクタが死んでいるか否かのセット
   * @param flag boolean
   */
  public void setKilled(boolean flag) {
    isAlive = flag;
  }

  /**
   * 殺されているか否かの取得
   * @return boolean
   */
  public boolean isAlive() {
//    return true;
    return isAlive;
  }

  /**
   * 弾や自機を破棄します．
   */
  public void Destroy() {
    //破棄しません．
  }

  /**
   * そのキャラクタにダメージを加えます
   * @param damage int
   */
  public void addDamage(int damage) {
    if (noDamageCount < 0) {
      Damage -= damage;
    }
    if (Damage <= 0) {
      isAlive = false;
    }
  }

  /**
   * 残りシールドを返します
   * @return int
   */
  public int getDamege() {
    return Damage;
  }

  /**
   * 座標（と大きさ）を設定します
   * @param point point
   */
  public void setPoint(point point) {
    Point = point;
  }

  /**
   * 座標（と大きさ）を返します
   * @return point
   */
  public point getPoint() {
    return Point;
  }

  /**
   * 見えるようにするか，しないかを設定します
   * @param flag boolean
   */
  public void setVisible(boolean flag) {
    isVisible = flag;
  }

  /**
   * 見えているかの現在の状況を返します
   * @return boolean
   */
  public boolean getVisible() {
    return isVisible;
  }

  /**
   * 当たり判定を行います．
   * ダメージを与える判定のみを行います．
   * @param o object
   * @return boolean
   */
  public boolean judge(object o) {

    return false;
  }

  /**
   * 描写します．<br>
   * 注意：レイヤで扱うのでバッファをクリアしないこと！<br>
   * 0:ヒットディスプレイなし<br>
   * 1:ヒットディスプレイあり<br>
   * 2:ヒットディスプレイのみ<br>
   * @param g Graphics
   * @param isHitDisp int
   */
  public void draw(Graphics g, byte isHitDisp) {
    if (noDamageCount >= 0 && noDamageCount % 2 != 0) {
    }
    else {
        drawShip(g);
        drawHit(g);
    }
  }

  public void drawShip(Graphics g) {
    int centerX = point.getInFrameX(Point.getCenterX());
    int centerY = point.getInFrameY(Point.getCenterY());
    g.setColor(shipColor);
    int[] polygonX = {centerX - 10, centerX - 2, centerX - 13, };
    int[] polygonY = {centerY, centerY + 7, centerY +11 };
    g.drawPolygon(polygonX, polygonY, 3);

    int[] polygonX2 = {centerX + 10, centerX + 2, centerX + 13, };
    int[] polygonY2 = {centerY , centerY + 7, centerY + 11, };
    g.drawPolygon(polygonX2, polygonY2, 3);

    int[] polygonX3 = {centerX + 8, centerX - 8, centerX, };
    int[] polygonY3 = {centerY - 4, centerY - 4, centerY - 30, };
    g.drawPolygon(polygonX3, polygonY3, 3);
  }

  public void drawHit(Graphics g) {
    g.setColor(this.hitDispColor);
    g.fill3DRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size(),true);
  }

  /**
   * 所属するステージを返します．
   * @return Stage
   */
  public Stage getStage() {
    return St;
  }

  /**
   * 所属するステージを設定します．
   * @param stg Stage
   */
  public void setStage(Stage stg) {
    St = stg;
  }

  public int getCode() {
    return object.CODE_FRIEND_CHR;
  }
  public void setShipColor(Color color){
    shipColor = color;
  }
}
