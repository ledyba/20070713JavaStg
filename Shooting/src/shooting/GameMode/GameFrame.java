package shooting.GameMode;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

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
public class GameFrame
    extends JFrame {
  GraphicsDevice device;
  DisplayMode oldMode;
  protected static final String FrameTitle = "�V���[�e�B���O�Q�[���i���j";
  protected static final int BufferSize = 2; //�o�b�t�@�̖���
  public static BufferStrategy bs; //�o�b�t�@
  public static final boolean isFullScreen = false; //�t���X�N���[���t���O
  public static final int Width = 640; //���̃T�C�Y
  public static final int Height = 480;//�c�̃T�C�Y
  public static final int BitDepth = 32; //�F���̐[��
  public static final int RefreshRate = 60; //���t���b�V�����[�g
  public static BufferStrategy bS; //�o�b�t�@�ł��D
  private boolean isReady = false;

  /**���͂ł��D
   *   1:��
   *   2:��
   *   4:��
   *   8:��
   *  16:�{�^���P
   *  32:�{�^���Q
   *  64:�{�^���R
   */
  private static byte Input = 0;
  public static final int KEY[] = {
      KeyEvent.VK_UP,
      KeyEvent.VK_DOWN,
      KeyEvent.VK_RIGHT,
      KeyEvent.VK_LEFT,
      KeyEvent.VK_SPACE,
      KeyEvent.VK_V,
      KeyEvent.VK_B,
  };

  public static synchronized void setInput(byte input) {
    Input = input;
  }

  public static synchronized byte getInput() {
    return Input;
  }
  public boolean isReady(){
    return isReady;
  }
  public GameFrame() {
    Input = 0;//���̓j���[�g����
    try {
      jbInit();
      start();
      //�o�b�t�@�̏���
      createBufferStrategy(2);
      bS = getBufferStrategy();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
    isReady = true;
  }

  private void jbInit() throws Exception {
    this.setResizable(false);
    this.setTitle(this.FrameTitle);
    KeyListener KeyCheck = new KeyCheck();
    this.addKeyListener(KeyCheck);
  }

  //�E�B���h�E������ꂽ�Ƃ��ɏI������悤�ɃI�[�o�[���C�h
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      EscTyped(); //ESC�������ꂽ�̂Ɠ��������ɂ��܂��D
    }
  }

  public void start() { //�͂��߂鎞�ɓǂݍ���
    this.setUndecorated(true); //�E�C���h�E�C���𖳌��ɂ���
    if (isFullScreen) { //�t���X�N���[�����[�h
      this.setUndecorated(true); //�E�C���h�E�C���𖳌��ɂ���
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //��ʊ��̎擾
      device = ge.getDefaultScreenDevice(); //�f�o�C�X�̎擾
      GraphicsConfiguration gc = device.getDefaultConfiguration(); //�f�t�H���g�ݒ���擾
      oldMode = device.getDisplayMode(); //���ɖ߂��Ƃ��̐ݒ���擾
      DisplayMode mode = new DisplayMode(Width, Height, BitDepth, DisplayMode.REFRESH_RATE_UNKNOWN); //��ʃ��[�h
      device.setFullScreenWindow(this); //�t���X�N���[��
      device.setDisplayMode(mode);
    }
    else { //�E�B���h�E���[�h
      this.setSize(Width, Height);
      /*�f�B�X�v���C���[�h�̎擾*/
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = ge.getDefaultScreenDevice();
      DisplayMode disMode = device.getDisplayMode();
      //��ʂ̒��S�ɕ`��
      this.setLocation( (disMode.getWidth() - Width) / 2,
                       (disMode.getHeight() - Height) / 2);
      //this.setModal(true);
      //this.pack();
      //this.show();
    }
    this.setVisible(true);
  }

  public static BufferStrategy getBuff() { //�o�b�t�@��Ԃ��܂��D
    return bS;
  }

  public void exit() { //�I���Ƃ��ɓǂ݂���
    if (isFullScreen) {
      device.setDisplayMode(oldMode);
      device.setFullScreenWindow(null);
    }
    for(int i =0; i<this.getKeyListeners().length;i++){
      this.removeKeyListener(this.getKeyListeners()[i]);
    }
  }

  protected void EscTyped() { //ESC�L�[�������ꂽ�Ƃ��̑Ώ��ł��D
    System.exit(0);
  }

  class KeyCheck
      implements KeyListener { //Esc�ł̃Q�[���̏I�����֒m���܂�
    public final int[] KEY = GameFrame.KEY;
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { //ESC�������Ă���Ȃ��
        EscTyped();
      }
      byte keyCode = 1;
      for (int i = 0; i <= 6; i++) {
        if (e.getKeyCode() == KEY[i]) {
          //System.out.println(i);
          GameFrame.setInput( (byte) (getInput() | keyCode)); //�t���O����
        }
        keyCode *= 2; //�ׂ�����v�Z���܂��D
      }
    }

    public void keyReleased(KeyEvent e) {
      byte keyCode = 1;
      for (int i = 0; i <= 6; i++) {
        if (e.getKeyCode() == KEY[i]) {
          GameFrame.setInput( (byte) (getInput() & ~ (keyCode))); //�t���O����
        }
        keyCode *= 2; //�ׂ���v�Z
      }
    }

    public void keyTyped(KeyEvent e) {}
  }
}
