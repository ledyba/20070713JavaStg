package shooting.GameMode;

import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.*;

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
public class GameFrame  extends JFrame {
  GraphicsDevice device;
  DisplayMode oldMode;
  protected static final String FrameTitle = "�V���[�e�B���O�Q�[���i���j";
  protected static final int BufferSize = 2;//�o�b�t�@�̖���
  public static BufferStrategy bs;//�o�b�t�@
  protected static boolean isFullScreen = false;//�t���X�N���[���t���O
  protected static int Width = 0;//���̃T�C�Y
  protected static int Height = 0;//�c�̃T�C�Y
  protected static int BitDepth = 0;//�F���̐[��
  protected static Object called = null;//�Ăяo�����ł�
  public GameFrame(boolean isFullScreen, int Width,int Height,int BitDepth, Object called) {
    try {
      this.called = called;
      this.isFullScreen = isFullScreen;
      this.Width = Width;//���̃T�C�Y
      this.Height = Height;//�c�̃T�C�Y
      this.BitDepth = BitDepth;//�F���̐[��
      jbInit();
      start();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setTitle(this.FrameTitle);
    //this.createBufferStrategy(this.BufferSize);//�o�b�t�@�̐���
    //this.bs = this.getBufferStrategy();//�o�b�t�@�ɃA�N�Z�X���₷�����邽�߂ɖ��O�͒Z�����悤

    KeyListener EscCheck = new EscCheck();
    this.addKeyListener(EscCheck);
  }
  //�E�B���h�E������ꂽ�Ƃ��ɏI������悤�ɃI�[�o�[���C�h
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      EscTyped();//ESC�������ꂽ�̂Ɠ��������ɂ��܂��D
      /*
      if(isFullScreen){
        device.setDisplayMode(oldMode);
        device.setFullScreenWindow(null);
      }
      System.exit(0);//�I��
      */
    }
  }
  public void start(){//�͂��߂鎞�ɓǂݍ���
    if(isFullScreen){//�t���X�N���[�����[�h
      this.setUndecorated(true);//�E�C���h�E�C���𖳌��ɂ���
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//��ʊ��̎擾
      device = ge.getDefaultScreenDevice();//�f�o�C�X�̎擾
      GraphicsConfiguration gc = device.getDefaultConfiguration();//�f�t�H���g�ݒ���擾
      oldMode = device.getDisplayMode();//���ɖ߂��Ƃ��̐ݒ���擾
      DisplayMode mode = new DisplayMode(Width, Height, BitDepth, DisplayMode.REFRESH_RATE_UNKNOWN);//��ʃ��[�h
      device.setFullScreenWindow(this);//�t���X�N���[��
      device.setDisplayMode(mode);
    }else{//�E�B���h�E���[�h
      this.setSize(Width,Height);
      /*�f�B�X�v���C���[�h�̎擾*/
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = ge.getDefaultScreenDevice();
      DisplayMode disMode = device.getDisplayMode();
      //��ʂ̒��S�ɕ`��
      this.setLocation((disMode.getWidth()-Width) / 2, (disMode.getHeight() - Height) / 2 );
      //this.setModal(true);
      //this.pack();
      //this.show();
    }
    this.setVisible(true);
  }
  public void exit(){//�I���Ƃ��ɓǂ݂���
    if(isFullScreen){
      device.setDisplayMode(oldMode);
      device.setFullScreenWindow(null);
    }
  }
  protected static void EscTyped(){//ESC�L�[�������ꂽ�Ƃ��̑Ώ��ł��D
    System.exit(0);
  }
  class EscCheck implements KeyListener{//Esc�ł̃Q�[���̏I�����֒m���܂�
    public void keyPressed(KeyEvent e){
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//ESC�������Ă���Ȃ��
        GameFrame.EscTyped();
      }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
  }
}
