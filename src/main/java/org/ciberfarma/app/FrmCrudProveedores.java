package org.ciberfarma.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmCrudUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtFnacim;
	private JTextField txtClave;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnRegistrar;
	private JTextArea txtS;
	private JButton btnListado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNombre.setBounds(24, 54, 97, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblApellido.setBounds(24, 97, 97, 16);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(159, 95, 163, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(159, 52, 163, 22);
		contentPane.add(txtNombre);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Método para Registrar
				registrar();
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnRegistrar.setBounds(359, 21, 136, 25);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Método para actualizar
				actualizar();
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnActualizar.setBounds(359, 61, 136, 25);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//método para eliminar
				eliminar();
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnEliminar.setBounds(359, 99, 136, 25);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Método para buscar
				buscar();
			}
			
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnBuscar.setBounds(359, 137, 136, 25);
		contentPane.add(btnBuscar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblUsuario.setBounds(24, 140, 97, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblApellido_1_1 = new JLabel("Clave:");
		lblApellido_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblApellido_1_1.setBounds(24, 183, 97, 16);
		contentPane.add(lblApellido_1_1);
		
		JLabel lblApellido_1_1_1 = new JLabel("Fnacim:");
		lblApellido_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblApellido_1_1_1.setBounds(24, 231, 97, 16);
		contentPane.add(lblApellido_1_1_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(159, 139, 163, 22);
		contentPane.add(txtUsuario);
		
		txtFnacim = new JTextField();
		txtFnacim.setColumns(10);
		txtFnacim.setBounds(159, 230, 163, 22);
		contentPane.add(txtFnacim);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(159, 182, 163, 22);
		contentPane.add(txtClave);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblCdigo.setBounds(24, 13, 97, 16);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(159, 12, 163, 22);
		contentPane.add(txtCodigo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 274, 523, 193);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Botón listado
				listado();
			}
		});
		btnListado.setBounds(359, 245, 136, 26);
		contentPane.add(btnListado);
		
	}
	
	protected void eliminar() {
		// TODO Auto-generated method stub
		
	}

	protected void actualizar() {
		// TODO Auto-generated method stub
		
	}

	protected void registrar() {
		String nombre = leerNombre();
		String apellido = leerApellido();
		String usuario = leerUsuario();
		String clave = leerClave();
		String fnacim = leerFnacim();
		
	}
	
	private String leerFnacim() {
		if(!txtFnacim.getText().matches("")) {
			return null;
		}
		return txtFnacim.getText();
	}

	private String leerClave() {
		if(!txtClave.getText().matches("")) {
			return txtClave.getText();
		}
		return null;
	}

	private String leerUsuario() {
		if(!txtUsuario.getText().matches("")) {
			return null;
		}
		return txtUsuario.getText();
	}

	private String leerApellido() {
		if(!txtApellido.getText().matches("")) {
			return null;
		}
		return txtApellido.getText();
	}

	private int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	
	private String leerNombre() {
		if(!txtNombre.getText().matches("")) {
			return null;
		}
		return txtNombre.getText();
	}

	protected void buscar() {

				//leer el codigo
				int codigo = leerCodigo();
				//buscarlo en la tabla, para obtener un Usuario
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_sesion01");
				EntityManager em = factory.createEntityManager();
				
				Usuario u = em.find(Usuario.class,codigo);
				em.close();
				
				if(u == null) {
					aviso("Usuario " + codigo + " no existe!!");
				}else {
					txtNombre.setText(u.getNombre());
					txtApellido.setText(u.getApellido());
					txtUsuario.setText(u.getUsuario());
					txtClave.setText(u.getClave());
					txtFnacim.setText(u.getFnacim());			
				}
	}
	
	protected void listado() {

			// Obtener un listado de los Usuarios
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
			EntityManager em = fabrica.createEntityManager();		

			//TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
			//List<Usuario> lstUsuarios = consulta.getResultList();
			
			TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAllwithType", Usuario.class);
			consulta.setParameter("xtipo", 1);
			List<Usuario> lstUsuarios = consulta.getResultList();
			em.close();

			// pasar el listado a txt,..
			for (Usuario u : lstUsuarios) {
				txtS.append(u.getCodigo() + "\t" + u.getNombre() +
						"\t" + u.getApellido() + "\n");
			}	

		}

	private void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg,"Aviso del Sistema",JOptionPane.WARNING_MESSAGE);		
	}

}
