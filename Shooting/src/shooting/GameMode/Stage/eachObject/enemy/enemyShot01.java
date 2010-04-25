package shooting.GameMode.Stage.eachObject.enemy;

import java.util.*;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.eachObject.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: 速度・方向が固定の弾です．</p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class enemyShot01
    extends sampleShot {
  public static final float DFAULT_SPEED = (float)1.5; //デフォルトの速度
  private static final int AREA = 3; //3*3です．

  private static final Color shotColor = new Color( (float) 0.9, (float) 0,
      (float) 0.7 ,(float)0.5); //本体に使います．

  private float[] pointf = new float[2]; //フロートによる座標です
  private Color hitColor;//当たり判定の色です．
  private float[] Direction;
  private int startCount = 0;//発射するまでの時間を設定します.
  /**
   * 直接飛ぶ量を指定します．
   * @param point point
   * @param hitColor Color
   * @param stg Stage
   * @param direction float[]
   */
  public enemyShot01(point point,Color hitColor, Stage stg, float[] direction,int startCount) {
    super(point, stg);
    this.hitColor = hitColor;
    this.getPoint().setX_size(AREA);
    this.getPoint().setY_size(AREA);
    pointf[0] = this.getPoint().getX();
    pointf[1] = this.getPoint().getY();
    this.Direction = direction;
    this.startCount = startCount;
    //this.angle = (float) Math.atan2(Direction[1], Direction[0]);
  }

  public void Move() {
    if(startCount <= 0){
      pointf[0] += Direction[0];
      pointf[1] += Direction[1];
      this.getPoint().setX( (int) (pointf[0]));
      this.getPoint().setY( (int) (pointf[1]));
    }else{
      startCount--;
    }
  }

  public void draw(Graphics g, byte isHitDisp) {
    drawHit(g);//二つ以上オブジェクトを書くと重い．
    /*
    if ( (isHitDisp & 0x1) != 0) { //本体あり
      drawShot(g);
    }
    if ( (isHitDisp & 0x2) != 0) { //ヒットディスプあり
      drawHit(g);
    }
*/

  }

  public void drawShot(Graphics g) {
    g.setColor(shotColor);
    //回転はコストかかる．以上．
    /*    g2.rotate(angle, point.getInFrameX(this.getPoint().getCenterX()),
                  point.getInFrameY(this.getPoint().getCenterY()));
     */
    g.setColor(shotColor);
    g.drawRect(this.getPoint().getXinFrame()-2, this.getPoint().getYinFrame()-2,
               this.getPoint().getX_size()+4,
               this.getPoint().getY_size()+4);
    /*    g2.rotate( -angle, point.getInFrameX(this.getPoint().getCenterX()),
                  point.getInFrameY(this.getPoint().getCenterY()));
     */

  }

  public void drawHit(Graphics g) {
    g.setColor(hitColor);
    g.fillRect(this.getPoint().getXinFrame(), this.getPoint().getYinFrame(),
               this.getPoint().getX_size(),
               this.getPoint().getY_size());
  }

  public boolean judge(object o) {
    if (o.getCode() == object.CODE_FRIEND_CHR) { //自機にダメージを与える
      chr obj = (chr) o;
      if (getPoint().getX() < obj.getPoint().get_endX()
          && obj.getPoint().getX() < getPoint().get_endX()
          && getPoint().getY() < obj.getPoint().get_endY()
          && obj.getPoint().getY() < getPoint().get_endY()) {
        obj.addDamage(1);
      }
    }
    /*else if(o.getCode() == object.CODE_LND){//地形との衝突判定
         lnd obj = (lnd)o;
         if (getPoint().getX() < obj.getPoint().get_endX()
        && obj.getPoint().getX() < getPoint().get_endX()
        && getPoint().getY() < obj.getPoint().get_endY()
        && obj.getPoint().getY() < getPoint().get_endY()) {
      this.setKilled(true);
         }
        }*/
    return false;
  }

  public int getCode() {
    return object.CODE_ENEMY_BULL;
  }
  public void setSpeed(int speed){
  }
  public int getSpeed(){
    return 0;
  }
}
