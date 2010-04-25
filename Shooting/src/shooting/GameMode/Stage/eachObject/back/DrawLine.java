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
public class DrawLine
    implements back {
//  int lineX = 0;//�ړ����Ȃ�
  int lineY = 0;//Y�������㉺�Ɉړ�����
  public static final int moveX = 60;
  public static final int moveY = 60;
  public DrawLine() {
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    lineY += 3;//3�h�b�g�X�N���[���D
    if(lineY >= moveY){
      lineY -= moveY;
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
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
   * @todo ���� shooting.GameMode.Stage.basic.back ���\�b�h������
   */
  public point getBackPoint() {
    return null;
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
}
