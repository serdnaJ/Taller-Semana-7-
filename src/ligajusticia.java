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
    private JTextArea txtlis;
    private JTextField txtnombre2;
    private JTextField txtsup2;
    private JTextField txtmision2;
    private JComboBox cbd2;
    private JTextField txtpago2;
    private JButton btnmodificar;
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
        btnlistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               txtlis.setText(listaheroes.toString());
            }
        });
        btnbus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                      int  id=Integer.parseInt(txtid2.getText());
                      Heroe indice=listaheroes.buscarPorId(id);
                      if (indice!=null){
                          txtnombre2.setText(indice.getNombre());
                          txtsup2.setText(indice.getSuperpoder());
                          txtmision2.setText(indice.getMision());
                          cbd2.setSelectedItem(indice.getDificultad());
                          txtpago2.setText(String.valueOf(indice.getPagoMensual()));
                      }


               } catch (Exception ex){
                   JOptionPane.showMessageDialog(null,
                           ex.getMessage());
               }

            }
        });
        btnmodificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtid2.getText());
                String nombre=txtnombre2.getText();
                String superpoder=txtsup2.getText();
                String mision=txtmision2.getText();
                int prioridad=Integer.parseInt(cbd2.getSelectedItem().toString());
                float pago=Float.parseFloat(txtpago2.getText());
                Heroe heroe1=new Heroe( id,nombre,superpoder,mision,prioridad,pago);
                listaheroes.modificarHeroe(id,heroe1);
                JOptionPane.showMessageDialog(null,"Heroe actualizado");
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

