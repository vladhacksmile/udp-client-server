import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GUIManager {

    private static boolean consoleMode = true;
    private static PriorityQueue<Organization> collection;
    private static Point startPosition = new Point(50, 50);
    private static ArrayList<OrganizationCircle> shapes = new ArrayList<>();

    public static void println(String text) {
        Main.mainForm.getLobbyForm().getTextArea1().append(text + "\n");
    }

    public static void print(String text) {
        Main.mainForm.getLobbyForm().getTextArea1().append(text);
    }

    public static String nextLine() {
        synchronized (Main.mainForm.getLobbyForm().getCurrThread()){
            try {
                Main.mainForm.getLobbyForm().getCurrThread().wait();
            } catch (InterruptedException interruptedException) {
                System.err.println(interruptedException.getMessage());
            }
            println(Main.mainForm.getLobbyForm().getValue());
            return Main.mainForm.getLobbyForm().getValue();
        }
    }

    public static boolean isConsoleMode() {
        return consoleMode;
    }

    public static void setConsoleMode(boolean status) {
        consoleMode = status;
    }

    public static void setCollection(PriorityQueue<Organization> objects) {
        collection = objects;
        if(Main.mainForm.getLobbyForm().getTabbedPane1().getSelectedIndex() == 1) {
            Main.mainForm.getLobbyForm().getTableModel().setRowCount(0);
            collection.stream().sorted(sort()).forEach(o -> Main.mainForm.getLobbyForm().getTableModel().addRow(new Object[]{o.getId(), o.getName(), o.getCoordinates().getX(), o.getCoordinates().getY(), Collection.getFormat().format(o.getCreationDate()), o.getAnnualTurnover(), o.getType(), Utils.getStreet(o.getOfficialAddress()), Utils.getZipCode(o.getOfficialAddress()), o.getAuthor()}));
        } else if (Main.mainForm.getLobbyForm().getTabbedPane1().getSelectedIndex() == 2) {
            updateShapes();
        }
    }

    public static void updateShapes() {
        int adderX = 0;
        int adderY = 0;
        shapes.clear();
        for(Organization o : collection) {
            shapes.add(new OrganizationCircle(new Ellipse2D.Double(startPosition.x + o.getCoordinates().getX(), startPosition.y + o.getCoordinates().getY(), 0, 0), o));
            adderX += 50;
            adderY += 50;
        }
    }

    public static Comparator<Organization> sort() {
        switch (Main.mainForm.getLobbyForm().getComboBox1().getSelectedIndex()) {
            case 0: return Comparator.comparingInt(Organization::getId);
            case 1: return Comparator.comparing(Organization::getName);
            case 2: return Comparator.comparing(o -> o.getCoordinates().getX());
            case 3: return Comparator.comparing(o -> o.getCoordinates().getY());
            case 4: return Comparator.comparing(Organization::getCreationDate);
            case 5: return Comparator.comparingInt(Organization::getAnnualTurnover);
            case 6: return Comparator.comparing(o -> Utils.TypeToStr(o.getType()));
            case 7: return Comparator.comparing(o -> Utils.getStreet(o.getOfficialAddress()));
            case 8: return Comparator.comparing(o -> Utils.getZipCode(o.getOfficialAddress()));
            case 9: return Comparator.comparing(Organization::getAuthor);
        }
        return Comparator.comparing(Organization::getName);
    }

    public static PriorityQueue<Organization> getCollection() {
        return collection;
    }

    public static ArrayList<OrganizationCircle> getShapes() {
        return shapes;
    }

    public static void setShapes(ArrayList<OrganizationCircle> array) {
        shapes = array;
    }
}

// То, что пытался реализовать:

/* // Множественное удаление элементов (багованное)
for (int selectedRow : collectionTable.getSelectedRows()) {
                    String[] r = {"remove_by_id", "" + (int) collectionTable.getModel().getValueAt(selectedRow, 0)};
                    UDPSocketClient.send(new Command(Auth.getUser(), r, null));
}
*/