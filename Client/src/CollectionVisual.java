import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CollectionVisual extends JPanel implements ActionListener {

    private Dimension size;
    private Timer timer = new Timer(20, this);
    private Double theta= new Double(0);
    private Double change = new Double(0.1);
    private int pulse;
    private boolean effect;
    private int radius = 15;

    public CollectionVisual() {
        Thread updateThread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(1000);
                    Main.mainForm.getLobbyForm().updateCollectionForVisual();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        updateThread.start();
        timer.start();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    for (OrganizationCircle organizationCircle : GUIManager.getShapes()) {
                        if (organizationCircle.getShape().contains(e.getPoint())) {
                            Organization o = organizationCircle.getOrganization();
                            AddElement addElement = new AddElement(organizationCircle.getOrganization());
                            return;
                        }
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        theta = theta + change;
        if(!effect) {
            pulse++;
            if (pulse >= 10) {
                effect = true;
            }
        } else {
            pulse--;
            if(pulse == 0) {
                effect = false;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //size = new Dimension(Main.mainForm.getLobbyForm().getFrame().getWidth(), Main.mainForm.getLobbyForm().getFrame().getHeight());
       // int startX = (int) (size.getWidth() / 2);
      //  int startY = (int) (size.getHeight() / 2);
        GradientPaint paint;

        //Double x = new Double(200+(50*(Math.cos(theta))));
        //Double y = new Double(200+(50*(Math.sin(theta))));
        //int xp = x.intValue();
        //int yp = y.intValue();

        int adder = 50; //startX + xp + adder
        try {
            for (OrganizationCircle circle : GUIManager.getShapes()) {
                paint = new GradientPaint((float) (circle.getShape().getX()), (float) (circle.getShape().getY()), Color.decode(String.valueOf(circle.getOrganization().getAuthor().hashCode())), radius * 2 + pulse, radius * 2 + pulse, Color.CYAN); // Color.decode(String.valueOf(o.getAuthor().hashCode() * 1000))
                g2.setPaint(paint);
                circle.getShape().setFrame(circle.getShape().getX(), circle.getShape().getY(), radius * 2 + pulse, radius * 2 + pulse);
                g2.fill(circle.getShape());
                adder += 50;
            }
        } catch (Exception e) {

        }
    }

}
