package shooting.GameMode.Stage.eachObject;

import java.awt.*;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.Stage;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: サンプルショットといいつつ，自機の弾だったりします．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class sampleShot
    implements bull {
  private point Point;
  private int[] hitArea = {
      5, 30};
  private boolean isAlive = true;
  private int Speed = 45;
  private boolean isVisible = true;
  private Stage St;
  private Color hitDispColor = new Color( (float) 0.1, (float) 0.1, (float) 0.8,
                                         (float) 0.8);

  private Color shotColor = new Color( (float) 1, (float) 1, (float) 1,
                                      (float) 0.8);
  public sampleShot(point point, Stage stg) {
    Point = point;
    Point.setX_size(hitArea[0]);
    Point.setY_size(hitArea[1]);
    St = stg;
    isAlive = true;
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void Destroy() {
    isAlive = false;
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    Point.setY(Point.getY() - Speed); //45ドットづつ飛ぶ．
  }

  /**
   *
   * @param damage int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void addDamage(int damage) {
    isAlive = false;
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    drawHit(g);
  }

  public void drawShot(Graphics g) {
    g.setColor(shotColor);
    g.fillRect(Point.getXinFrame() - 2, Point.getYinFrame() - 5,
               Point.getX_size() + 2 * 2,
               Point.getY_size() + 5 * 2);
  }

  /**
   * ヒットディスプを表示します．
   * @param g Graphics
   */
  public void drawHit(Graphics g) {
    g.setColor(hitDispColor);
    g.fillRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size());
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public int getDamege() {
    return 1;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public point getPoint() {
    return Point;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean getVisible() {
    return isVisible;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public boolean isAlive() {
    if (Point.get_endX() < 5 || Point.getX() > point.getWidthSize()+5
        || Point.get_endY() < 5 || Point.getY() > point.getHeightSize()+5) {
      isAlive = false;
    }
    return isAlive;
  }

  /**
   *
   * @return boolean
   * @param o object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object o) {
    if (o.getCode() == object.CODE_ENEMY_CHR) { //敵との衝突にはダメージを与えます．自機には与えません．
      chr obj = (chr) o;
      if (Point.getX() < obj.getPoint().get_endX()
          && obj.getPoint().getX() < Point.get_endX()
          && Point.getY() < obj.getPoint().get_endY()
          && obj.getPoint().getY() < Point.get_endY()) {
        //以上当たり判定
        obj.addDamage(1); //あたった場合は，ダメージを与えます．
        isAlive = false;
      }
    }
    return false;
  }

  /**
   *
   * @param flag boolean
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void setKilled(boolean flag) {
    isAlive = !flag;
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setPoint(point point) {
    Point = point;
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
    this.isVisible = isVisible;
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
    return object.CODE_FRIEND_BULL;
  }
  public void setShipColor(Color color){
    shotColor = color;
  }
  public void setSpeed(int speed){
//    Speed = speed;
      //弾の速度は不変とします．
  }
  public int getSpeed(){
    return Speed;
  }
}
