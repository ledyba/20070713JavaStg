package shooting.GameMode.Stage.eachStage;

import shooting.GameMode.*;
import java.util.*;
import java.awt.*;
import shooting.GameMode.Stage.eachObject.myShip.*;
import shooting.GameMode.Stage.eachObject.back.*;
import shooting.GameMode.Stage.eachObject.enemy.*;

import shooting.GameMode.Stage.basic.*;
import shooting.GameMode.Stage.enemyBorn;

/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 *
 * <p>����: �T���v���X�e�[�W�ł��D�e�X�g�p�D</p>
 *
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 *
 * <p>��Ж�: </p>
 *
 * @author ������
 * @version 1.0
 */
public class SampleStage
    extends shooting.GameMode.Stage.Stage {
  private LinkedList[] Layers;
  private Graphics g;
  private int Ships = 3; //�c�@���͂R
  private int Score = 0;
  private boolean endFlag = false;
  private int Objects = 0;
  private long nowTime; //���̎���
  private boolean isAlive = true; //���@�������Ă��邩�C����ł��邩
  private int endKeyPressedCount; //�I�����Ă���C�uPress shot Button�v�̕\�����o��܂�
  private boolean endKeyState = false; //���j���[�g�����ɂȂ��Ă���C�ēx�������ƁD
  private chr myShip; //���@��ۑ����Ă����D�������CLinkedList�ɂ��̂����D
  private long frameCount = 0;
  private boolean isGameOver = false;
  private Random rnd = new Random();
  private enemyBorn enemy = new enemyBornSample(this);
  public SampleStage() {
    setPriority(MAX_PRIORITY);//�D��x�͍ō��ɐݒ肵�Ă����܂��D
    endKeyPressedCount = this.END_KEY_PRESSED_COUNT_INTERVAL;
    Layers = new LinkedList[NUMBER_OF_LAYERS];
    for (int i = 0; i < Layers.length; i++) {
      Layers[i] = new LinkedList();
    }
  }

  /**
   * ��Ƀt���[���Ǘ��D���ۂ̃Q�[���Ɋւ��Ă͕ʂ̕��ōs���܂��D
   */
  public void run() {
    gameInit(); //�Q�[���J�n����
    nowTime = getNowTime();
    while (!endFlag) {
      frameCount++; //�t���[�����P�����߂�
      g = GameFrame.getBuff().getDrawGraphics(); //�O���t�B�b�N�擾
      if (!GameFrame.getBuff().contentsLost()) {
        game(); //�Q�[���̎��ۂ̏����i�P�t���[�����j
        if (endKeyPressedCount <= 0) {
          if ( (GameFrame.getInput() & 16) == 0) {
            endKeyState = true;
          }
          if (endKeyState) {
            if ( (GameFrame.getInput() & 16) != 0) {
              //�Q�[���I��
              end();
            }
          }
        }
        frameWait(); //�`�ʂ�҂��܂�
        GameFrame.getBuff().show(); //������
//        g.dispose(); //�p��
        nowTime = getNowTime();
      }
    }
  }

  /**
   * �Q�[���J�n�̏���
   */
  private void gameInit() {
    this.addObj(new FillBlack(), this.BACK);
    //this.addObj(new DrawLine(), this.BACK);
    this.addObj(new DrawStar(), this.BACK);
    this.addObj(new Score(this), this.SCORE);
    myShipBorn();
  }

  /**
   * ���ۂ̃Q�[���̏����i�P�t���[�����j
   */
  private void game() {
    enemy.run();//�G�̔���
    deadCheck(); //���@������ł��܂������ǂ����̃`�F�b�N�ł��D
//    enemy
    /*�������܂�*/
    for (int i = 0; i < Layers.length; i++) {
      Iterator it = Layers[i].listIterator();
      while (it.hasNext()) {
        ( (object) (it.next())).Move();
      }
    }
    /*�����蔻��*/

    if (!isGameOver) { //�Q�[���I�[�o�[�Ȃ画�肵�Ȃ�
      Iterator it = Layers[this.ENEMY_BULL].listIterator(); //�G�e��
      while (it.hasNext()) {
        object obj = (object) it.next();
        obj.judge(myShip); //���@
      }
    }
    Iterator it2 = Layers[this.FRIEND_BULL].listIterator(); //���e��
    while (it2.hasNext()) {
      object obj = (object) it2.next();
      Iterator it3 = Layers[this.ENEMY_CHR].listIterator(); //�G�@
      while (it3.hasNext()) {
        object obj2 = (object) it3.next();
        obj.judge(obj2);
      }
    }
    /*�����̔���ł�*/
    for (int i = this.FRIEND_BULL; i <= this.ENEMY_BULL; i++) {
      Iterator it = Layers[i].listIterator();
      while (it.hasNext()) {
        chr obj = (chr) it.next();
        if (! (obj.isAlive())) { //����ł���Ȃ�C�폜���܂��D
          obj.Destroy(); //�����ŃX�R�A�Ȃ艽�Ȃ肵�Ă��������D
          if (obj.getCode() == object.CODE_FRIEND_CHR) {
            this.isAlive = false;
          }
          Objects--;
          it.remove();
        }
      }
    }
    /*�`���܂�*/
    for (int i = 0; i < Layers.length; i++) {
      Iterator it = Layers[i].listIterator();
      while (it.hasNext()) {
        ( (object) (it.next())).draw(g, (byte) 3);
      }
    }
  }

  private void end() {
    endFlag = true;
  }

  public long getNowTime() {
    return (new Date().getTime());
  }

  /**
   * ���̃t���[���Ɉڂ�܂őҋ@���܂��D
   */
  private synchronized void frameWait() {
    float interval = INTERVAL;
    /*
    int obj = this.getObjects();
    if (obj > 150) {
      interval += INTERVAL;
      if (obj > 200) {
        interval += INTERVAL;
      }
    }*/
    while ( (getNowTime() - nowTime) < interval) { //�P�t���[�������Ԃ��o�߂���܂ŁC�܂D
      try {
        wait(1);
      }
      catch (InterruptedException e) {}

    }
  }

  /**
   * ���@�𐶂݂܂��D
   */
  private void myShipBorn() {
    addShips( -1);
    this.addObj(myShip = new myShip01(this), this.FRIEND_CHR);
  }

  /**
   * ���@�����񂾂��ǂ����̃`�F�b�N�ł��D
   */
  private void deadCheck() {
    if (!isAlive) { //���@�Ȃ�
      if (getShips() > 0) { //�c�@������Ȃ�
        deleteAllObject(this.ENEMY_BULL); //�e�������܂��D
        deleteAllObject(this.ENEMY_CHR); //�G�������܂�
        myShipBorn();
        isAlive = true;
      }
      else { //�Q�[���I�[�o�[�ł�
        if (!isGameOver) { //�܂��Q�[���I�[�o�[�łȂ�
          Layers[this.SCORE].add(new GameOver(this)); //�Q�[���I�[�o�[���C��
          isGameOver = true;
        }
        else {
          if (endKeyPressedCount >= 0) {
            endKeyPressedCount--;
          }
        }
      }
    }
  }

  private void deleteAllObject(int Layer) {
    Objects -= Layers[Layer].size();
    Layers[Layer] = null;
    Layers[Layer] = new LinkedList();
  }

  /**
   * �G���𐶂݂܂�
   */
  /*
  public void enemyBorn() {
    this.addObj( (new enemy01(this,new point(point.getWidthSize() >> 2, -10 , 0, 0))),this.ENEMY_CHR);
    this.addObj( (new enemy01(this,new point((point.getWidthSize() >> 2) * 3, -10 , 0, 0))),this.ENEMY_CHR);

      case 1:
        this.addObj( (new enemy01(this,
                                  new point(rnd.nextInt(point.
            getWidthSize()), rnd.nextInt(point.getHeightSize() / 2), 0, 0))),
                    this.ENEMY_CHR);
        break;
      case 2:
        this.addObj( (new enemy02(this,
                                  new point(rnd.nextInt(point.
            getWidthSize()), rnd.nextInt(point.getHeightSize() / 2), 0, 0))),
                    this.ENEMY_CHR);
    }
  }*/

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
  public LinkedList[] getLayers() {
    return Layers;
  }

  /**
   * ���͂�Ԃ��܂�
   * @return byte
   */
  public byte getInput() {
    return GameFrame.getInput();
  }

  /**
   * �c�@��Ԃ��܂�
   * @return int
   */
  public int getShips() {
    return Ships;
  }

  /**
   * �c�@�𑝂₵���茸�炵����D
   * @param n int
   */
  public void addShips(int n) {
    Ships += n;
  }

  /**
   * �I�u�W�F�N�g��ǉ����܂��D
   * �e�̔������ȂǂɎg���܂��D
   * @param o Object
   * @param Layer int
   */
  public void addObj(object o, int Layer) {
    if (o.getCode() == object.CODE_ENEMY_CHR ||
        o.getCode() == object.CODE_ENEMY_BULL) {
      if (Objects < 245) {
//      if (Objects < 3000) {
        Objects++;
        Layers[Layer].addLast(o);
      }
    }
    else {
      Objects++;
      Layers[Layer].addLast(o);
    }
  }

  public point getShipPoint() {
    return myShip.getPoint();
  }

  /**
   * �X�R�A�������܂��D
   * @param score int
   */
  public void addScore(int score) {
    Score += score;
  }

  /**
   * �X�R�A�����炢�܂��D
   * @return int
   */
  public int getScore() {
    return Score;
  }

  public int getObjects() {
    return Objects;
  }

  public boolean isGameOver() {
    return isGameOver;
  }
  public long getFrameCount(){
    return frameCount;
  }
  /**
   * �����N��Ԃ��܂�
   * @return int
   */
  public int getRank(){
    return (int)(frameCount / 600);
  }
}
