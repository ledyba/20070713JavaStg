package shooting.GameMode.Stage.eachObject.myShip;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.*;
import shooting.GameMode.Stage.*;
import java.awt.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ���@01������킷�N���X�ł��D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class sampleMyShip
    implements chr {
  private static final int SPEED = GameFrame.Width /
      (int) (GameFrame.RefreshRate * 2);
  private int Damage = 1;
  private int noDamageCount = 0;
  private boolean isAlive = true;
  private boolean isVisible = true;
  private point Point = null;
  private Stage St;
  private int[] keyPressedTime = new int[GameFrame.KEY.length];
  private int keyPressedInterval = GameFrame.RefreshRate / 60; //���̃t���[�����ȏ���͂��Ȃ��ƁC�����܂���D
  private int shotInterval = 2; //���̃t���[���ȏ㉟���ĂȂ��ƃV���b�g�ł܂���D
  private int shotTimeCount = 0; //���t���[����������
  private Color shipColor = new Color( (float) 0.3, (float) 0.3, (float) 1,
                                      (float) 0.7);
  private Color hitDispColor = new Color( (float) 1.0, (float) 0.3, (float) 0.3,
                                         (float) 0.7);
  public sampleMyShip(Stage stg) {
    /*�|�C���g����D�����蔻��C5�h�b�g�D*/
    Point = new point(point.getWidthSize() * 1 / 2,
                      point.getHeightSize() * 4 / 5, 5, 5);
    St = stg;
    noDamageCount = GameFrame.RefreshRate * 2; //2�b�Ԗ��G�D
  }

  /**
   * �������܂��i�e�̔����܂ށj
   */
  public void Move() {
    if (noDamageCount >= 0) {
      noDamageCount--;
    }
    /**���͂ł��D
     *   1:��
     *   2:��
     *   4:��
     *   8:��
     *  16:�{�^���P
     *  32:�{�^���Q
     *  64:�{�^���R
     */


    int speed = SPEED; //�ꉞ�ݒ�
    /*�x���Ȃ�@�\�����̂��߁C�L�[�Q������ɏ���*/
    if ( (GameFrame.getInput() & 32) != 0) { //�������x���Ȃ�܂��D
      speed /= 2;
    }

    /*���܂�̃L�[�̏���*/
    if ( (GameFrame.getInput() & 1) != 0) {
      keyPressedTime[0]++;
      if (keyPressedTime[0] >= keyPressedInterval) {
        keyPressedTime[0] = 0;
        movePoint(0, -speed);
      }
    }
    if ( (GameFrame.getInput() & 2) != 0) {
      keyPressedTime[1]++;
      if (keyPressedTime[1] >= keyPressedInterval) {
        keyPressedTime[1] = 0;
        movePoint(0, speed);
      }
    }
    if ( (GameFrame.getInput() & 4) != 0) {
      keyPressedTime[2]++;
      if (keyPressedTime[2] >= keyPressedInterval) {
        keyPressedTime[2] = 0;
        movePoint(speed, 0);
      }
    }
    if ( (GameFrame.getInput() & 8) != 0) {
      keyPressedTime[3]++;
      if (keyPressedTime[3] >= keyPressedInterval) {
        keyPressedTime[3] = 0;
        movePoint( -speed, 0);
      }
    }
    if ( (GameFrame.getInput() & 16) != 0) { //�V���b�g�������܂��D
      shot();
    }
    else {
      shotTimeCount = 0;
    }
  }

  /**
   * ���@���ړ������܂��D
   * @param x int
   * @param y int
   */
  private void movePoint(int x, int y) {
    int changedX = Point.getX() + x;
    int changedY = Point.getY() + y;
    if (0 <= changedX && changedX + Point.getX_size() <= point.getWidthSize()) {
      Point.setX(changedX);
    }
    if (10 <= changedY &&
        changedY + Point.getY_size() <= point.getHeightSize() - 10) {
      Point.setY(changedY);
      //System.out.println("("+Point.getX()+","+Point.getY()+")");
    }
  }

  /**
   * �e�������܂��D
   */
  private void shot() {
    shotTimeCount++;
    if (shotTimeCount >= shotInterval) {
      shotTimeCount = 0;
      St.addObj(new myShot01(new point(Point.getCenterX() - 11,
                                       Point.getCenterY() - 30, 0, 0), St), 2);
      St.addObj(new myShot01(new point(Point.getCenterX() + 7,
                                       Point.getCenterY() - 30, 0, 0), St), 2);
    }
  }

  /**
   * ���̃L�����N�^������ł��邩�ۂ��̃Z�b�g
   * @param flag boolean
   */
  public void setKilled(boolean flag) {
    isAlive = flag;
  }

  /**
   * �E����Ă��邩�ۂ��̎擾
   * @return boolean
   */
  public boolean isAlive() {
//    return true;
    return isAlive;
  }

  /**
   * �e�⎩�@��j�����܂��D
   */
  public void Destroy() {
    //�j�����܂���D
  }

  /**
   * ���̃L�����N�^�Ƀ_���[�W�������܂�
   * @param damage int
   */
  public void addDamage(int damage) {
    if (noDamageCount < 0) {
      Damage -= damage;
    }
    if (Damage <= 0) {
      isAlive = false;
    }
  }

  /**
   * �c��V�[���h��Ԃ��܂�
   * @return int
   */
  public int getDamege() {
    return Damage;
  }

  /**
   * ���W�i�Ƒ傫���j��ݒ肵�܂�
   * @param point point
   */
  public void setPoint(point point) {
    Point = point;
  }

  /**
   * ���W�i�Ƒ傫���j��Ԃ��܂�
   * @return point
   */
  public point getPoint() {
    return Point;
  }

  /**
   * ������悤�ɂ��邩�C���Ȃ�����ݒ肵�܂�
   * @param flag boolean
   */
  public void setVisible(boolean flag) {
    isVisible = flag;
  }

  /**
   * �����Ă��邩�̌��݂̏󋵂�Ԃ��܂�
   * @return boolean
   */
  public boolean getVisible() {
    return isVisible;
  }

  /**
   * �����蔻����s���܂��D
   * �_���[�W��^���锻��݂̂��s���܂��D
   * @param o object
   * @return boolean
   */
  public boolean judge(object o) {

    return false;
  }

  /**
   * �`�ʂ��܂��D<br>
   * ���ӁF���C���ň����̂Ńo�b�t�@���N���A���Ȃ����ƁI<br>
   * 0:�q�b�g�f�B�X�v���C�Ȃ�<br>
   * 1:�q�b�g�f�B�X�v���C����<br>
   * 2:�q�b�g�f�B�X�v���C�̂�<br>
   * @param g Graphics
   * @param isHitDisp int
   */
  public void draw(Graphics g, byte isHitDisp) {
    if (noDamageCount >= 0 && noDamageCount % 2 != 0) {
    }
    else {
        drawShip(g);
        drawHit(g);
    }
  }

  public void drawShip(Graphics g) {
    int centerX = point.getInFrameX(Point.getCenterX());
    int centerY = point.getInFrameY(Point.getCenterY());
    g.setColor(shipColor);
    int[] polygonX = {centerX - 10, centerX - 2, centerX - 13, };
    int[] polygonY = {centerY, centerY + 7, centerY +11 };
    g.drawPolygon(polygonX, polygonY, 3);

    int[] polygonX2 = {centerX + 10, centerX + 2, centerX + 13, };
    int[] polygonY2 = {centerY , centerY + 7, centerY + 11, };
    g.drawPolygon(polygonX2, polygonY2, 3);

    int[] polygonX3 = {centerX + 8, centerX - 8, centerX, };
    int[] polygonY3 = {centerY - 4, centerY - 4, centerY - 30, };
    g.drawPolygon(polygonX3, polygonY3, 3);
  }

  public void drawHit(Graphics g) {
    g.setColor(this.hitDispColor);
    g.fill3DRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size(),true);
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
    return object.CODE_FRIEND_CHR;
  }
  public void setShipColor(Color color){
    shipColor = color;
  }
}
