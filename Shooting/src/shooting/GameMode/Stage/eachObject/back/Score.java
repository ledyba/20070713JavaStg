package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.*;
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
public class Score
    implements back {
  Stage Stg;
  boolean isVisible = true;
  private long preTime; //��b�O�̎���
  private int fps = 0;
  private int preFps = 0;

  public Score(Stage stg) {
    Stg = stg;
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    //�������悤�Ȃ��Ƃ����܂���D
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, point.getGameAreaStartX(), point.getHeightSize());
    g.fillRect(point.getGameAreaEndX(), 0,
               GameFrame.Width - point.getGameAreaEndX(),
               point.getGameAreaEndY());

/*    g.setColor(Color.BLUE);
    g.drawRect(point.getGameAreaStartX(), point.getGameAreaStartY(),
               point.getWidthSize(), point.getHeightSize() - 1);
 */

    g.setColor(Color.WHITE);
    g.setFont(new Font("Helvetica", Font.PLAIN, 12));
    g.drawString( ("Rank : " + String.valueOf(Stg.getRank())), point.getGameAreaEndX() + 10,50);
    g.drawString( ("Score : " + String.valueOf(Stg.getScore())), 10,
                 point.getHeightSize() - 30);
    g.drawString( ("Ship �~ " + String.valueOf(Stg.getShips())), 10,
                 point.getHeightSize() - 18);
   showFrameRate(g);
  }

  private void showFrameRate(Graphics g) {
    fps++;
    long justNow = Stg.getNowTime();
    if ( (justNow - preTime) >= 1000) {
      preTime = justNow;
      preFps = fps;
      fps = 0;
    }

    String str;
    str = String.valueOf(preFps) + " FPS";
    g.drawString(str,
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 18);

    g.drawString(String.valueOf(Stg.getObjects()) + " object(s)",
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 30);

    g.drawString(String.valueOf(Stg.getFrameCount()) + " frame(s)",
                 point.getGameAreaEndX() + 10, point.getGameAreaEndY() - 42);

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
    return Stg;
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean getVisible() {
    return isVisible;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean judge(object obj) {
    //�w�i�Ȃ̂Ŕ���Ȃ�
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
    Stg = stg;
  }

  /**
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
    this.isVisible = isVisible;
  }

  public int getCode() {
    return object.CODE_SCORE;
  }

}
