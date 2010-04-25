package shooting.GameMode.Stage.eachObject.back;

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
public class DrawLine
    implements back {
//  int lineX = 0;//移動しない
  int lineY = 0;//Y軸だけ上下に移動する
  public static final int moveX = 60;
  public static final int moveY = 60;
  public DrawLine() {
  }

  /**
   *
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void Move() {
    lineY += 3;//3ドットスクロール．
    if(lineY >= moveY){
      lineY -= moveY;
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo この shooting.GameMode.Stage.basic.object メソッドを実装
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.darkGray);
    for(int i=point.getInFrameX(moveX);i< point.getGameAreaEndX(); i+= moveX){
      g.drawLine(i,point.getGameAreaStartY(),i,point.getGameAreaEndY());
    }
    for(int i=point.getInFrameY(lineY);i< point.getGameAreaEndY(); i+= moveY){
      g.drawLine(point.getGameAreaStartY(),i,point.getGameAreaEndY(),i);
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
