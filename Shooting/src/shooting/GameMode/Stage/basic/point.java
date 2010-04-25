package shooting.GameMode.Stage.basic;

import shooting.GameMode.*;
import java.util.Random;
import shooting.GameMode.Stage.*;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: ���W(�ƃT�C�Y)��\���I�u�W�F�N�g�ł�</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class point {
  private int X;
  private int Y;
  private int X_size;
  private int Y_size;

  /**
   * �������Ԃɏ���������ƁC�������ʂ����Ԃ��܂���D
   * ����āustatic�v�錾�����邱�ƁI
   * �܂��ЂƂ��悭�Ȃ����ˁ�
   */
  private static Random rnd = new Random(); //�����_���v�f�������܂��D

  /**
   * ���W���쐬���܂��D
   * @param x int
   * @param y int
   * @param x_size int
   * @param y_size int
   */
  public point(int x, int y, int x_size, int y_size) {
    X = x;
    Y = y;
    X_size = x_size;
    Y_size = y_size;
  }

  /**
   * ������W��X���W��ݒ肵�܂��D
   * @param x int
   */
  public void setX(int x) {
    X = x;
  }

  /**
   * ������W��X���W��Ԃ��܂��D
   * @return int
   */
  public int getX() {
    return X;
  }

  /**
   * ������W��Y���W��ݒ肵�܂��D
   * @param y int
   */
  public void setY(int y) {
    Y = y;
  }

  /**
   * ������W��Y���W��Ԃ��܂��D
   * @return int
   */
  public int getY() {
    return Y;
  }

  /**
   * X���W�̃T�C�Y��ݒ肵�܂�
   * @param x_size int
   */
  public void setX_size(int x_size) {
    this.X_size = x_size;
  }

  /**
   * X���W�̃T�C�Y��Ԃ��܂�
   * @return int
   */
  public int getX_size() {
    return X_size;
  }

  /**
   * Y���W�̃T�C�Y��ݒ肵�܂�
   * @param y_size int
   */
  public void setY_size(int y_size) {
    this.Y_size = y_size;
  }

  /**
   * Y���W�̃T�C�Y��Ԃ��܂�
   * @return int
   */
  public int getY_size() {
    return Y_size;
  }

  /**
   * �E�����W��X���W��Ԃ��܂�
   * @return int
   */
  public int get_endX() {
    return X + X_size;
  }

  /**
   * �E�����W��Y���W��Ԃ��܂�
   * @return int
   */
  public int get_endY() {
    return Y + Y_size;
  }

  /**
   * �t���[�����ł�X���W��Ԃ��܂��D
   * 16:9���l���Ă܂��D
   * @return int
   */
  public int getXinFrame() {
    return X + ( (GameFrame.Width - (GameFrame.Height * 9 >> 4)) >> 1);
  }

  /**
   * �t���[�����ł�Y���W��Ԃ��܂��D
   * @return int
   */
  public int getYinFrame() {
    return Y;
  }

  /**
   * �t���[�����ł̉E�����W��X���W��Ԃ��܂�
   * @return int
   */
  public int get_endXinFrame() {
    return getXinFrame() + X_size;
  }

  /**
   * �t���[�����ł̉E�����W��Y���W��Ԃ��܂�
   * @return int
   */
  public int get_endYinFrame() {
    return getYinFrame() + Y_size;
  }

  /**
   * �Q�[����ʂ�X���W�̃T�C�Y��Ԃ��܂��D
   * @return int
   */
  public static int getWidthSize() {
    return (GameFrame.Height * 9) >> 4;
  }

  /**
   * �Q�[����ʂ�Y���W�̃T�C�Y��Ԃ��܂��D
   * @return int
   */
  public static int getHeightSize() {
    return GameFrame.Height;
  }

  /**
   * �Q�[���̉�ʃG���A���n�܂�X���W��Ԃ��܂��D
   * @return int
   */
  public static int getGameAreaStartX() {
    return (GameFrame.Width - getWidthSize()) >> 1;
  }

  /**
   * �Q�[���̉�ʃG���A���n�܂�Y���W��Ԃ��܂��D
   * @return int
   */
  public static int getGameAreaStartY() {
    return (GameFrame.Height - getHeightSize()) >> 1;
  }

  /**
   * �Q�[���̉�ʃG���A���I���X���W��Ԃ��܂��D
   * @return int
   */
  public static int getGameAreaEndX() {
    return getGameAreaStartX() + getWidthSize();
  }

  /**
   * �Q�[���̉�ʃG���A���I���Y���W��Ԃ��܂��D
   * @return int
   */
  public static int getGameAreaEndY() {
    return getGameAreaStartY() + getHeightSize();
  }

  /**
   * X���W�̒��S��Ԃ��܂��D
   * @return int
   */
  public int getCenterX() {
    return getX() + (getX_size() >> 1);
  }

  /**
   * Y���W�̒��S��Ԃ��܂�
   * @return int
   */
  public int getCenterY() {
    return getY() + (getY_size() >> 1);
  }

  /**
   * ���S�̍��W��ݒ肵�܂��D
   * @param x int
   */
  public void setCenterX(int x) {
    X = x - (X_size >> 1);
  }

  /**
   * ���S�̍��W��ݒ肵�܂��D
   * @param y int
   */
  public void setCenterY(int y) {
    Y = y - (Y_size >> 1);
  }

  /**
   * X���W���t���[�����ł̘b�ɕϊ����܂��D
   * @param x int
   * @return int
   */
  public static int getInFrameX(int x) {
    return x + getGameAreaStartX();
  }

  /**
   * Y���W���t���[�����ł̘b�ɕϊ����܂��D
   * @param y int
   * @return int
   */
  public static int getInFrameY(int y) {
    return y + getGameAreaStartY();
  }

  /**
   * �p�x�����炵�����������܂��D
   * @param angle float
   * @param isAngleRandom boolean
   * @param oldDirection float[]
   * @param isSpeedRandom boolean
   * @return float[]
   */
  public static float[] getNewDirection(float angle,boolean isAngleRandom,float[] oldDirection,boolean isSpeedRandom) {
    if(isAngleRandom){
      angle = (float)(angle * (rnd.nextFloat() * 2 - 1));
    }
    float rad = (float)(Math.PI / 180 * angle);
    float cos = (float)Math.cos(rad);
    float sin = (float)Math.sin(rad);
    float Direction[] = new float[2];
    Direction[0] = (float)(oldDirection[0]*cos - oldDirection[1] * sin);
    Direction[1] = (float)(oldDirection[0]*sin + oldDirection[1] * cos);
    if(isSpeedRandom){
      float Speed = (float)(rnd.nextFloat()+ 0.5);
      Direction[0] *= Speed;
      Direction[1] *= Speed;
    }
    return Direction;
  }

  /**
   * �p�x������������߂܂��D
   * @param angle float
   * @param Speed float
   * @param isSpeedRandom boolean
   * @return float[]
   */
  public static float[] getDirection(float angle,float Speed,boolean isSpeedRandom) {
    if(isSpeedRandom){
      Speed = (float)( Speed * (rnd.nextFloat() * 2 - 1));
    }
    float Direction[] = new float[2];
    float rad = (float)(Math.PI / 180 * angle);
    Direction[0] = (float) Math.cos(rad) * Speed;
    Direction[1] = (float) Math.sin(rad) * Speed;
    return Direction;
  }
  /**
   * ���@�ւ̕��������߂܂�
   * @param isGameOver boolean
   * @param bullPoint point
   * @param stg Stage
   * @param Speed float
   * @param isSpeedRandom boolean
   * @return float[]
   */

  public static float[] getDirectionToShip(boolean isGameOver,point bullPoint,Stage stg,float Speed,boolean isSpeedRandom) {
    if(isSpeedRandom){
      Speed = (float)( Speed * (rnd.nextFloat() + 0.5));
    }
    if (!isGameOver) { //�Q�[���I�[�o�[�łȂ��Ȃ�
      float d = 0;
      int X = stg.getShipPoint().getCenterX() -
          bullPoint.getCenterX();
      d += X * X;
      int Y = stg.getShipPoint().getCenterY() -
          bullPoint.getCenterY();
      d += Y * Y;
      d = (float) Math.sqrt(d);
      if (d > 0) {
        float[] dir = {
            ( (X / d) * Speed), (Y / d * Speed)};
        return dir;
      }
      else {
        float[] dir = {
            0, Speed};
        return dir;
      }
    }
    else {
      float dir[] = {
          (float) 0, (float) Speed};
      return dir;
    }
  }
}
