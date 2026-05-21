import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ligajusticia {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField txtnombre;
    private JSpinner spid;
    private JTextField txtsuperpoder;
    private JTextField txtmision;
    private JComboBox cbd;
    private JButton btnagregar;
    private JTextField txtpago;
    private JButton btnlistar;
    private JTextField txtid2;
    private JButton btnbus;
    GestorMisiones listaheroes=new GestorMisiones();

    public ligajusticia() {
        btnagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(spid.getValue().toString());
                String nombre=txtnombre.getText();
                String superpoder=txtsuperpoder.getText();
                String mision=txtmision.getText();
                int prioridad=Integer.parseInt(cbd.getSelectedItem().toString());
                float pago=Float.parseFloat(txtpago.getText());
                Heroe heroe1=new Heroe( id,nombre,superpoder,mision,prioridad,pago);
                if(listaheroes.registrarHeroe(heroe1)==true){
                    JOptionPane.showMessageDialog(null,
                            "Heroe agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Revise el id del heroe");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ligajusticia");
        frame.setContentPane(new ligajusticia().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

