package shooting.GameMode.Stage.eachStage;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �^�C�g����`�ʂ��܂��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class ModeSelect_Title
    implements chr {
  public ModeSelect_Title() {
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
    g.setColor(Color.white);
    g.setFont(new Font("Helvetica", Font.PLAIN, 24));
    g.drawString("Title",point.getGameAreaStartX() + 20,point.getHeightSize() * 1/5);
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public int getCode() {
    return object.CODE_FRIEND_CHR;
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
    return true;
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
