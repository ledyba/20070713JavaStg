package shooting.GameMode.Stage.eachStage;

import shooting.GameMode.Stage.Stage;
import shooting.GameMode.*;
import shooting.GameMode.Stage.eachObject.back.*;
import shooting.GameMode.Stage.basic.object;
import java.util.LinkedList;
import java.util.*;
import java.awt.*;
import shooting.GameMode.Stage.basic.point;
import shooting.GameMode.Stage.basic.chr;

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
public class ModeSelect
    extends Stage {
  private LinkedList[] Layers;
  private int Objects = 0;
  private int whatToDo = GameCore.NOTHING;;
  private int nextStage;
  private Timer timer;
  private TimerTask task;
  boolean modeEndFlag = false;
  private long frameCount = 0;
  private GameCore gc;
  public ModeSelect(GameCore gc) {
    super();
    this.gc = gc;
    modeEndFlag = false;
  }

  public void run() {
    task = new TimerTask() {
      public void run() {
        if(whatToDo != GameCore.NOTHING){
          switch(whatToDo){
            case GameCore.GAME_START:
            case GameCore.EXIT:
              gc.setWhatToDo(whatToDo,0);
              modeEndFlag = true;
              break;
            case GameCore.RANKING:
            case GameCore.CONFIG:
              whatToDo = GameCore.NOTHING;
              break;
            default:
          }
        }else{
          frameCount++;
          //�I���Ƃ���modeEndFlag�����Ă邾���D
          Graphics g = GameFrame.getBuff().getDrawGraphics(); //�O���t�B�b�N�擾
          /*�������܂�*/
          for (int i = 0; i < Layers.length; i++) {
            Iterator it = Layers[i].listIterator();
            while (it.hasNext()) {
              ( (object) (it.next())).Move();
            }
          }
          /*�����̔���ł�*/
          for (int i = 1; i <= Stage.ENEMY_CHR; i++) {
            Iterator it = Layers[i].listIterator();
            while (it.hasNext()) {
              chr obj = (chr) it.next();
              if (! (obj.isAlive())) { //����ł���Ȃ�C�폜���܂��D
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
          GameFrame.getBuff().show(); //������
        }
      }
    };
    timer = new Timer();
    initFirst();//����������
    timer.schedule(task, 0, Stage.INTERVAL);//�����J�n
    this.setPriority(MIN_PRIORITY);//�ҋ@���邾���Ȃ̂�
    while (!modeEndFlag) {
      wait10ms();
    }
    task.cancel();
  }
  /**
   * �ŏ��Ɏg���鏉�����ł��D
   */
  private void initFirst(){
    whatToDo = GameCore.NOTHING;
    Layers = new LinkedList[NUMBER_OF_LAYERS];
    for (int i = 0; i < Layers.length; i++) {
      Layers[i] = new LinkedList();
    }
    addObj(new FillBlack(), Stage.BACK);
    addObj(new DrawLine(), Stage.BACK);
    addObj(new Score(this), Stage.SCORE);
    addObj(new ModeSelect_Title(),Stage.FRIEND_CHR);
    addObj(new ModeSelect_Menu(this),Stage.FRIEND_CHR);
  }
  private synchronized void wait10ms(){
    try {
      wait(10);
    }
      catch (InterruptedException e) {}
  }
  /**
   *
   * @param o Object
   * @param Layer int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public void addObj(object o, int Layer) {
    Objects++;
    Layers[Layer].addLast(o);
  }

  /**
   *
   * @param score int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public void addScore(int score) {
  }

  /**
   *
   * @param n int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public void addShips(int n) {
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public byte getInput() {
    return GameFrame.getInput();
  }

  /**
   *
   * @return LinkedList[]
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public LinkedList[] getLayers() {
    return Layers;
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public int getObjects() {
    return 0;
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public int getScore() {
    return 0;
  }

  /**
   *
   * @return point
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public point getShipPoint() {
    return null;
  }

  /**
   *
   * @return int
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public int getShips() {
    return 0;
  }

  /**
   *
   * @return boolean
   * @todo ���� shooting.GameMode.Stage.Stage ���\�b�h������
   */
  public boolean isGameOver() {
    return false;
  }
  public long getFrameCount(){
    return frameCount;
  }
  public int getRank(){
    return 0;
  }
  public long getNowTime() {
    return (new Date().getTime());
  }
  public void setWhatToDo(int Code,int stage){
    whatToDo = Code;
    nextStage = stage;
  }

}
