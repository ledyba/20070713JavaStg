package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �w�i�����œh��܂�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class FillBlack
    implements back {
  public FillBlack() {
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    g.setColor(Color.BLACK);
    g.fillRect(point.getGameAreaStartX(), point.getGameAreaStartY(),
               point.getWidthSize(), point.getHeightSize());
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
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
  }

  public void setStage(Stage stg) {

  }

  public Stage getStage() {
    return null;
  }

  public int getCode() {
    return object.CODE_BACK;
  }
}
