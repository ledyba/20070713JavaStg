package shooting.GameMode.Stage.eachObject;

import shooting.GameMode.Stage.basic.chr;
import java.awt.Graphics;
import shooting.GameMode.Stage.basic.point;
import shooting.GameMode.Stage.Stage;
import shooting.GameMode.Stage.basic.object;
import java.awt.Color;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �G�t�F�N�g��`�ʂ��܂��D���\�C����D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class BreakEfect
    implements chr {
  public BreakEfect() {
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void Destroy() {
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
  }

  /**
   *
   * @param damage int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void addDamage(int damage) {
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public int getCode() {
    return 0;
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public int getDamege() {
    return 0;
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
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public boolean isAlive() {
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
   * @param flag boolean
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void setKilled(boolean flag) {
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
   * @param color Color
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void setShipColor(Color color) {
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
}
