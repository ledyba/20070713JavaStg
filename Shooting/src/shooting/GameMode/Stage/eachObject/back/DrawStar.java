package shooting.GameMode.Stage.eachObject.back;

import java.awt.*;

import shooting.GameMode.Stage.*;
import shooting.GameMode.Stage.basic.*;
import java.util.Random;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ����`���܂��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
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

/**
 * ��������킷�I�u�W�F�N�g
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
