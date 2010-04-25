package shooting.GameMode.Stage.eachObject;

import java.awt.*;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.Stage;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �T���v���V���b�g�Ƃ����C���@�̒e�������肵�܂��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class sampleShot
    implements bull {
  private point Point;
  private int[] hitArea = {
      5, 30};
  private boolean isAlive = true;
  private int Speed = 45;
  private boolean isVisible = true;
  private Stage St;
  private Color hitDispColor = new Color( (float) 0.1, (float) 0.1, (float) 0.8,
                                         (float) 0.8);

  private Color shotColor = new Color( (float) 1, (float) 1, (float) 1,
                                      (float) 0.8);
  public sampleShot(point point, Stage stg) {
    Point = point;
    Point.setX_size(hitArea[0]);
    Point.setY_size(hitArea[1]);
    St = stg;
    isAlive = true;
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void Destroy() {
    isAlive = false;
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    Point.setY(Point.getY() - Speed); //45�h�b�g�Â�ԁD
  }

  /**
   *
   * @param damage int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void addDamage(int damage) {
    isAlive = false;
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    drawHit(g);
  }

  public void drawShot(Graphics g) {
    g.setColor(shotColor);
    g.fillRect(Point.getXinFrame() - 2, Point.getYinFrame() - 5,
               Point.getX_size() + 2 * 2,
               Point.getY_size() + 5 * 2);
  }

  /**
   * �q�b�g�f�B�X�v��\�����܂��D
   * @param g Graphics
   */
  public void drawHit(Graphics g) {
    g.setColor(hitDispColor);
    g.fillRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size());
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public int getDamege() {
    return 1;
  }

  /**
   *
   * @return point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public point getPoint() {
    return Point;
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
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public boolean isAlive() {
    if (Point.get_endX() < 5 || Point.getX() > point.getWidthSize()+5
        || Point.get_endY() < 5 || Point.getY() > point.getHeightSize()+5) {
      isAlive = false;
    }
    return isAlive;
  }

  /**
   *
   * @return boolean
   * @param o object
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean judge(object o) {
    if (o.getCode() == object.CODE_ENEMY_CHR) { //�G�Ƃ̏Փ˂ɂ̓_���[�W��^���܂��D���@�ɂ͗^���܂���D
      chr obj = (chr) o;
      if (Point.getX() < obj.getPoint().get_endX()
          && obj.getPoint().getX() < Point.get_endX()
          && Point.getY() < obj.getPoint().get_endY()
          && obj.getPoint().getY() < Point.get_endY()) {
        //�ȏ㓖���蔻��
        obj.addDamage(1); //���������ꍇ�́C�_���[�W��^���܂��D
        isAlive = false;
      }
    }
    return false;
  }

  /**
   *
   * @param flag boolean
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void setKilled(boolean flag) {
    isAlive = !flag;
  }

  /**
   *
   * @param point point
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setPoint(point point) {
    Point = point;
  }

  /**
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
    this.isVisible = isVisible;
  }

  /**
   * ��������X�e�[�W��Ԃ��܂��D
   * @return Stage
   */
  public Stage getStage() {
    return St;
  }

  /**
   * ��������X�e�[�W��ݒ肵�܂��D
   * @param stg Stage
   */
  public void setStage(Stage stg) {
    St = stg;
  }

  public int getCode() {
    return object.CODE_FRIEND_BULL;
  }
  public void setShipColor(Color color){
    shotColor = color;
  }
  public void setSpeed(int speed){
//    Speed = speed;
      //�e�̑��x�͕s�ςƂ��܂��D
  }
  public int getSpeed(){
    return Speed;
  }
}
