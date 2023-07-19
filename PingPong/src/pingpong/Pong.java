package pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.sampled.*;

public class Pong extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    static final int HEIGHT = 600;

    private Paddle paddleLeft;
    private Paddle paddleRight;
    private Ball ball;

    private int scoreLeft;
    private int scoreRight;
    static int paddleSpeed;

    private Timer timer;
    private Timer speedTimer;

    private Clip paddleCollisionClip;
    private Clip wallCollisionClip;
    private Clip scoreClip;

    private boolean isAgainstComputer;

    public Pong(boolean againstComputer) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        paddleSpeed = 3;

        paddleLeft = new Paddle(20, HEIGHT / 2 - 40, 20, 80, Color.WHITE, KeyEvent.VK_W, KeyEvent.VK_S);
        paddleRight = new Paddle(WIDTH - 40, HEIGHT / 2 - 40, 20, 80, Color.WHITE, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
paddleRight.setAIDifficulty(0.5); // Ajusta la dificultad de la IA (valor entre 0 y 1)
        ball = new Ball(WIDTH / 2 - 10, HEIGHT / 2 - 10, Color.WHITE);

        isAgainstComputer = againstComputer;
        if (againstComputer) {
            paddleRight.setAIEnabled(true);
        } else {
            paddleRight.setAIEnabled(false);
        }

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paddleLeft.keyPressed(e);
                paddleRight.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                paddleLeft.keyReleased(e);
                paddleRight.keyReleased(e);
            }
        });
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer(5, this);
        timer.start();

        scoreLeft = 0;
        scoreRight = 0;

        speedTimer = new Timer(15000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ball.increaseSpeed();
                increasePaddleSpeed();
            }
        });
        speedTimer.start();

        try {
            paddleCollisionClip = AudioSystem.getClip();
            AudioInputStream paddleCollisionStream = AudioSystem.getAudioInputStream(getClass().getResource("Raqueta.wav"));
            paddleCollisionClip.open(paddleCollisionStream);

            wallCollisionClip = AudioSystem.getClip();
            AudioInputStream wallCollisionStream = AudioSystem.getAudioInputStream(getClass().getResource("Rebote.wav"));
            wallCollisionClip.open(wallCollisionStream);

            scoreClip = AudioSystem.getClip();
            AudioInputStream scoreStream = AudioSystem.getAudioInputStream(getClass().getResource("Gol.wav"));
            scoreClip.open(scoreStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

   private void update() {
    paddleLeft.update(ball.getY());
    paddleRight.update(ball.getY());
    ball.update();

        if (ball.getBounds().intersects(paddleLeft.getBounds()) || ball.getBounds().intersects(paddleRight.getBounds())) {
            ball.reverseXDirection();
            playCollisionSound(paddleCollisionClip);
        }

        if (ball.getY() <= 0 || ball.getY() >= HEIGHT - 20) {
            ball.reverseYDirection();
            playCollisionSound(wallCollisionClip);
        }

        if (ball.getX() <= 0) {
            scoreRight++;
            playCollisionSound(scoreClip);
            reset();
        } else if (ball.getX() >= WIDTH - 20) {
            scoreLeft++;
            playCollisionSound(scoreClip);
            reset();
        }
    }

public void paintComponent(Graphics g) {
    super.paintComponent(g);

    paddleLeft.draw(g);
    paddleRight.draw(g);
    ball.draw(g);

    Graphics2D g2d = (Graphics2D) g;

    // Configurar el grosor de la línea
    g2d.setStroke(new BasicStroke(4)); // Grosor de línea de 4 píxeles

    // Dibujar línea segmentada
    float dash1[] = {10.0f};
    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
    g2d.setColor(Color.WHITE);
    g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

    g.setFont(new Font("Arial", Font.BOLD, 20));
    FontMetrics fontMetrics = g.getFontMetrics();
    int scoreLeftX = (WIDTH / 2 - fontMetrics.stringWidth("Puntuación: " + scoreLeft)) / 2;
    int scoreRightX = WIDTH / 2 + (WIDTH / 2 - fontMetrics.stringWidth("Puntuación: " + scoreRight)) / 2;
    int scoreY = fontMetrics.getHeight();
    g.drawString("Puntuación: " + scoreLeft, scoreLeftX, scoreY);
    g.drawString("Puntuación: " + scoreRight, scoreRightX, scoreY);
}

    private static void increasePaddleSpeed() {
        paddleSpeed++;
    }

    private void reset() {
        paddleSpeed = 3;
        paddleLeft.reset();
        paddleRight.reset();
        ball.reset();
    }

    private void playCollisionSound(Clip clip) {
        clip.setFramePosition(0);
        clip.start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            boolean againstComputer = showMenu();
            if (againstComputer) {
                JFrame frame = new JFrame("Pong");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.getContentPane().add(new Pong(true));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } else {
                // Persona vs Persona
                JFrame frame = new JFrame("Pong");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.getContentPane().add(new Pong(false));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
private static boolean showMenu() {
    String[] options = {"Persona vs Persona", "Persona vs Computadora"};
    int choice = JOptionPane.showOptionDialog(null, "Selecciona el modo de juego", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    if (choice == JOptionPane.CLOSED_OPTION) {
        System.exit(0); // Sale del programa si se cierra el cuadro de diálogo
    }
    return (choice == 1);
}
}