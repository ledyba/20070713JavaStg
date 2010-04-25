package shooting;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import shooting.GameMode.*;
/**
 * <p>タイトル: シューティングゲーム（仮）</p>
 * <p>説明: </p>
 * <p>著作権: Copyright (c) 2005 PSI</p>
 * <p>会社名: </p>
 * @author 未入力
 * @version 1.0
 */

public class Frame extends JFrame {
  /*自分で定義したもの*/
  protected boolean isFullScreen = false;//フルスクリーンフラグ
  protected int Width = 640;//横のサイズ
  protected int Height = 480;//縦のサイズ
  protected int BitDepth = 32;//色数の深さ
  GameFrame GameFrame;//フレーム
  /*自分で定義したもの　おわり*/
  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel TitleLabel = new JLabel();
  JPanel MenuPanel = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JPanel MenuIndexPanel = new JPanel();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JButton MainGameButton = new JButton();
  JButton TrainingGame = new JButton();
  JButton StageSelectButton = new JButton();
  JButton ScoreAttackButton = new JButton();
  JButton RankingButton = new JButton();
  JButton ConfigButton = new JButton();
  JButton ExitButton = new JButton();
  TitledBorder titledBorder1 = new TitledBorder("");
  //フレームのビルド
  public Frame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //コンポーネントの初期化
  private void jbInit() throws Exception  {
    image1 = new ImageIcon(shooting.Frame.class.getResource("openFile.png"));
    image2 = new ImageIcon(shooting.Frame.class.getResource("closeFile.png"));
    image3 = new ImageIcon(shooting.Frame.class.getResource("help.png"));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(204, 283));
    this.setTitle("シューティングゲーム（仮）");
    jMenuFile.setText("ファイル");
    jMenuFileExit.setText("終了");
    jMenuFileExit.addActionListener(new Frame_jMenuFileExit_ActionAdapter(this));
    jMenuHelp.setText("ヘルプ");
    jMenuHelpAbout.setText("バージョン情報");
    jMenuHelpAbout.addActionListener(new Frame_jMenuHelpAbout_ActionAdapter(this));
    TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    TitleLabel.setText("ショーティングゲーム（仮）");
    MenuPanel.setLayout(gridBagLayout1);
    MenuIndexPanel.setBorder(BorderFactory.createEtchedBorder());
    MenuIndexPanel.setLayout(gridBagLayout2);
    MainGameButton.setHorizontalAlignment(SwingConstants.LEADING);
    MainGameButton.setText("Main Game");
    MainGameButton.addActionListener(new Frame_MainGameButton_actionAdapter(this));
    TrainingGame.setHorizontalAlignment(SwingConstants.LEADING);
    TrainingGame.setText("Training");
    StageSelectButton.setHorizontalAlignment(SwingConstants.LEADING);
    StageSelectButton.setText("Stage Select");
    ScoreAttackButton.setHorizontalAlignment(SwingConstants.LEADING);
    ScoreAttackButton.setText("Score Atack");
    RankingButton.setHorizontalAlignment(SwingConstants.LEADING);
    RankingButton.setText("Ranking");
    ConfigButton.setHorizontalAlignment(SwingConstants.LEADING);
    ConfigButton.setText("Config");
    ExitButton.setToolTipText("");
    ExitButton.setHorizontalAlignment(SwingConstants.LEADING);
    ExitButton.setText("Exit");
    ExitButton.addActionListener(new Frame_ExitButton_actionAdapter(this));
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    this.setJMenuBar(jMenuBar1);
    contentPane.add(TitleLabel, java.awt.BorderLayout.NORTH);
    contentPane.add(MenuPanel, java.awt.BorderLayout.CENTER);
    MenuIndexPanel.add(ExitButton, new GridBagConstraints(0, 6, 1, 1, 1.0, 0.0
        , GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
        new Insets(0, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(MainGameButton,
                       new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(5, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(TrainingGame,
                       new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(0, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(StageSelectButton,
                       new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(0, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(ScoreAttackButton,
                       new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(0, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(RankingButton,
                       new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(0, 5, 5, 5), 0, 0));
    MenuIndexPanel.add(ConfigButton,
                       new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0
                                              , GridBagConstraints.CENTER,
                                              GridBagConstraints.HORIZONTAL,
                                              new Insets(0, 5, 5, 5), 0, 0));
    MenuPanel.add(MenuIndexPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
        , GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 10, 10, 10), 50, 10));
  }
  //[ファイル|終了]
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //[ヘルプ|バージョン情報]
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    Frame_AboutBox dlg = new Frame_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }
  //ウィンドウが閉じられたときに終了するようにオーバーライド
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }

  public void ExitButton_actionPerformed(ActionEvent e) {//Exit
    System.exit(0);
  }

  public void MainGameButton_actionPerformed(ActionEvent e) {
    GameFrame = new GameFrame(isFullScreen, Width, Height, BitDepth,this);
    this.setVisible(false);
  }
}

class Frame_MainGameButton_actionAdapter
    implements ActionListener {
  private Frame adaptee;
  Frame_MainGameButton_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.MainGameButton_actionPerformed(e);
  }
}

class Frame_ExitButton_actionAdapter
    implements ActionListener {
  private Frame adaptee;
  Frame_ExitButton_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.ExitButton_actionPerformed(e);
  }
}

class Frame_jMenuFileExit_ActionAdapter implements ActionListener {
  Frame adaptee;

  Frame_jMenuFileExit_ActionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuFileExit_actionPerformed(e);
  }
}

class Frame_jMenuHelpAbout_ActionAdapter implements ActionListener {
  Frame adaptee;

  Frame_jMenuHelpAbout_ActionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuHelpAbout_actionPerformed(e);
  }
}
