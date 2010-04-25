package shooting;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import shooting.GameMode.*;
/**
 * <p>�^�C�g��: �V���[�e�B���O�Q�[���i���j</p>
 * <p>����: </p>
 * <p>���쌠: Copyright (c) 2005 PSI</p>
 * <p>��Ж�: </p>
 * @author ������
 * @version 1.0
 */

public class Frame extends JFrame {
  /*�����Œ�`��������*/
  protected boolean isFullScreen = false;//�t���X�N���[���t���O
  protected int Width = 640;//���̃T�C�Y
  protected int Height = 480;//�c�̃T�C�Y
  protected int BitDepth = 32;//�F���̐[��
  GameFrame GameFrame;//�t���[��
  /*�����Œ�`�������́@�����*/
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
  //�t���[���̃r���h
  public Frame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //�R���|�[�l���g�̏�����
  private void jbInit() throws Exception  {
    image1 = new ImageIcon(shooting.Frame.class.getResource("openFile.png"));
    image2 = new ImageIcon(shooting.Frame.class.getResource("closeFile.png"));
    image3 = new ImageIcon(shooting.Frame.class.getResource("help.png"));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(204, 283));
    this.setTitle("�V���[�e�B���O�Q�[���i���j");
    jMenuFile.setText("�t�@�C��");
    jMenuFileExit.setText("�I��");
    jMenuFileExit.addActionListener(new Frame_jMenuFileExit_ActionAdapter(this));
    jMenuHelp.setText("�w���v");
    jMenuHelpAbout.setText("�o�[�W�������");
    jMenuHelpAbout.addActionListener(new Frame_jMenuHelpAbout_ActionAdapter(this));
    TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    TitleLabel.setText("�V���[�e�B���O�Q�[���i���j");
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
  //[�t�@�C��|�I��]
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //[�w���v|�o�[�W�������]
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
  //�E�B���h�E������ꂽ�Ƃ��ɏI������悤�ɃI�[�o�[���C�h
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
