package org.ciberfarma.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ciberfarma.modelo.Usuario;

public class JPA_Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		
		//Si le quita sel c�digo se agregar� solo porque tiene autoincrementado
		//u.setCodigo(11);
		u.setNombre("Rocky");
		u.setApellido("Balboa");
		u.setUsuario("holagil"); //tiene propiedad UNIQUE
		u.setClave("12345");
		u.setFnacim("2007/05/07");
		u.setTipo(1);
		u.setEstado(1);
		
		//Llamamos al Manager o Administrador de la Entidad
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = factory.createEntityManager();
			
		//Listado de Usuarios
		List<Usuario> lstUsuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
		if(lstUsuarios == null) {
			System.out.println("No existe ninguna lista");
		}else {
			for (Usuario u2 : lstUsuarios) {
				System.out.println("*********************USUARIO*********************");
				System.out.println("El nombre del usuario es   : " + u2.getNombre());
				System.out.println("El apellido del usuario es : " + u2.getApellido());
				System.out.println("*************************************************");
			}
		}	
		
		/*********************************************************************************/	
		/*//Consultas o Busquedas JPA
		Usuario u2 = em.find(Usuario.class, 3);
		if(u2 == null) {
			System.out.println("Usuario no Existe");
		}else {
			System.out.println("El nombre del usuario es   : " + u2.getNombre());
			System.out.println("El apellido del usuario es : " + u2.getApellido());
		}*/		
		/*********************************************************************************/	
		/*//Para el Registro	
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al Registrar " + e.getMessage());
		}*/		
		/*********************************************************************************/
		/*//Si el c�digo existe, actualizar� y sino, insertar�
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al Registrar " + e.getMessage());
		}*/
	}
	
}
