package shooting.GameMode.Stage.eachObject.enemy;

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
public class enemy01
    implements chr {
  Stage stg;
  final int Score = 1;
  int Shield = 5;
  private boolean isAlive;
  private boolean isEscape = false; //��ʂ��痣���t���O�ł��DY�����1/3�������瓦����D
  private int MoveX = 0; //X���ړ��ʂł��D
  private int dirX; //X���̕����ł�
  private int MoveY = 0; //Y���ړ��ʂł��D
  public static final int ALIVE_LIMIT = 300;
  private Color shipColor = Color.RED.darker();
  private Color lineColor = Color.MAGENTA.darker(); //�g�̐F�ł�
  private Color shotHitColor = new Color( (float) 0.9, 0, (float) 0.7).brighter();

  private bullPattern bullet;
  int aliveCount = ALIVE_LIMIT; //�t���[�����𒴂���Ǝ��R����
  private int[] AREA = {
      30, 30}; //�����蔻��̑傫��
  private point Point;
  public enemy01(Stage stg, point point) {
    this.stg = stg;
    this.Point = point;
    setArea(Point);
    isAlive = true;
    //�����œ����������ς���
    if (Point.getCenterX() < (point.getWidthSize() >> 1)) {
      dirX = -1;
    }
    else {
      dirX = 1;
    }
    bullet = new enemyBullPattern01(stg, point, shotHitColor);
  }

  void setArea(point p) {
    p.setCenterX(p.getX());
    p.setCenterY(p.getY());
    /*    p.setX_size(AREA[0]);
        p.setY_size(AREA[1]);*/
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void Destroy() {
    if (Shield <= 0) {
      stg.addScore(Score * (ALIVE_LIMIT - aliveCount));
    }
    //hitBack();
  }

  public void toBig(int[] AREA) {
    if (Point.getX_size() < AREA[0]) {
      Point.setX_size(Point.getX_size() + 1);
      Point.setY_size(Point.getY_size() + 1);
    }
    if (Point.getY_size() < AREA[1]) {
      Point.setX_size(Point.getX_size() + 1);
      Point.setY_size(Point.getY_size() + 1);
    }
  }

  public void toSmall() {
    if (Point.getX_size() > 1) {
      Point.setX_size(Point.getX_size() - 1);
      Point.setY_size(Point.getY_size() - 1);
    }
    if (Point.getY_size() > 1) {
      Point.setY_size(Point.getY_size() - 1);
      Point.setX_size(Point.getX_size() - 1);
    }
  }

  void setSize(int[] AREA) {
    if (aliveCount > ALIVE_LIMIT - Math.max(AREA[0], AREA[1]) &&
        (aliveCount & 2) == 2) {
      toBig(AREA);
    }
    if (aliveCount < Math.min(AREA[0], AREA[1]) && ( (aliveCount & 2) == 2)) {
      toSmall();
    }
  }

  /**
   *
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void Move() {
    aliveCount--;
    if (aliveCount > 0) {
      setSize(AREA);
      if (isEscape) {
        if ( (aliveCount & 7) == 7) {
          if (dirX < 0) {
            if (MoveX >= -4) {
              MoveX += dirX;
            }
          }
          else {
            if (MoveX <= 4) {
              MoveX += dirX;
            }
          }
          if (MoveY >= -4) {
            MoveY--;
          }
        }
      }
      else {
        if ( (aliveCount & 7) == 7) {
          if (dirX < 0) {
            if (MoveX <= 4) {
              MoveX -= dirX;
            }
          }
          else {
            if (MoveX >= -4) {
              MoveX -= dirX;
            }
          }
          if (MoveY <= 4) {
            MoveY++;
          }
        }
        if (Point.getCenterY() >= (point.getHeightSize() >> 2)) {
          isEscape = true;
        }
      }
      shot();
      Point.setX(Point.getX() + MoveX);
      Point.setY(Point.getY() + MoveY);
    }
    else {
      isAlive = false;
    }
  }

  /**
   * �e�������܂��D
   */
  void shot() {
    if ( (this.aliveCount == 100) || (this.aliveCount == 150) ||
        (this.aliveCount == 200)) {
//      bullet.fire();
      //����
      float[] dir = point.getDirectionToShip(this.stg.isGameOver(), this.Point,
                                             stg,
                                             enemyShot01.DFAULT_SPEED, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 dir, 0), Stage.ENEMY_BULL);
      //�v3��
      float[] rightDir = point.getNewDirection( -1 * 5, true, dir, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 rightDir, 2), Stage.ENEMY_BULL);
      float[] leftDir = point.getNewDirection(1 * 5, true, dir, true);
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 leftDir, 2), Stage.ENEMY_BULL);
    }
  }

  /**
   * ���炵���ł��Ԃ��e�������܂��D
   */
  void hitBack() {
    float[] dir = point.getDirectionToShip(this.stg.isGameOver(), this.Point,
                                           stg,
                                           enemyShot01.DFAULT_SPEED, true);
    for (int i = 0; i < 3; i++) {
      stg.addObj(new enemyShot01(makeNewPoint(),
                                 shotHitColor, stg,
                                 point.getNewDirection(10, true, dir, true), 10),
                 Stage.ENEMY_BULL);
    }
  }

  /**
   *
   * @param damage int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public void addDamage(int damage) {
    Shield -= damage;
    if (Shield <= 0) {
      isAlive = false;
    }
  }

  /**
   *
   * @param g Graphics
   * @param isHitDisp int
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void draw(Graphics g, byte isHitDisp) {
    /*
         Color color;
     if (aliveCount > ALIVE_LIMIT * 0.9 || aliveCount < ALIVE_LIMIT * 0.1) {
      color = Color.black;
         }
         else {
      color = this.shipColor;
         }
         drawShip(g, color);
     */
    drawShip(g, this.shipColor);
    /*
         if ( (isHitDisp & 0x1) != 0) { //�{�̂���
      drawShip(g);
         }
         if ( (isHitDisp & 0x2) != 0) { //�q�b�g�f�B�X�v����
      //drawHit(g);
         }
     */
  }

  public void drawShip(Graphics g, Color color) {
    g.setColor(lineColor);
    g.drawRect(Point.getXinFrame() - 1, Point.getYinFrame() - 1,
               Point.getX_size() + 1,
               Point.getY_size() + 1);
    g.setColor(color);
    g.fillRect(Point.getXinFrame(), Point.getYinFrame(), Point.getX_size(),
               Point.getY_size());
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.basic.chr ���\�b�h������
   */
  public int getDamege() {
    return Shield;
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
   * @return Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public Stage getStage() {
    return stg;
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
    if (Point.get_endX() < -20 || Point.getX() > point.getWidthSize() + 20
        || Point.get_endY() < -20 || Point.getY() > point.getHeightSize() + 20) {
      isAlive = false;
    }
    return isAlive;
  }

  /**
   *
   * @return boolean
   * @param obj object
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public boolean judge(object obj) {
    //�W���b�W���܂���D�_���[�W�͗^���܂���D
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
   * ��������X�e�[�W��ݒ肵�܂�.
   *
   * @param stg Stage
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setStage(Stage stg) {
    this.stg = stg;
  }

  /**
   *
   * @param isVisible boolean
   * @todo ���� shooting.GameMode.Stage.basic.object ���\�b�h������
   */
  public void setVisible(boolean isVisible) {
  }

  public int getCode() {
    return object.CODE_ENEMY_CHR;
  }

  public void setShipColor(Color color) {
    shipColor = color;
  }

  public point makeNewPoint() {
    return new point(Point.getCenterX(), Point.getCenterY(), 0, 0);
  }
}
