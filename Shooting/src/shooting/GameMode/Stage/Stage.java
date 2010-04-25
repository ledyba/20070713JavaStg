package shooting.GameMode.Stage;

import java.util.*;
import shooting.GameMode.*;
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
public abstract class Stage extends Thread{
  public static final long INTERVAL = (1000 / GameFrame.RefreshRate) / 2;
  public static final int END_KEY_PRESSED_COUNT_INTERVAL = 30;
  public static final int NUMBER_OF_LAYERS = 7;//���C���̐�
  public static final int BACK = 0;
  public static final int LND = 1;
  public static final int FRIEND_BULL = 2;
  public static final int FRIEND_CHR = 3;
  public static final int ENEMY_CHR = 4;
  public static final int ENEMY_BULL = 5;
  public static final int SCORE = 6;
  /**
   * �������Ă�ŃX�^�[�g�ł��D
   */
  public abstract void run();
  /**
   * �I�u�W�F�N�g�̓����������N���X�g��Ԃ��܂�
   * [0]:back
   * [1]:lnd
   * [2]:friend_bull
   * [3]:friend_chr
   * [4]:enemy_bull
   * [5]:enemy_chr
   * [6]:score
   * @return LinkedList[]
   */
  public abstract LinkedList[] getLayers();

  /**
   * �I�u�W�F�N�g��ǉ����܂��D
   * �e�̔������ȂǂɎg���܂��D
   * @param o Object
   * @param Layer int
   */
  public abstract void addObj(object o, int Layer);

  /**
   * ���͂�Ԃ��܂�
   *   1:��
   *   2:��
   *   4:��
   *   8:��
   *  16:�{�^���P
   *  32:�{�^���Q
   *  64:�{�^���R
   * @return boolean
   */
  public abstract byte getInput();

  /**
   * ���@�̎c�@��Ԃ��܂��D
   * @return int
   */
  public abstract int getShips();

  /**
   * �c�@�𑝂₵���茸�炵���肵�܂��D
   * @param n int
   */
  public abstract void addShips(int n);

  /**
   * ���@�̃|�C���g��Ԃ��܂�
   * @return point
   */
  public abstract point getShipPoint();

  /**
   * �X�R�A�������܂��D
   * @param score int
   */
  public abstract void addScore(int score);

  /**
   * �X�R�A�����炢�܂��D
   * @return int
   */
  public abstract int getScore();

  /**
   * �I�u�W�F�N�g�̐���Ԃ��܂��D
   * @return int
   */
  public abstract int getObjects();

  /**
   * �Q�[���I�[�o���ۂ���Ԃ��܂��D
   * @return boolean
   */
  public abstract boolean isGameOver();
  /**
   * ���̎��Ԃ�Ԃ��܂�
   * @return long
   */
  public abstract long getNowTime();
  /**
   * �t���[���J�E���g��Ԃ��܂��D
   * @return long
   */
  public abstract long getFrameCount();
  /**
   * �����N��Ԃ��܂�
   * @return int
   */
  public abstract int getRank();
  }
