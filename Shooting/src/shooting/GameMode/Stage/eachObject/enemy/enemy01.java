package shooting.GameMode.Stage.eachObject.enemy;

import java.awt.*;

import shooting.GameMode.Stage.*;
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
public class enemy01
    implements chr {
  Stage stg;
  final int Score = 1;
  int Shield = 5;
  private boolean isAlive;
  private boolean isEscape = false; //画面から離れるフラグです．Y軸画面1/3超えたら逃げる．
  private int MoveX = 0; //X軸移動量です．
  private int dirX; //X軸の方向です
  private int MoveY = 0; //Y軸移動量です．
  public static final int ALIVE_LIMIT = 300;
  private Color shipColor = Color.RED.darker();
  private Color lineColor = Color.MAGENTA.darker(); //枠の色です
  private Color shotHitColor = new Color( (float) 0.9, 0, (float) 0.7).brighter();

  private bullPattern bullet;
  int aliveCount = ALIVE_LIMIT; //フレーム数を超えると自然消滅
  private int[] AREA = {
      30, 30}; //当たり判定の大きさ
  private point Point;
  public enemy01(Stage stg, point point) {
    this.stg = stg;
    this.Point = point;
    setArea(Point);
    isAlive = true;
    //方向で逃げる向きを変える
    if (Point.getCenterX() < (point.getWidthSize() >> 1)) {
      dirX = -1;
    }
    else {
      dirX = 1;
    }
    bullet = new enemyBullPattern01(stg, point, shotHitColor);
  }

  void setArea(point p) {
    p.setCenterX(p.getX());
    p.setCenterY(p.getY());
    /*    p.setX_size(AREA[0]);
        p.setY_size(AREA[1]);*/
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void Destroy() {
    if (Shield <= 0) {
      stg.addScore(Score * (ALIVE_LIMIT - aliveCount));
    }
    //hitBack();
  }

  public void toBig(int[] AREA) {
    if (Point.getX_size() < AREA[0]) {
      Point.setX_size(Point.getX_size() + 1);
      Point.setY_size(Point.getY_size() + 1);
    }
    if (Point.getY_size() < AREA[1]) {
      Point.setX_size(Point.getX_size() + 1);
      Point.setY_size(Point.getY_size() + 1);
    }
  }

  public void toSmall() {
    if (Point.getX_size() > 1) {
      Point.setX_size(Point.getX_size() - 1);
      Point.setY_size(Point.getY_size() - 1);
    }
    if (Point.getY_size() > 1) {
      Point.setY_size(Point.getY_size() - 1);
      Point.setX_size(Point.getX_size() - 1);
    }
  }

  void setSize(int[] AREA) {
    if (aliveCount > ALIVE_LIMIT - Math.max(AREA[0], AREA[1]) &&
        (aliveCount & 2) == 2) {
      toBig(AREA);
    }
    if (aliveCount < Math.min(AREA[0], AREA[1]) && ( (aliveCount & 2) == 2)) {
      toSmall();
    }
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    aliveCount--;
    if (aliveCount > 0) {
      setSize(AREA);
      if (isEscape) {
        if ( (aliveCount & 7) == 7) {
          if (dirX < 0) {
            if (MoveX >= -4) {
              MoveX += dirX;
            }
          }
          else {
            if (MoveX <= 4) {
              MoveX += dirX;
            }
          }
          if (MoveY >= -4) {
            MoveY--;
          }
        }
      }
      else {
        if ( (aliveCount & 7) == 7) {
          if (dirX < 0) {
            if (MoveX <= 4) {
              MoveX -= dirX;
            }
          }
          else {
            if (MoveX >= -4) {
              MoveX -= dirX;
            }
          }
          if (MoveY <= 4) {
            MoveY++;
          }
        }
        if (Point.getCenterY() >= (point.getHeightSize() >> 2)) {
          isEscape = true;
        }
      }
      shot();
      Point.setX(Point.getX() + MoveX);
      Point.setY(Point.getY() + MoveY);
    }
    else {
      isAlive = false;
    }
  }

  /**
   * 弾を撃ちます．
   */
  void shot() {
    if ( (this.aliveCount == 100) || (this.aliveCount == 150) ||
        (this.aliveCount == 200)) {
//      bullet.fire();
      //発射
      float[] dir = point.getDirectionToShip(this.stg.isGameOver(), this.Point,
                                             stg,
                                             enemyShot01.DFAULT_SPEED, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 dir, 0), Stage.ENEMY_BULL);
      //計3発
      float[] rightDir = point.getNewDirection( -1 * 5, true, dir, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 rightDir, 2), Stage.ENEMY_BULL);
      float[] leftDir = point.getNewDirection(1 * 5, true, dir, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 leftDir, 2), Stage.ENEMY_BULL);
    }
  }

  /**
   * 嫌らしい打ち返し弾を撃ちます．
   */
  void hitBack() {
    float[] dir = point.getDirectionToShip(this.stg.isGameOver(), this.Point,
                                           stg,
                                           enemyShot01.DFAULT_SPEED, true);
    for (int i = 0; i < 3; i++) {
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 point.getNewDirection(10, true, dir, true), 10),
                 Stage.ENEMY_BULL);
    }
  }

  /**
   *
   * @param damage int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public void addDamage(int damage) {
    Shield -= damage;
    if (Shield <= 0) {
      isAlive = false;
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    /*
         Color color;
     if (aliveCount > ALIVE_LIMIT * 0.9 || aliveCount < ALIVE_LIMIT * 0.1) {
      color = Color.black;
         }
         else {
      color = this.shipColor;
         }
         drawShip(g, color);
     */
    drawShip(g, this.shipColor);
    /*
         if ( (isHitDisp & 0x1) != 0) { //本体あり
      drawShip(g);
         }
         if ( (isHitDisp & 0x2) != 0) { //ヒットディスプあり
      //drawHit(g);
         }
     */
  }

  public void drawShip(Graphics g, Color color) {
    g.setColor(lineColor);
    g.drawRect(Point.getXinFrame() - 1, Point.getYinFrame() - 1,
               Point.getX_size() + 1,
               Point.getY_size() + 1);
    g.setColor(color);
    g.fillRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size());
  }

  /**
   *
   * @return int
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public int getDamege() {
    return Shield;
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
   * @return Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public Stage getStage() {
    return stg;
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
   * @todo この shooting.GameMode.Stage.basic.chr メソッドを実装
   */
  public boolean isAlive() {
    if (Point.get_endX() < -20 || Point.getX() > point.getWidthSize() + 20
        || Point.get_endY() < -20 || Point.getY() > point.getHeightSize() + 20) {
      isAlive = false;
    }
    return isAlive;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public boolean judge(object obj) {
    //ジャッジしません．ダメージは与えません．
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
   * 所属するステージを設定します.
   *
   * @param stg Stage
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setStage(Stage stg) {
    this.stg = stg;
  }

  /**
   *
   * @param isVisible boolean
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void setVisible(boolean isVisible) {
  }

  public int getCode() {
    return object.CODE_ENEMY_CHR;
  }

  public void setShipColor(Color color) {
    shipColor = color;
  }

  public point makeNewPoint() {
    return new point(Point.getCenterX(), Point.getCenterY(), 0, 0);
  }
}
