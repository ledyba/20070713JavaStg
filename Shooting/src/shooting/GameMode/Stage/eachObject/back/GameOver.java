package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: </p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class GameOver
    implements back {
  long frameCount = 0;
  Stage stg;
  point Point = new point(point.getWidthSize() / 10, point.getHeightSize() / 5,
                          0, 0);
  public GameOver(Stage stg) {
    this.stg = stg;
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    frameCount++;
    if (Point.getY() <= point.getHeightSize() / 2) {
      Point.setY(Point.getY() + 2);
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.white);
    g.setFont(new Font("Helvetica", Font.PLAIN, 36));
    g.drawString("Game Over", Point.getXinFrame(), Point.getYinFrame() - 36);
    g.drawString( ("Score : " + String.valueOf(stg.getScore())),
                 Point.getXinFrame(), Point.getYinFrame());
    if (frameCount >= Stage.END_KEY_PRESSED_COUNT_INTERVAL) {
      if ( (frameCount % 40) < 20) {
        g.drawString("Press Shot Key", Point.getXinFrame() - 20,
                     (point.getHeightSize() * 4) / 5);
      }
    }
  }

  /**
   *
   * @return point
   * @todo ���� shooting.GameMode.Stage.basic.back ���\�b�h������
   */
  public point getBackPoint() {
    return null;
  }

  /**
   *
   * @return point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public point getPoint() {
    return null;
  }

  /**
   *
   * @return Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public Stage getStage() {
    return null;
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean getVisible() {
    return false;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean judge(object obj) {
    return false;
  }

  /**
   *
   * @param point point
   * @todo ���� shooting.GameMode.Stage.basic.back ���\�b�h������
   */
  public void setBackPoint(point point) {
  }

  /**
   *
   * @param point point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setPoint(point point) {
  }

  /**
   * ��������X�e�[�W��ݒ肵�܂�.
   *
   * @param stg Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setStage(Stage stg) {
  }

  /**
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
  }

  public int getCode() {
    return object.CODE_SCORE;
  }

}
