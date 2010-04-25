package shooting.GameMode;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 *
 * <p>説明: </p>
 *
 * <p>著作権: Copyright (c) 2005 PSI</p>
 *
 * <p>会社名: </p>
 *
 * @author 未入力
 * @version 1.0
 */
public class GameFrame
    extends JFrame {
  GraphicsDevice device;
  DisplayMode oldMode;
  protected static final String FrameTitle = "シューティングゲーム（仮）";
  protected static final int BufferSize = 2; //バッファの枚数
  public static BufferStrategy bs; //バッファ
  public static final boolean isFullScreen = false; //フルスクリーンフラグ
  public static final int Width = 640; //横のサイズ
  public static final int Height = 480;//縦のサイズ
  public static final int BitDepth = 32; //色数の深さ
  public static final int RefreshRate = 60; //リフレッシュレート
  public static BufferStrategy bS; //バッファです．
  private boolean isReady = false;

  /**入力です．
   *   1:↑
   *   2:↓
   *   4:→
   *   8:←
   *  16:ボタン１
   *  32:ボタン２
   *  64:ボタン３
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
    Input = 0;//入力ニュートラル
    try {
      jbInit();
      start();
      //バッファの準備
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

  //ウィンドウが閉じられたときに終了するようにオーバーライド
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      EscTyped(); //ESCが押されたのと同じ扱いにします．
    }
  }

  public void start() { //はじめる時に読み込む
    this.setUndecorated(true); //ウインドウ修飾を無効にする
    if (isFullScreen) { //フルスクリーンモード
      this.setUndecorated(true); //ウインドウ修飾を無効にする
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //画面環境の取得
      device = ge.getDefaultScreenDevice(); //デバイスの取得
      GraphicsConfiguration gc = device.getDefaultConfiguration(); //デフォルト設定を取得
      oldMode = device.getDisplayMode(); //元に戻すときの設定を取得
      DisplayMode mode = new DisplayMode(Width, Height, BitDepth, DisplayMode.REFRESH_RATE_UNKNOWN); //画面モード
      device.setFullScreenWindow(this); //フルスクリーン
      device.setDisplayMode(mode);
    }
    else { //ウィンドウモード
      this.setSize(Width, Height);
      /*ディスプレイモードの取得*/
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = ge.getDefaultScreenDevice();
      DisplayMode disMode = device.getDisplayMode();
      //画面の中心に描写
      this.setLocation( (disMode.getWidth() - Width) / 2,
                       (disMode.getHeight() - Height) / 2);
      //this.setModal(true);
      //this.pack();
      //this.show();
    }
    this.setVisible(true);
  }

  public static BufferStrategy getBuff() { //バッファを返します．
    return bS;
  }

  public void exit() { //終わるときに読みこむ
    if (isFullScreen) {
      device.setDisplayMode(oldMode);
      device.setFullScreenWindow(null);
    }
    for(int i =0; i<this.getKeyListeners().length;i++){
      this.removeKeyListener(this.getKeyListeners()[i]);
    }
  }

  protected void EscTyped() { //ESCキーが押されたときの対処です．
    System.exit(0);
  }

  class KeyCheck
      implements KeyListener { //Escでのゲームの終了を関知します
    public final int[] KEY = GameFrame.KEY;
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { //ESCを押しているならば
        EscTyped();
      }
      byte keyCode = 1;
      for (int i = 0; i <= 6; i++) {
        if (e.getKeyCode() == KEY[i]) {
          //System.out.println(i);
          GameFrame.setInput( (byte) (getInput() | keyCode)); //フラグたて
        }
        keyCode *= 2; //べき乗を計算します．
      }
    }

    public void keyReleased(KeyEvent e) {
      byte keyCode = 1;
      for (int i = 0; i <= 6; i++) {
        if (e.getKeyCode() == KEY[i]) {
          GameFrame.setInput( (byte) (getInput() & ~ (keyCode))); //フラグ引き
        }
        keyCode *= 2; //べき乗計算
      }
    }

    public void keyTyped(KeyEvent e) {}
  }
}
