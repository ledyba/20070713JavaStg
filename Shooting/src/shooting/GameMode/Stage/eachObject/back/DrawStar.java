package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;
import java.util.Random;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 星を描きます．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class DrawStar
    implements back {
  Star[] star;
  public static final int SPEED = 5;
  private Random rnd = new Random();
  public DrawStar() {
    starInit();
  }

  public void starInit() {
    star = new Star[30];
    for (int i = 0; i < star.length; i++) {
/*      star[i] = new Star(new point(rnd.nextInt(point.getWidthSize()),
                                   rnd.nextInt(point.getHeightSize()), 1, 1),
                         new Color(rnd.nextInt(), true).brighter(),rnd.nextInt(10)+5);
 */
      star[i] = new Star(new point(rnd.nextInt(point.getWidthSize()),
                                   rnd.nextInt(point.getHeightSize()), 1, 1),
                         Color.WHITE,rnd.nextInt(SPEED) + 5);
    }
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    for (int i = 0; i < star.length; i++) {
      if(star[i].point.getY() < point.getHeightSize()){
        star[i].point.setY(star[i].point.getY() + star[i].Speed);
      }else{
        star[i].point.setY(0);
        star[i].point.setX(rnd.nextInt(point.getWidthSize()));
      }
      g.setColor(star[i].color);
      g.fillRect(star[i].point.getXinFrame(),star[i].point.getYinFrame(),2,2);
    }
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.back メソッドを実装
   */
  public point getBackPoint() {
    return null;
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public int getCode() {
    return 0;
  }

  /**
   *
   * @return point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public point getPoint() {
    return null;
  }

  /**
   *
   * @return Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public Stage getStage() {
    return null;
  }

  /**
   *
   * @return boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean getVisible() {
    return false;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object obj) {
    return false;
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.back メソッドを実装
   */
  public void setBackPoint(point point) {
  }

  /**
   *
   * @param point point
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setPoint(point point) {
  }

  /**
   * 所属するステージを設定します.
   *
   * @param stg Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setStage(Stage stg) {
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
  }
}

/**
 * 星をあらわすオブジェクト
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
class Star {
  point point;
  Color color;
  int Speed;
  public Star(point point, Color color, int speed) {
    this.point = point;
    this.color = color;
    this.Speed = speed;
  }
}
